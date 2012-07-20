package src.org.lhp.security.core.service;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

/**
* TODO 资源访问授权
* @Title : CustomAccessDecisionManager.java
* @author liheping 2012-4-19 上午10:26:49
* @version : V1.0 2012-4-19 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public class CustomAccessDecisionManager implements AccessDecisionManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAccessDecisionManager.class);
	//检查权限
	@Override
	public void decide(Authentication authentication, Object url,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		//如果该资源无需权限.则验证通过
		if (configAttributes == null) {
			LOGGER.info("资源权限认证");
			//如果该资源无需权限.则验证通过
			if (CollectionUtils.isEmpty(configAttributes)) {
				//return;
				LOGGER.info("资源权限为空");
				throw new AccessDeniedException("no right");
			}
		}

		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		//遍历当前资源的所需的权限
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig) ca).getAttribute();
			//遍历 当前 个体的所有权限
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				//匹配
				if (needRole.equals(ga.getAuthority())) { // ga is user's role.
					//匹配成功,表示当前个体拥有访问当前资源的权限,验证通过
					return;
				}
			}
		}
		//如果代码执行到这里,代表验证不通过,抛出异常
		throw new AccessDeniedException("no right"); 
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

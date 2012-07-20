package src.org.lhp.security.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import src.org.lhp.security.core.bean.ResourceTools;
import src.org.lhp.security.core.tool.AntUrlPathMatcher;
import src.org.lhp.security.core.tool.UrlMatcher;
import src.org.lhp.security.lusrmgr.dao.ResourceDAO;
import src.org.lhp.security.lusrmgr.domain.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
* TODO 初始化的时候,加载所有资源及其对应的角色
* @Title : CustomSecurityMetadataSource.java
* @author liheping 2012-4-19 上午10:26:16
* @version : V1.0 2012-4-19 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public final class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSecurityMetadataSource.class);
	/** 
	* @Fields urlMatcher  
	* @Description :   URL匹配器
	*/ 
	private UrlMatcher urlMatcher = new AntUrlPathMatcher(); 
	
	/**
	* @Fields resourceMap  
	* @Description :  资源-权限 映射 
	*/ 
	private final static Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	@Autowired
	@Qualifier("resourceDAO")
	private ResourceDAO resourceDAO;
    /** 
    * TODO  加载资源
    * @Title: loadResourceDefine     
    * @return void 
    * @author liheping    2012-4-10  下午04:02:56
    */ 
    public  void loadResourceDefine() {
    	LOGGER.info("|==============================================|");
    	LOGGER.info("|=============FMS MVC开始加载认证资源===========|");
    	LOGGER.info("|==============================================|");
    	try {
    		loadResourceProcess();
		} catch (Exception e) {
			LOGGER.info("|==============================================|");
	    	LOGGER.info("|================资源加载时发生异常=============|");
	    	LOGGER.info("|==============================================|");
	    	LOGGER.error("|================异常信息如下===================|");
	    	LOGGER.error("----> ",e);
	    	return;
		}
    	LOGGER.info("|==============================================|");
    	LOGGER.info("|===================资源加载完毕================|");
    	LOGGER.info("|==============================================|");
    }
    private void loadResourceProcess(){
    	String hql = "select r,r.authoritys from Resource r where r.enabled=true";
    	@SuppressWarnings("unchecked")
		Page<Resource> page = (Page<Resource>) this.resourceDAO.findByHQL(hql,null, null, Resource.class, null);
    	
//    	List<Resource> resources = this.resourceDAO.findByEnabled(true);
    	List<Resource> resources = page.getContent();
    	if(org.springframework.util.CollectionUtils.isEmpty(resources))
    		return;
    	for (Resource resource : resources) {
    		if(null==resource) continue;
    		resourceMap.put(resource.getURI(), ResourceTools.getConfigAttributes(resource));
		}
    }
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException {
		String url = ((FilterInvocation)object).getRequestUrl();
		//
		LOGGER.info("加载url:"+url+" , 的权限");
		//
		for (String resURL : resourceMap.keySet()) {
			if (urlMatcher.pathMatchesUrl(resURL, url)) 
                return resourceMap.get(resURL);
		}
		
		//模拟
		Collection<ConfigAttribute> results =  new ArrayList<ConfigAttribute>();
		results.add(new SecurityConfig("ROLE_ADMIN"));
        return results;
	}
	 
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

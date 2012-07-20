/**
 * 
 */
package src.org.lhp.security.core.bean;

import java.util.ArrayList;
import java.util.Collection;

import src.org.lhp.security.lusrmgr.domain.Authority;
import src.org.lhp.security.lusrmgr.domain.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

/**
 * TODO
 * 
 * @Title : ResourceTools.java
 * @author liheping 2012-4-12 下午02:48:34
 * @version : V1.0 2012-4-12
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
public final class ResourceTools {
	private ResourceTools() {
	}

	/** 
	* TODO  将Resource中关联的Set<Authority>转化成Collection<ConfigAttribute>
	* @Title: getConfigAttributes 
	* @param resource
	* @return    
	* @return Collection<ConfigAttribute> 
	* @author liheping    2012-4-12  下午03:40:41
	*/ 
	public synchronized static Collection<ConfigAttribute> getConfigAttributes(Resource resource) {
		Collection<ConfigAttribute> results =  new ArrayList<ConfigAttribute>();
		for (Authority val : resource.getAuthoritys()) {
			results.add(new SecurityConfig(val.getAuthorityName()));
		}
		return results;
	}
}
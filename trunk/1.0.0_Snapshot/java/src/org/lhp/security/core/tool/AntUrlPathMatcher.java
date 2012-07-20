/**
 * 
 */
package src.org.lhp.security.core.tool;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * TODO
 * 
 * @Title : AntUrlPathMatcher.java
 * @author liheping 2012-4-10 下午03:46:31
 * @version : V1.0 2012-4-10
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
public class AntUrlPathMatcher implements UrlMatcher {

	private boolean requiresLowerCaseUrl;
	private PathMatcher pathMatcher;

	public AntUrlPathMatcher() {
		this(true);
	}

	public AntUrlPathMatcher(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = true;
		this.pathMatcher = new AntPathMatcher();
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}

	@Override
	public Object compile(String path) {
		return this.requiresLowerCaseUrl ? path.toLowerCase() : path;
	}

	@Override
	public boolean pathMatchesUrl(Object path, String url) {
		if (("/**".equals(path)) || ("**".equals(path))) {
			return true;
		}
		return this.pathMatcher.match((String) path, url);
	}

	@Override
	public String getUniversalMatchPattern() {
		return "/**";
	}

	@Override
	public boolean requiresLowerCaseUrl() {
		return this.requiresLowerCaseUrl;
	}

	public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}
	
	@Override
	public String toString() {
	    return super.getClass().getName() + "[requiresLowerCase='" + this.requiresLowerCaseUrl + "']";
	  }

}

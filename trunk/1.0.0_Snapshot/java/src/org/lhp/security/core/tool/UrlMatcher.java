/**
 * 
 */
package src.org.lhp.security.core.tool;

/**
 * TODO
 * 
 * @Title : UrlMatcher.java
 * @author liheping 2012-4-10 下午03:45:32
 * @version : V1.0 2012-4-10
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
public interface UrlMatcher {
	Object compile(String path);

	boolean pathMatchesUrl(Object path, String url);

	String getUniversalMatchPattern();

	boolean requiresLowerCaseUrl();
}

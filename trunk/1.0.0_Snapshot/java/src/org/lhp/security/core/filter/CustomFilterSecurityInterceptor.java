/**
 * 
 */
package src.org.lhp.security.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
* TODO 
*	访问拦截,主要调用两个方法 : 
* 	FilterInvocationSecurityMetadataSource -> getAttributes() 获取当前资源资源所对应的权限
* 	AccessDecisionManager -> decide() 
* @Title : CustomFilterSecurityInterceptor.java
* @author liheping 2012-4-18 上午10:03:45
* @version : V1.0 2012-4-18 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);
	}
	
	
	private void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}
	
	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
	// getter and  setter
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
		this.securityMetadataSource = newSource;
	}
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
	
	
	// end
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}
	@Override
	public void destroy() {
	}
}

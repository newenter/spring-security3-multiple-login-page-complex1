/**
 * 
 */
package src.org.lhp.security.core.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.ExceptionTranslationFilter;

/**
 * TODO 
 * @Title : FMS_ExceptionTranslationFilter.java
 * @author liheping 2012-4-19 下午01:45:17
 * @version : V1.0 2012-4-19 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
@SuppressWarnings("deprecation")
public class FMS_ExceptionTranslationFilter extends ExceptionTranslationFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(FMS_ExceptionTranslationFilter.class);

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) {
		try {
			super.doFilter(arg0, arg1, arg2);
		}catch (AuthenticationException e) {
			LOGGER.error(e.getMessage());
		}
		catch (AccessDeniedException e) {
			LOGGER.error(e.getMessage());
		} 
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		} 
	}

}

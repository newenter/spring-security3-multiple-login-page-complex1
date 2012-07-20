/**
 * 
 */
package src.org.lhp.system.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import src.org.lhp.security.core.service.CustomSecurityMetadataSource;

public class FMS_CustomDispatcherServlet extends DispatcherServlet {
	private static final long serialVersionUID = 6363049442216462115L;
	private static final Logger LOGGER = LoggerFactory.getLogger(FMS_CustomDispatcherServlet.class);
	@Override
	protected void onRefresh(ApplicationContext context) {
		super.onRefresh(context);
		CustomSecurityMetadataSource securityMetadataSource = context.getBean("CustomSecurityMetadataSource", CustomSecurityMetadataSource.class);
		securityMetadataSource.loadResourceDefine();
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|=====================================FMS MVC初始化完毕=====================================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
	}
}

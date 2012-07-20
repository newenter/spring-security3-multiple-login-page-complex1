package src.org.lhp.system.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
* TODO 
* @Title : Backstage_CustomDispatcherServlet.java
* @author liheping 2012-4-18 下午04:56:57
* @version : V1.0 2012-4-18 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public class Backstage_CustomDispatcherServlet  extends DispatcherServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Backstage_CustomDispatcherServlet.class);
	@Override
	protected void onRefresh(ApplicationContext context) {
		super.onRefresh(context);
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|=====================================Backstage MVC初始化完毕===============================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
	}
}

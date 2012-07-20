package src.org.lhp.system.component;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
* TODO 自定义spring启动监听器
* @Title : CustomContextLoaderListener.java
* @author liheping 2012-4-18 下午05:00:53
* @version : V1.0 2012-4-18 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public class CustomContextLoaderListener extends ContextLoaderListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomContextLoaderListener.class);
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|=====================================Spring 启动 完毕======================================|");
		LOGGER.info("|==========================================================================================|");
		LOGGER.info("|==========================================================================================|");
	}
}

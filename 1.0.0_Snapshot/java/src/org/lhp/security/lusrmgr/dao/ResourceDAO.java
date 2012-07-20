/**
 * 
 */
package src.org.lhp.security.lusrmgr.dao;

import java.io.Serializable;
import java.util.List;

import src.org.lhp.security.lusrmgr.domain.Resource;
import src.org.lhp.system.common.dao.CustomRepository;

/**
 * TODO 
 * @Title : ResourceDAO.java
 * @author liheping 2012-4-12 下午01:34:40
 * @version : V1.0 2012-4-12 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
public interface ResourceDAO extends CustomRepository<Resource, Serializable> {
	List<Resource> findByEnabled(boolean enabled);
}

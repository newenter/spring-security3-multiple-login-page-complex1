/**
 * 
 */
package src.org.lhp.system.common.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import src.org.lhp.system.common.domain.BaseEntity;

/**
 * TODO
 * 		BaseEntity生命周期监听器
 * @Title : BaseEntityListener.java
 * @author liheping 2012-4-11 上午11:27:17
 * @version : V1.0 2012-4-11
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
public class BaseEntityListener {
	
	/** 
	* TODO  
	* @Title: prePersist 
	* @param entity    
	* @return void 
	* @author liheping    2012-4-11  上午11:30:16
	*/ 
	@PrePersist
	void prePersist(BaseEntity entity) {
		Date date = new Date();
		entity.setCreateDate(date);
		entity.setLastUpdateDate(date);
	}
	
	/** 
	* TODO  
	* @Title: preUudate 
	* @param entity    
	* @return void 
	* @author liheping    2012-4-11  上午11:30:19
	*/ 
	@PreUpdate
	void preUudate(BaseEntity entity){
		entity.setCreateDate(new Date());
	}
}

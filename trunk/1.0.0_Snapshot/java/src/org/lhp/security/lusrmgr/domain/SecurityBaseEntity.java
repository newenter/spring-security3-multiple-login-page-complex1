/**
 * 
 */
package src.org.lhp.security.lusrmgr.domain;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import src.org.lhp.system.common.domain.BaseEntity;

/**
 * TODO 
 * @Title : SecurityBaseEntity.java
 * @author liheping 2012-4-13 下午01:24:31
 * @version : V1.0 2012-4-13 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class SecurityBaseEntity extends BaseEntity {
	@Column(name = "DESCRIPTION")
	protected String description;//描述
	
	@Column(name = "ENABLED",nullable=false)
	protected boolean enabled;// 是否启用

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}

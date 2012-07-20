/**
 * 
 */
package src.org.lhp.security.lusrmgr.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TODO 
 * @Title : UserName.java
 * @author liheping 2012-4-11 上午10:47:25
 * @version : V1.0 2012-4-11 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
@Embeddable
public class UserName {
	
	@Column(name = "EN_NAME", length = 120)
	private String enName;

	@Column(name = "CH_NAME", length = 120)
	private String chName;

	@Column(name = "ALIAS_NAME", length = 120, unique = true, nullable = false)
	private String aliasName;
	
	
	
	
	
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	
}

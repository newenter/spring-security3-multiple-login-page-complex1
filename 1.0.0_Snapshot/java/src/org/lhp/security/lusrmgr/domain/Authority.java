/**
 * 
 */
package src.org.lhp.security.lusrmgr.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

/**
 * TODO 权限
 * @Title : Authority.java
 * @author liheping 2012-4-13 下午01:10:37
 * @version : V1.0 2012-4-13 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
@Entity
@Table(name="SYS_AUTHORITY")
public class Authority extends SecurityBaseEntity implements Serializable {
	private static final long serialVersionUID = -1773904761675443603L;
	@Column(name = "AUTHORITY_NAME", unique = true, nullable = false)
	private String authorityName;//权限名称
	
	
	@ManyToMany(cascade = { CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE }, fetch = FetchType.LAZY,targetEntity=Resource.class)
	@JoinTable(name="SYS_R_AUTH_RESOURCE",
			joinColumns=@JoinColumn(name="AUTH_ID",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="RESORCE_ID",referencedColumnName="ID"))
	private Set<Resource> resources; //资源
	
	@ManyToMany( fetch = FetchType.LAZY,targetEntity=Role.class,mappedBy="authoritys")
	private Set<Role> roles; //角色

	//=======================================//
	
	public String getAuthorityName() {
		return  StringUtils.isNotEmpty(authorityName) ? authorityName.toUpperCase() : "NULL";
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}

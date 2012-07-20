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
 * TODO 角色
 * 
 * @Title : Role.java
 * @author liheping 2012-4-11 下午12:44:48
 * @version : V1.0 2012-4-11
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
@Entity
@Table(name = "SYS_ROLE")
public class Role extends SecurityBaseEntity implements Serializable {
	private static final long serialVersionUID = 7279874838713670411L;
	
	@Column(name = "ROLE_NAME", unique = true, nullable = false)
	private String roleName;//角色名称
	
	
	@ManyToMany(cascade = { CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE }, fetch = FetchType.LAZY,targetEntity=Authority.class)
	@JoinTable(name="SYS_R_ROLE_AUTH",
			joinColumns=@JoinColumn(name="ROLE_ID",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="AUTH_ID",referencedColumnName="ID"))
	private Set<Authority> authoritys; //权限
	
	
	@ManyToMany( fetch = FetchType.LAZY,targetEntity=User.class,mappedBy="roles")
	private Set<User> users; //用户

	//====================================//
	
	public String getRoleName() {
		return StringUtils.isNotEmpty(roleName) ? roleName.toUpperCase() : "NULL";
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(Set<Authority> authoritys) {
		this.authoritys = authoritys;
	}
	
	
	
	
}

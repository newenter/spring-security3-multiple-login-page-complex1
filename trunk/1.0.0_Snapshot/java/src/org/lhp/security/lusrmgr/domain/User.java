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

/**
 * TODO 用户实体
 * 
 * @Title : User.java
 * @author liheping 2012-3-31 上午11:06:48
 * @version : V1.0 2012-3-31
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
@Entity
@Table(name = "SYS_USER")
public class User extends SecurityBaseEntity implements Serializable {
	private static final long serialVersionUID = 1496514581623561667L;
	private UserName name;
	@Column(name = "PASSWORD", nullable = false)
	private String password; // 密码

	@Column(name = "ACCOUNT", unique = true, nullable = false)
	private String account; // 账户

	@Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
	private boolean accountNonExpired; // 账户是否过期

	@Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
	private boolean accountNonLocked; // 账户是否锁定

	@Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
	private boolean credentialsNonExpired;// 证书是否过期


	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, targetEntity = Role.class)
	@JoinTable(name = "SYS_R_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private Set<Role> roles; // 角色

	// =====================================//

	public UserName getName() {
		return name;
	}

	public void setName(UserName name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}

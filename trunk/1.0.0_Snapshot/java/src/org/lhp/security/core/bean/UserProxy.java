/**
 * 
 */
package src.org.lhp.security.core.bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import src.org.lhp.security.lusrmgr.domain.Role;
import src.org.lhp.security.lusrmgr.domain.User;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * TODO
 * 
 * @Title : UserProxy.java
 * @author liheping 2012-4-11 下午02:23:57
 * @version : V1.0 2012-4-11
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
public class UserProxy implements UserDetails, CredentialsContainer {
	private static final long serialVersionUID = -1606063297928536503L;
	private User user;
	private String saltValue;
	private final Set<GrantedAuthority> authorities =  new HashSet<GrantedAuthority>();
	//======================//
	public UserProxy(){}
	public UserProxy(User user) {
		super();
		this.user = user;
		this.build(this.user);
	}
	
	/** 
	* TODO  构造用户权限
	* @Title: build 
	* @param val    
	* @return void 
	* @author liheping    2012-4-12  下午01:45:14
	*/ 
	public void build(User val){
		this.saltValue = val.getAccount();
		for (Role role : val.getRoles()) {
			this.AddGrantedAuthority(new SimpleGrantedAuthority(role.getRoleName()));
		}
	}

	/**
	 * TODO 添加权限
	 * 
	 * @Title: AddGrantedAuthority
	 * @param val
	 * @return void
	 * @author liheping 2012-4-11 上午10:41:42
	 */
	public final void AddGrantedAuthority(GrantedAuthority val) {
		if(null==val) return;
		this.authorities.add(val);
	}

	// ===============Override List======================//
	@Override
	public void eraseCredentials() {
		this.user.setPassword(null);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	@Override
	public String getUsername() {
		return this.user.getAccount();
	}
	@Override
	public boolean isAccountNonExpired() {
		return this.user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.user.isAccountNonLocked();
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return this.user.isCredentialsNonExpired();
	}
	@Override
	public boolean isEnabled() {
		return this.user.isEnabled();
	}

	//=============================================//
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getSaltValue() {
		return saltValue;
	}
	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}
	
}

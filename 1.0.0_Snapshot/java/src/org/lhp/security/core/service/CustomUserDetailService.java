package src.org.lhp.security.core.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import src.org.lhp.security.core.bean.UserProxy;
import src.org.lhp.security.lusrmgr.dao.UserDAO;

/**
* TODO 认证时,读取用户信息
* @Title : CustomUserDetailService.java
* @author liheping 2012-4-19 上午10:27:28
* @version : V1.0 2012-4-19 
* @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
*/
public class CustomUserDetailService implements UserDetailsService {
	//@Resource
	private UserDAO userDAO;
	public UserDAO getUserDAO() {return userDAO;}
	public void setUserDAO(UserDAO userDAO) {this.userDAO = userDAO;}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new UserProxy(this.userDAO.findByAccount(username));
	}

}

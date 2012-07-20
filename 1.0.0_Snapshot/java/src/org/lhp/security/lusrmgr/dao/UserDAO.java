package src.org.lhp.security.lusrmgr.dao;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import src.org.lhp.security.lusrmgr.domain.User;
import src.org.lhp.system.common.dao.CustomRepository;

public interface UserDAO extends CustomRepository<User, Serializable> {
	
	@Query("select u from User u where u.id=:id")
	User findUserById(@Param("id")Long id)throws Exception;
	
	User findById(Long id) ;
	
	/** 
	* TODO  根据账户名称查询用户
	* @Title: findByAccounte 
	* @param account
	* @return    
	* @return User 
	* @author liheping    2012-4-12  下午01:39:02
	*/ 
	User findByAccount(String account);
	
	@Query("select u from User u where u.enabled=true")
	Set<User> getEnabedUsers();
}

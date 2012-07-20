package src.org.lhp.security.lusrmgr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import src.org.lhp.security.lusrmgr.domain.User;

public interface IUserService {
	void save(User user) throws Exception;
	void delById(Long id) throws Exception;
	User findUserById(Long id)throws Exception;
	
	User findById(Long id) throws Exception;
	
	Page<User> findAll(Pageable pageable);
	
}

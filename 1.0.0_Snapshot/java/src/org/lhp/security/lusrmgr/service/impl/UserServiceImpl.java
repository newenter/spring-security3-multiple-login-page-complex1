package src.org.lhp.security.lusrmgr.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import src.org.lhp.security.lusrmgr.dao.UserDAO;
import src.org.lhp.security.lusrmgr.domain.User;
import src.org.lhp.security.lusrmgr.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserDAO userDAO;
	@Override
	public void save(User user) throws Exception {
		userDAO.save(user);
	}

	@Override
	public void delById(Long id) throws Exception {
		User bean = userDAO.findOne(id);
		this.userDAO.delete(bean);
	}

	@Override
	public User findUserById(Long id) throws Exception {
		return this.userDAO.findUserById(id);
	}

	@Override
	public User findById(Long id) throws Exception {
		return this.userDAO.findById(id);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.userDAO.findAll(pageable);
	}

	
	

}

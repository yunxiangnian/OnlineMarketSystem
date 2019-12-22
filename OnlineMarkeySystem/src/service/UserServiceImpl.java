package service;

import com.yunxiangnian.bean.User;

import utils.BusinessException;
import utils.EmptyUtils;
import utils.UserIO;

public class UserServiceImpl implements UserService{

	@Override
	public User register(User user) throws BusinessException {
		UserIO userIo=new UserIO();
		userIo.add(user);
		userIo.writeUsers();
		return user;
	}

	@Override
	public User login(String username, String password) throws BusinessException {
		if(EmptyUtils.isEmpty(username)){
			throw new BusinessException("username.notnull");
		}else if(EmptyUtils.isEmpty(password)){
			throw new BusinessException("password.notnull");
		}
		UserIO userIo=new UserIO();
		User user=userIo.findUser(username, password);
		
		return user;
	}

}

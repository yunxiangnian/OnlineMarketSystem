package service;

import com.yunxiangnian.bean.User;

import utils.BusinessException;

public interface UserService {
		public User register(User user) throws BusinessException;
		public User login(String username,String password)throws BusinessException;
}

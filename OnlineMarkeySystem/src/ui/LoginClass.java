package ui;


import com.yunxiangnian.bean.User;

import service.UserService;
import service.UserServiceImpl;
import utils.BusinessException;

public class LoginClass extends BaseClass{
//	UserService us;
//	public LoginClass(){
//		 us=(UserService)beanFactory.getBean("UserService");
//	}
	public void login() throws BusinessException{
		println(getString("input.username"));
		String username=input.nextLine();
		println(getString("input.password"));
		String password=input.nextLine();
		UserService us=new UserServiceImpl();
		User user=us.login(username, password);
		if(user!=null){
			currUser=user;
		}else{
			throw new BusinessException("login.error");
		}
	}
}

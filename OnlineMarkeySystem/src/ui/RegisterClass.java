package ui;

import com.yunxiangnian.bean.User;

import service.UserService;
import service.UserServiceImpl;

public class RegisterClass extends BaseClass{
//	UserService userService;
//	public RegisterClass(){
//		 userService=(UserService)beanFactory.getBean("UserService");
//	}
		public void register(){
			println(getString("input.username"));
			String username=input.nextLine();
			println(getString("input.password"));
			String password=input.nextLine();
			User user=new User(username,password);
			UserService userService=new UserServiceImpl();
			userService.register(user);
		}
}

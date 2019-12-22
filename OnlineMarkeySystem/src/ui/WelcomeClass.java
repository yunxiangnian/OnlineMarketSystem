package ui;

import utils.BusinessException;
import utils.UserIO;

public class WelcomeClass extends BaseClass{
		public static void start(){
			println(getString("info.welcome"));
			UserIO userIo=new UserIO();
			userIo.readUsers();
			boolean flag=true;
			while(flag){
				println(getString("info.login.reg"));
				println(getString("info.select"));
				String s=input.nextLine();
			switch(s){
			case "1":
				
				try{
					new LoginClass().login();
					println(getString("login.success"));
					flag=false;
				}catch(BusinessException e){
					println(getString(e.getMessage()));
				}
				break;
			case "2":
				
				try{
					new RegisterClass().register();
					println(getString("reg.success"));
					flag=false;
				}catch(BusinessException e){
					println(getString("reg.error"));
					println(getString(e.getMessage()));
				}
				break;
			default:
				println(getString("info.error"));
				break;
			}
			}
			HomeClass homeClass=new HomeClass();
			homeClass.show();
		}
}

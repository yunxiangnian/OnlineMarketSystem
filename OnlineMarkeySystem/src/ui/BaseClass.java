package ui;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.yunxiangnian.bean.User;

import framework.BeanFactory;

public class BaseClass {
	protected static Scanner input=new Scanner(System.in);
	protected static User currUser;//当前用户
	private static Locale locale_CN=new Locale("zh","CN");
//	protected static BeanFactory beanFactory=null;
	private static ResourceBundle r=ResourceBundle.getBundle("resource.r",locale_CN);
	
	public static String getString(String key){
		return r.getString(key);
	}
	
	public static void print(String s){
		System.out.print(s);
	}
	
	public static void println(String s){
		System.out.println(s);
	}
//	public BaseClass(){
//		beanFactory=BeanFactory.init();
//	}
}

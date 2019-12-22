package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yunxiangnian.bean.User;

public class UserIO {
	private static List<User> users = new ArrayList<>();
	private static final String USER_FILE = "user.obj";
	//д���û��б�
	public boolean writeUsers() throws BusinessException {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
			out.writeObject(users);
			out.close();
			return true;
		} catch (IOException e) {
			throw new BusinessException("io.write.error");
		}
	}

	public boolean readUsers() throws BusinessException {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
			users = (List<User>) in.readObject();
			
			in.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			throw new BusinessException("io.read.error");
		}
		return false;
	}

	public void add(User user) throws BusinessException {
		user.setId(users.size() + 1);
		users.add(user);
		}
	
	public User findUser(String username,String password){
		for(User u:users){
			if((u.getName().equals(username)) && u.getPassword().equals(password));
				return u;
		}
		return null;
	}
}

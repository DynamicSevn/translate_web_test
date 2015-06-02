package test;

import com.translation.bean.User;
import com.translation.service.UserService;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		user.setUserid(23);
		user.setUsername("111");
		UserService userService = new UserService();
		userService.add(user);
		

	}

}

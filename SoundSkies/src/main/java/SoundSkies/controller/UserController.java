package SoundSkies.controller;
import io.javalin.http.Context;
import SoundSkies.service.*;
import SoundSkies.pojos.*;
import org.apache.log4j.Logger;
public class UserController {
	
	private static Logger log = Logger.getRootLogger();
	UserService userService= new UserServiceFullStack();
	
	public void createUser(Context ctx) {
		log.info(" Controller ----- creating User");
		
		String username = ctx.formParam("username");
		
		String password = ctx.formParam("password");
		
		String email= ctx.formParam("email");
	
		User user = new User(username, password, email);
		
		userService.createUser(user);
		
		ctx.html(Integer.toString(user.getUserId()));
	}
	public void updateUser(Context ctx) {
		log.info("Controller ----- updating User");
		
	}
	public void deleteUser(Context ctx) {
		
	}
	public void getUser(Context ctx) {
		
	}
}

package SoundSkies.controller;
import io.javalin.http.Context;
import SoundSkies.service.*;
import SoundSkies.util.UserUpdateException;
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
		
		String username = ctx.formParam("username");
		
		String password = ctx.formParam("password");
		
		String email= ctx.formParam("email");
	
		User user = new User(username, password, email);
		
		try {
			userService.updateUser(Integer.parseInt(ctx.formParam("id")),user);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UserUpdateException e) {
			ctx.status(500);
		}

	}
	public void deleteUser(Context ctx) {
		
		log.info(" Controller ----- deleting User" );
		
		String username = ctx.formParam("username");
		
		userService.deleteUser(username);
		
		
	}
	public void readUser(Context ctx) {
		
		log.info(" Controller -----reading a User" );
		
		int userId=Integer.parseInt(ctx.formParam( "user_id"));
		
		ctx.html(userService.readUser(userId).toString());
		
	}
	public void readAllUsers(Context ctx) {
		
		log.info(" Controller ----- reads all Users" );
		
		//userService.getAllUsers();
		
		ctx.html(userService.getAllUsers().toString());
	}
	
	public void signIn(Context ctx) {
		log.info(" Controller ----- Authenticating" );
		
		String username = ctx.formParam("username");
		
		String password = ctx.formParam("password");

		
		
		ctx.html(userService.signIn(username, password).toString());
		
	}
	public void simplefunc(Context ctx) {
		
		int userId=Integer.parseInt(ctx.formParam( "user_id"));
		
		userService.simplefunc(userId);
	}
}

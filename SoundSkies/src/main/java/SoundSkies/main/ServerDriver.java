package SoundSkies.main;
import io.javalin.Javalin;
import SoundSkies.*;
import SoundSkies.controller.UserController;
import org.apache.log4j.Logger;
public class ServerDriver {
	private static Logger log = Logger.getRootLogger();
	private static UserController userController = new UserController();
	
	public static void main (String[]args) {
		
		
		
		Javalin app=Javalin.create().start(9093);
		
		app.get ("/hello", ctx -> ctx.html("SoundSkies"));
		
		app.post("/createUser", ctx -> userController.createUser(ctx));
		
		app.get("/getUser", ctx -> userController.getUser(ctx));
		
		
		app.post("/updateUser", ctx -> userController.updateUser(ctx));
		
		app.post("/deleteUser", ctx -> userController.deleteUser(ctx));
	}

}

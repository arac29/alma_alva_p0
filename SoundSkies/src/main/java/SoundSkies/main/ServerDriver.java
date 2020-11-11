package SoundSkies.main;
import io.javalin.Javalin;
import SoundSkies.*;
import SoundSkies.controller.*;
import org.apache.log4j.Logger;

public class ServerDriver {
	private static Logger log = Logger.getRootLogger();
	
	
	private static UserController userController = new UserController();
	
	private static PostController postController= new PostController();
	
	private static PurchaseController purchaseController=new  PurchaseController();
	
	
	public static void main (String[]args) {
		
		
		Javalin app=Javalin.create().start(9093);
		
		
		app.get ("/hello", ctx -> ctx.html("SoundSkies"));
		/********************** UserController requests *******************************/
		
		app.post("/signIn", ctx -> userController.signIn(ctx));
		
		app.post("/createUser", ctx -> userController.createUser(ctx));
		
		app.post("/getUser", ctx -> userController.readUser(ctx));
		
		app.put("/updateUser", ctx -> userController.updateUser(ctx));
		
		app.post("/deleteUser", ctx -> userController.deleteUser(ctx));
		
		app.get("/readAllUsers", ctx -> userController.readAllUsers(ctx));
		
		app.post("/simpleFun", ctx -> userController.simplefunc(ctx));
		
		/********************** PostController requests *******************************/
		
		app.post("/createPost", ctx-> postController.createPost(ctx));
		
		app.post("/readPost", ctx-> postController.readPost(ctx));
		
		app.put("/updatePost", ctx-> postController.updatePost(ctx));
		
		app.post("/deletePost", ctx-> postController.deletePost(ctx));
		
		app.get("/readAllPosts", ctx -> postController.readAllPosts(ctx));
		
		app.post("/readAllPostsByUserId", ctx-> postController.readAllPostsByUser(ctx));
		
		/********************** PurchaseController requests ***************************/
		app.post("/createPurchase", ctx-> purchaseController.createPurchase(ctx));
		
		app.post("/readPurchase", ctx-> purchaseController.readPurchase(ctx));
		
		app.put("/updatePurchase", ctx-> purchaseController.updatePurchase(ctx));
		
		app.post("/deletePurchase", ctx-> purchaseController.deletePurchase(ctx));
		
		app.get("/readAllPurchases", ctx -> purchaseController.readAllPurchases(ctx));
		
		app.post("/readAllPurchasesByUserId", ctx-> purchaseController.readAllPurchasesByPostId(ctx));

		
	}

}

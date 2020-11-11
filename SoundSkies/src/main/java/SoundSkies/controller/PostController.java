package SoundSkies.controller;

import org.apache.log4j.Logger;
import SoundSkies.pojos.*;
import SoundSkies.service.*;
import SoundSkies.util.UserUpdateException;
import io.javalin.http.Context;

public class PostController {
	
	private static Logger log = Logger.getRootLogger();
	
	PostService postService= new PostServiceFullStack();

	public void createPost(Context ctx) {
		log.info(" Controller ----- creating Post");
		
		int userId=Integer.parseInt(ctx.formParam( "user_id"));
		
		String title = ctx.formParam("title");
		
		String fileType = ctx.formParam("fileType");
		
		String genre= ctx.formParam("genre");
		
		Double price= Double.parseDouble(ctx.formParam("price"));
	
		Post post = new Post(userId,title, fileType, genre, price);
		
		postService.createPost(post);
		
		ctx.html(Integer.toString(post.getPostId()));
	}
		

	public void readPost(Context ctx) {
		log.info(" Controller -----reading a Post" );
		
		int postId=Integer.parseInt(ctx.formParam( "postid"));
		
		ctx.html(postService.readPost(postId).toString());
		
	}

	public void updatePost(Context ctx) {
		
		log.info(" Controller ----- update Post");
		
		int postId=Integer.parseInt(ctx.formParam("post_id"));
		
		String title = ctx.formParam("title");
		
		String fileType = ctx.formParam("fileType");
		
		String genre= ctx.formParam("genre");
		
		Double price= Double.parseDouble(ctx.formParam("price"));
	
		Post post = new Post(postId,title, fileType, genre, price);
		
	
		try {
			postService.updatePost(postId,post);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}

	public void deletePost(Context ctx) {
		
		log.info(" Controller ----- deleting Post" );
		
		int postId=Integer.parseInt(ctx.formParam( "postid"));
		
		postService.deletePost(postId);
	}

	public void readAllPosts(Context ctx) {
		
		log.info(" Controller ----- reads all posts" );
		
		
		ctx.html(postService.getAllPosts().toString());

	}

	public void readAllPostsByUser(Context ctx) {
		
		
		int userId=Integer.parseInt(ctx.formParam("user_id"));
		log.info(" Controller ----- reads all posts from " +userId);
		
		ctx.html(postService.readAllPostsByUser(userId).toString());
	
	}

}

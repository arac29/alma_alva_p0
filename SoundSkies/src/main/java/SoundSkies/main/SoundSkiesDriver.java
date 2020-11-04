package SoundSkies.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import SoundSkies.pojos.*;
import SoundSkies.pojos.Post.FileType;
import SoundSkies.pojos.Post.Genre;

import org.apache.log4j.Logger;

public class SoundSkiesDriver {
	private static Logger log = Logger.getRootLogger();
	
	private static Scanner scan = new Scanner(System.in);
	
	private static List<Post> posts = new ArrayList<Post>();
	
	private static List<Purchase> purchases = new ArrayList<Purchase>();
	
	//private static User user1= new User(1,"alma","pass","alma@gmail.com", null, null);
	public static void main (String args[]) {
		String userInput;
		String username=null;
		String password=null;
		log.info("Program has started");
		
		System.out.println("[1] create user");
		System.out.println("[2] sign in");
		System.out.println("[0] exit");
		int option = scan.nextInt();
		
		switch (option) {
		case 1:
			if (createUser()) {
				System.out.println("User created! ");
			} else {
				System.out.println("failed to create user ");
			}
			break;
		case 2:
			if (!signIn()) {
				
				System.out.println("Authentication failed");
			}
			break;
		}

		do { 
			System.out.println("Please choose one of the following");
			System.out.println("[1] create post");
			System.out.println("[2] check posts");
			System.out.println("[3] check purchases");
			System.out.println("[0] exit");

			userInput = scan.nextLine();
			
			switch (userInput) {
			case "1":
				if (createPost()) {
					System.out.println("Post created! ");
				} else {
					System.out.println("failed to post ");
				}
				break;

			case "2":
				System.out.println(posts);
				break;
			case "3":
				System.out.println(purchases);
				break;
			case "0":
				System.out.println("Bye");
				log.info("Exited the app");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		} while (!"0".equals(userInput));
		
	
	}
	
	private static boolean createPost() {
		System.out.println("What is the title?");
		String title = scan.nextLine();
		
		System.out.println("What is the genre ?");
		System.out.println("[1] HIP HOP");
		System.out.println("[2] ROCK");
		System.out.println("[3] INDIE");
		System.out.println("[4] JAZZ");
		int genreSelect = scan.nextInt();
		System.out.println("What is the file type? 1.MP3  2. WMA");
		int filetypeSelect = scan.nextInt();
		System.out.println("What is the price?");
		Double price = scan.nextDouble();
		scan.nextLine();
		
		FileType fileType =null;
		Genre genre=null;
		switch (filetypeSelect) {
		case 1:
			fileType=fileType.MP3;
			break;
		case 2:
			fileType=fileType.WMA;
			break;
		}
		
		switch(genreSelect) {
		case 1:
			genre=genre.HIPHOP;
			break;
		case 2:
			genre=genre.ROCK;
			break;
		case 3:
			genre=genre.INDIE;
			break;
		case 4:
			genre=genre.JAZZ;
			break;
		}
		
		//Post newPost= new Post (1, user1, title,  price, fileType,genre);
		//user1.setPosts(newPost);
		log.info("LOG MESSAGE: created a post ");
		//System.out.println(newPost.getTitle()+ "was added");
		
		//posts.add(newPost);
		return true;
	}
	private static boolean createUser() {
		return false;
	}
	private static boolean signIn() {
		return true;
	}
}

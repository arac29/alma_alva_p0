package SoundSkies.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import SoundSkies.pojos.*;


//import org.apache.log4j.Logger;

public class SoundSkiesDriver {
	
	//private static Logger log = Logger.getRootLogger();
	
/*
	private static Scanner scan = new Scanner(System.in);
	
	private static List<Post> posts = new ArrayList <Post> ();
	
	private static List<Purchase> purchases = new ArrayList<Purchase>();
	
	private static List <User> users = new ArrayList<User>();
	
	private static User user= new User("alma","pass","alma@gmail.com", null, null);
	*/
	
	public static void main (String args[]) {
/**
		//System.out.println(user.getUsername());
		String userInput;
		String username=null;
		String password=null;
		log.info("Program has started");
		boolean auth=false;
		
		do {
			System.out.println("[1] create user");
			System.out.println("[2] sign in");
			System.out.println("[0] exit");
			int option = scan.nextInt();
			scan.nextLine();
		
			switch (option) {
			case 1:
				user=createUser();
				System.out.println("User created!");
				auth=true;
				break;
			case 2:
				if (signIn(user)) {
					System.out.println("Authentication");
					auth=true;
				}
				else {
				System.out.println("Authentication failed ");
				break;
				}
			}
		}while(!auth);
		
		do {
		System.out.println("Please choose one of the following");
		System.out.println("[1] create post");
		System.out.println("[2] check posts");
		System.out.println("[3] check purchases");
		System.out.println("[0] exit");
		userInput = scan.nextLine();
		//scan.nextLine();
			
		switch (userInput) {
			case "1":
				if (createPost()) {
					System.out.println("Post created!");
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
		System.out.println("What is the file type?");
		System.out.println("[1] MP3");
		System.out.println("[2] WMA");
		int filetypeSelect = scan.nextInt();
		System.out.println("What is the price?");
		Double price = scan.nextDouble();
		scan.nextLine();
		
		String fileType =null;
		String genre=null;
		switch (filetypeSelect) {
		case 1:
			fileType="MP3";
			break;
		case 2:
			fileType="WMA";
			break;
		}
		
		switch(genreSelect) {
		case 1:
			genre=genre"HIPHOP";
			break;
		case 2:
			genre=genre.ROCK;
			break;
		case 3:
			genre=genre.INDIE;
			break;

		}
		
		Post newPost= new Post (user.getUserId(), title,  price, fileType,genre);
		//user.setPosts(newPost);
		log.info("LOG MESSAGE: created a post.");
		System.out.println(newPost.getTitle()+ " was added to your posts.");
		
		posts.add(newPost);
		return true;
	}
	private static User createUser() {
		System.out.println("Create username");
		String username1 = scan.nextLine();
		
		System.out.println("Create password");
		String password1= scan.nextLine();
		
		System.out.println("Enter email");
		String email= scan.nextLine();
		
		User user=new User(username1, password1, email,null,null);
		log.info("New user created " + user.getUsername());
		
		return user;
	}
	private static boolean signIn(User user) {
		//System.out.println( user.getUsername());
		System.out.println("Enter username");
		String username = scan.nextLine();
		System.out.println("Enter password");
		String password= scan.nextLine();
		scan.nextLine();
		
		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			log.info("LOG MESSAGE: Authentication completed ");
			return true;
		}
		
		else {
			return false;
		}**/
	}
}

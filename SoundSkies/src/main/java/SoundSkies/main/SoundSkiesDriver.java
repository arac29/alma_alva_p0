package SoundSkies.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import SoundSkies.pojos.*;
import org.apache.log4j.Logger;

public class SoundSkiesDriver {
	private static Logger log = Logger.getRootLogger();
	
	private static Scanner scan = new Scanner(System.in);
	
	private static List<Post> posts = new ArrayList<Post>();
	private static User user1= new User(1,"alma","pass","alma@gmail.com", null, null);
	public static void main (String args[]) {
		String userInput;
		String username=null;
		String password=null;
		log.info("Program has started");
		do {
			
			System.out.println(" Welcome! Log in with userame please.");
			username=scan.nextLine();
			System.out.println(" Enter password please.");
			password=scan.nextLine();
			
			scan.nextLine();
		} while (username !=null || password !=null);
		
		
	}
}

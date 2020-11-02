package SoundSkies.main;
import java.util.Scanner;
//import org.apache.log4j.Logger;

public class SoundSkiesDriver {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main (String args[]) {
		String userInput;
		
		do {
			
			System.out.println(" Welcome! Log in with userame and password please.");
			userInput=scan.nextLine();
		} while (!"0".equals(userInput));
	}
	
}

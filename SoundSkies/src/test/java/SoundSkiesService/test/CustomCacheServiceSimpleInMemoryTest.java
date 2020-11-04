package SoundSkiesService.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import SoundSkies.service.*;
import SoundSkies.pojos.*;
import SoundSkies.pojos.Post.FileType;
import SoundSkies.pojos.Post.Genre;

public class CustomCacheServiceSimpleInMemoryTest {
	
	private CustomCacheServiceSimpleInMemory<Post> cacheService;
	
	static private Set <Post> testCache;
	
	@BeforeClass
	public static void setUpBeforeClass () throws Exception{
		testCache = new HashSet <>();
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	@Before
	public void setUp() throws Exception {
		//int postID, User user, String title, int size, double price, FileType fileType, Genre genre
		User user1 =new User (303, "usernameTest", "passwordTest", "emailTest", null, null);
		Post postTest= new Post( 404 , user1, "Post Test", 20.00 , FileType.MP3, Genre.HIPHOP );
		//Purchase purchaseTest= new Purchase(303, 500, postTest, 20.00);
		
		testCache.add(postTest);
		
		cacheService =new CustomCacheServiceSimpleInMemory<Post>(testCache);
		
	}
	@Test
	public void addToCacheSimplePostTest() {
		Post postToAdd =new Post(403, new User (202, "cacheUser","passwordCache","cache@email.com", null,null), "song",30.00,FileType.WMA, Genre.EDM);
		
		cacheService.addToCache(postToAdd);
		
		assertEquals("Post" + postToAdd+ "should be in the cache", true, testCache.contains(postToAdd));
		
	}
}

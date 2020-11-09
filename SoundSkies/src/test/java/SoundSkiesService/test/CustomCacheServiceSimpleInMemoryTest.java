package SoundSkiesService.test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import SoundSkies.service.*;
import SoundSkies.pojos.*;

public class CustomCacheServiceSimpleInMemoryTest {
	
	private CustomCacheServiceSimpleInMemory<Post> cacheService;
	
	static private Map <String, Post> testCache;
	/*
	@BeforeClass
	public static void setUpBeforeClass () throws Exception{
		testCache = new HashMap <String, Post>();
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	@Before
	public void setUp() throws Exception {
		
		User user1 =new User ( "usernameTest", "passwordTest", "emailTest", null, null);
		Post postTest= new Post( user1.getUserId(), "Post Test", 20.00 , FileType.MP3, Genre.HIPHOP );
		
		
		cacheService =new CustomCacheServiceSimpleInMemory<Post>(testCache);
		
	}
	@Test
	public void addToCacheSimplePostTest() {
		Post postToAdd =new Post( new User ("cacheUser","passwordCache","cache@email.com", null,null).getUserId(), "song",30.00,FileType.WMA, Genre.ROCK);
		
		cacheService.addToCache(postToAdd.getTitle(),postToAdd);
		
		assertEquals("Post" + postToAdd+ "should be in the cache", true, testCache.containsValue(postToAdd));
		
	}*/
}

package SoundSkiesService.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import SoundSkies.pojos.*;
import SoundSkies.service.*;

import SoundSkies.service.PostServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {/*
	
	private PostServiceImpl postService;
	
	@Mock 
	private CustomCacheService <Post> customCache;
	
	List<Post> postList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		postList = new ArrayList<Post> ();
		
		User user3 =new User ( "usernameTesta", "passwordTest", "emailTest3");
		User user4 =new User ("username4", "passwordTest", "emailTest4");
		User user5 =new User ("username5", "passwordTest", "emailTest5");
		Post postTest3= new Post(  user3.getUserId(), "Post Test3",   "MP3","HIPHOP"  ,20.00 );
		Post postTest4= new Post( user4.getUserId(), "Post Test4",  "MP3", "POP", 20.00 );
		
		postList.add(postTest3);
		postList.add(postTest4);
		
		when ((customCache.retrieveAllItems())).thenReturn(postList);
		
		postService = new PostServiceImpl (customCache);
		
		
	}
	@After
	public void tearDown() throws Exception {
		
		postList.clear();
		
	}

	@Test
	public void createSimplePostTest() {
		User user3 =new User ("usernameTesta", "passwordTest", "emailTest3");
		
		Post testingPost= postService.createPost( user3.getUserId(), "Post 3" , "MP3", "HIPHOP", 20.00);
		
		//user3.setPosts(testingPost);
		
		Post postTest3= new Post(user3.getUserId(), "Post 3" , "MP3", "HIPHOP" , 20.00);
		testingPost.setPostId(postTest3.getPostId());
		
		assertTrue("Should create Post object" , testingPost.equals(postTest3));
		
		verify(customCache).addToCache(testingPost);
		
	}
	@Test
	public void addPostToListTest() {
		User user3 =new User ("usernameTesta", "passwordTest", "emailTest3");
		
		Post testPost= postService.createPost( user3.getUserId(), "Post Test3", 20.00 , "MP3, Genre.HIPHOP);
		postList.add(testPost);
		
		assertTrue(postList.contains(testPost));
		
		verify (customCache).addToCache(testPost.getTitle(),testPost);
	}
	@Test
	public void getAllPostsTest() {
		User user3 =new User ( "usernameTesta", "passwordTest", "emailTest3");
		User user4 =new User ("username4", "passwordTest", "emailTest4");
		Post testPost3= postService.createPost( "Post Test3", 20.00 , "MP3", "HIPHOP");
		Post testPost4= postService.createPost(  "Post Test4", 20.00 , "MP3", "HIPHOP");
		
		
		
		postList.add(testPost3);
		postList.add(testPost4);
		
		
		assertTrue(postList.equals(postService.getAllPosts()));
		
	}*/

}

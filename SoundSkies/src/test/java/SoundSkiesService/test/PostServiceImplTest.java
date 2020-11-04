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
import SoundSkies.pojos.Post.FileType;
import SoundSkies.pojos.Post.Genre;
import SoundSkies.service.*;

import SoundSkies.service.PostServiceImpl;
import SoundSkies.service.PostServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {
	
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
		postList = new ArrayList<Post>();
		User user3 =new User (303, "usernameTesta", "passwordTest", "emailTest3", null, null);
		User user4 =new User (404, "username4", "passwordTest", "emailTest4", null, null);
		User user5 =new User (303, "username5", "passwordTest", "emailTest5", null, null);
		Post postTest3= new Post(  user3, "Post Test3", 20.00 , FileType.MP3, Genre.HIPHOP );
		Post postTest4= new Post(  user4, "Post Test4", 25.00 , FileType.MIDI, Genre.PODCAST );
		
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
		User user3 =new User (303, "usernameTesta", "passwordTest", "emailTest3", null, null);
		
		Post testPost= postService.createPost( user3, "Post Test3", 20.00 , FileType.MP3, Genre.HIPHOP);
		
		user3.setPosts(testPost);
		
		assertEquals("Should create Post object" ,"Post Test3" ,testPost.getTitle());
		
		verify(customCache).addToCache(testPost);
		
	}/*
	@Test
	public void addPostToListTest() {
		User user3 =new User (303, "usernameTesta", "passwordTest", "emailTest3", null, null);
		
		Post testPost= postService.createPost(300 , user3, "Post Test3", 20.00 , FileType.MP3, Genre.HIPHOP);
		
		assertEquals("Should be in the list", testPost, postList.contains(testPost));
		verify (customCache).addToCache(testPost);
	}*/
	//public void addPostToList( Post post);
	
	//public List <Post> getAllPosts();
	
	//public List <Post> getAllPostsByUserID(User userID);
}

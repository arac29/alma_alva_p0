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
public class UserServiceImplTest {
	private UserServiceImpl userService;
	/*
	@Mock
	private CustomCacheService<User> customCache;
	
	public List <User> userList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		userList =new ArrayList<User>();
		User tstUser1 =new User ("usernameee", "123131", "@@@@@@@@",null,null); 
		User user5= new User("userss","secret", "user@gmail", null,null);
		userList.add(user5);
		userList.add(tstUser1);
		
		when((customCache.retrieveAllItems())).thenReturn(userList);
		userService = new UserServiceImpl(customCache);
	}
	@After
	public void tearDown() throws Exception {
		
		userList.clear();
		
	}
	@Test
	public void createSimpleUserTest() {
		
		User user5= new User("userss","secret", "user@gmail", null,null);
		
		User user6=userService.createUser("userss","secret", "user@gmail", null,null);
		user5.setUserId(user6.getUserId());
		assertTrue("Should create user object", user5.equals(user6));
		
		//verify(customCache).addToCache(user5);
		
	}
	@Test
	public void signInTest () {
		User tstUser1 = userService.createUser("usernameee", "123131", "@@@@@@@@",null,null);
		
		String username= tstUser1.getUsername();
		String password=tstUser1.getPassword();
		userService = new UserServiceImpl(customCache);
		
		
		assertTrue(userService.signIn(username,password));
		
	}*/
	
}

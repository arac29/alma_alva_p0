package SoundSkiesService.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import SoundSkies.Dao.UserDaoPostgres;
import SoundSkies.pojos.User;
import SoundSkies.util.ConnectionUtil;

@RunWith(MockitoJUnitRunner.class)
public class PostDaoPostgresTest {
public UserDaoPostgres userDao = new UserDaoPostgres();
	
	@Mock
	private ConnectionUtil connUtil;
	
	@Mock 
	private Connection connection;
	
	
	
	private Statement stmt;
	//private PreparedStatement prepSt;
	
	private Statement spy;
	
	private Connection realConnection;
	
	@Before
	public void setUp() throws Exception {
		
		realConnection= new ConnectionUtil().createConnection();
		stmt= realConnection.createStatement();
		
		
		spy =Mockito.spy(stmt);
		
		when(connection.createStatement()).thenReturn(spy);
		
		when(connUtil.createConnection()).thenReturn(connection);
		userDao.setConnUtil(connUtil);
		
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void createUserTest() throws SQLException {
		
		User user = new User( "TestingUserName","pass", "emails@gmail.com");
		
		userDao.readUser(user.getUserId());
		
		String sql= "insert into users (username, password, email) values('TestingUserName','pass', 'emails@gmail.com');" ;
	
		
		//we want to know if it was sent to our database so we create a statement
		verify(spy).executeUpdate(sql);
		
		ResultSet rs = stmt.executeQuery("select * from users where username = 'TestingUserName' AND password = 'pass'");
		
		assertTrue(rs.next());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		stmt.executeUpdate("delete from users where username = 'TestingUserName' AND password = 'pass' ");
		
		realConnection.close();
		
	}

	
}

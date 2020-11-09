package SoundSkiesService.test;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import SoundSkies.util.ConnectionUtil;
import java.sql.DriverManager;

public class ConnectionUnitTest {
	private ConnectionUtil connectionUtil= new ConnectionUtil();
	//check if connection is working Integration test
	
	@Test 
	public void test() throws SQLException {
		
		Connection conn=connectionUtil.createConnection();
		
		conn.close();
	}
}

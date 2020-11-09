package SoundSkies.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import SoundSkies.pojos.User;
import SoundSkies.util.ConnectionUtil;
import org.apache.log4j.Logger;
public class UserDaoPostgres implements UserDao{
	private static Logger log = Logger.getRootLogger();
	private Statement statement;
	private PreparedStatement prepSt;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}


	@Override
	public void createUser(User user)  {
		
		String sql= "insert into users (username, password, email)"
					+ "values(?,?,?);" ;
		
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, user.getUsername());
			prepSt.setString(2, user.getPassword());
			prepSt.setString(3, user.getEmail());
			
			//Savepoint s1 = conn.setSavepoint();
			prepSt.executeUpdate();
			

			
			//conn.commit();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User readUser(int userId) {
		String sql ="select * from users where userid=?;";
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, Integer.toString(userId));
			
			prepSt.executeUpdate();

			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		String sql = "update user set username=?, password =? , email =? where user_id =?;" ;
		
		
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}

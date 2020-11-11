package SoundSkies.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SoundSkies.pojos.User;
import SoundSkies.util.ConnectionUtil;
import SoundSkies.util.signInException;

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
			
			prepSt.executeUpdate();

			log.info(" PostgreSQL created User " + user );
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User readUser(int userId) {
		String sql ="select * from users where user_id=" + userId;
		User user= new User();
		try ( Connection conn = connUtil.createConnection()){
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				
				String username = rs.getString( "username");
				String password = rs.getString( "password");
				String email = rs.getString( "email");
				
				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
			}
			
			log.info(" PostgreSQL reading User "  );
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> readAllUsers() {
		
		List <User> userList= new ArrayList <>();
		
		String sql= "Select * from users";
		
		try (Connection conn = connUtil.createConnection()) {
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			
			while(rs.next()) {
				User user= new User();
				int userId= rs.getInt("user_id");
				String username = rs.getString( "username");
				String password = rs.getString( "password");
				String email = rs.getString( "email");
				
				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public int updateUser(int userId, User user) {
		String sql = "update users set username=?, password =? , email =? where user_id =?;" ;
		int rows=0;
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, (user.getUsername()));
			prepSt.setString(2, (user.getPassword()));
			prepSt.setString(3, (user.getEmail()));
			prepSt.setInt(4, userId);
			
			rows=prepSt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int deleteUser(String username) {
		int rowsDeleted=0;
		String sql="delete from users where username= ?";
		
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, username);
			
			rowsDeleted= prepSt.executeUpdate();
			log.info(" Controller ----- deleting User" + username);
			if (rowsDeleted==0) {
				System.out.println("No rows deleted");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}

	@Override
	public User signIn(String username, String password) {
		int rows=0;
		
		String sql="select * from users where username=? and password=? ;";
		
		User user=new User();
		
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, (username));
			prepSt.setString(2, (password));
			ResultSet rs = prepSt.executeQuery();
			
			while(rs.next()) {
				
				int userId= rs.getInt("user_id");
				String userName = rs.getString( "username");
				String passWord = rs.getString( "password");
				String email = rs.getString( "email");
				
				user.setUserId(userId);
				user.setUsername(userName);
				user.setPassword(passWord);
				user.setEmail(email);
				rows++;
			}
			//rows=prepSt.executeUpdate();
			if (rows==0) {
				//return "User not found";
				log.info(" Controller ----- Failed to authenticate " + username);
				//return null;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return user;
	}

	@Override
	public void simplefunc(int userId) {
		
		String result="";
		
		String sql = "SELECT * FROM getpostbyuser (?)";
		
		try ( Connection conn = connUtil.createConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				 
                   result+= rs.getString("username");
                   result+= rs.getString("password");
            }
			log.info(" Controller ----- Authenticating"+result );
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

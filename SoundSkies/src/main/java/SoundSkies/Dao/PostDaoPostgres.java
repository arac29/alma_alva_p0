package SoundSkies.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SoundSkies.pojos.Post;
import SoundSkies.pojos.User;
import SoundSkies.util.ConnectionUtil;
import org.apache.log4j.Logger;

public class PostDaoPostgres implements PostDao{
	
	private static Logger log = Logger.getRootLogger();
	private Statement statement;
	private PreparedStatement prepSt;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}


	@Override
	public void createPost(Post post) {
		String sql= "insert into posts (user_id, title, filetype,genre,price)"
				+ "values(?,?,?,?,?);" ;
	
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setInt(1, post.getUserId());
			prepSt.setString(2, post.getTitle());
			prepSt.setString(3, post.getFileType());
			prepSt.setString(4, post.getGenre());
			prepSt.setDouble(5, post.getPrice());

			//log.info(" PostgreSQL created Post " + post );
			prepSt.executeUpdate();

			log.info(" PostgreSQL created Post " + post );
		
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Post readPost(int postId) {
		String sql ="select * from posts where post_id=" + postId;
		Post post= new Post();
		
		try ( Connection conn = connUtil.createConnection()){
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				
				int userId= rs.getInt( "user_id");
				String title = rs.getString( "title");
				String fileType = rs.getString( "filetype");
				String genre = rs.getString( "genre");
				Double price = rs.getDouble( "price");
				
				
				post.setUserId(postId);
				post.setTitle(title);
				post.setFileType(fileType);
				post.setGenre(genre);
				post.setPrice(price);
			}
			
			log.info(" PostgreSQL reading post " + post );
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	
	}

	@Override
	public List<Post> readAllPosts() {
		
		List<Post> postList = new ArrayList<>();
		
		String sql= "Select * from posts";
		
		try (Connection conn = connUtil.createConnection()) {
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Post post= new Post();
				int postId=rs.getInt("post_id");
				int userId= rs.getInt("user_id");
				String title = rs.getString( "title");
				String filetype= rs.getString( "fileType");
				String genre= rs.getString( "genre");
				Double price=rs.getDouble("price");
				
				post.setUserId(userId);
				post.setPostId(postId);
				post.setTitle(title);
				post.setFileType(filetype);
				post.setPrice(price);
				postList.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return postList;
	}
		

	@Override
	public int updatePost(int postId, Post post) {
		String sql = "update posts set title=? , filetype=? ,genre=?,price=? where post_id =? ;" ;
		int rows=0;
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, (post.getTitle()));
			prepSt.setString(2, (post.getFileType()));
			prepSt.setString(3, (post.getGenre()));
			prepSt.setDouble(4, post.getPrice());
			prepSt.setInt(5, postId);
			
			rows=prepSt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	
	}

	@Override
	public int deletePost(int postId) {
		int rowsDeleted=0;
		
		String sql="delete from posts where postId=" + postId;
		
		try ( Connection conn = connUtil.createConnection()){
			statement = conn.createStatement();
			
			rowsDeleted=statement.executeUpdate(sql);
			
			if (rowsDeleted==0) {
				System.out.println("No rows deleted");
			}
			log.info(" Controller ----- deleting Post" );
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}
	@Override
	public List<Post> readAllPostsByUser(int userId) {
		List<Post> postList = new ArrayList<>();
		
		String sql= "Select * from posts where user_id= "+ userId;
		
		try (Connection conn = connUtil.createConnection()) {
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Post post= new Post();
				int postId=rs.getInt("post_id");
				int userid= rs.getInt("user_id");
				String title = rs.getString( "title");
				String filetype= rs.getString( "fileType");
				String genre= rs.getString( "genre");
				Double price=rs.getDouble("price");
				
				post.setUserId(userid);
				post.setPostId(postId);
				post.setTitle(title);
				post.setFileType(filetype);
				post.setPrice(price);
				postList.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return postList;
	}
}
		
		/*
		String result;
		
		String sql = "SELECT * FROM getpostbyuser (?)";
		
		try ( Connection conn = connUtil.createConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				 
                   String un= rs.getString("username");
                   String p= rs.getString("password");
            }
            System.out.println(un + ".."+p);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}*/



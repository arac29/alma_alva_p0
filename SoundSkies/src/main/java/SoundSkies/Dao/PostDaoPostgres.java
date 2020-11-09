package SoundSkies.Dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import SoundSkies.pojos.Post;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post readPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post readAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(int postId, Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub
		
	}

}

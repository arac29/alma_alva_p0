package SoundSkies.service;
import java.util.List;

import org.apache.log4j.Logger;

import SoundSkies.Dao.PostDao;
import SoundSkies.Dao.PostDaoPostgres;

import SoundSkies.pojos.Post;


public class PostServiceFullStack implements PostService {
	
	private static Logger log = Logger.getRootLogger();
	
	PostDao postDao= new PostDaoPostgres();
	
	@Override
	public Post createPost(Post post) {
		postDao.createPost(post);
		log.info(" FullStack Service  create Post" );
		return post;
	}

	@Override
	public List<Post> getAllPosts() {
		log.info(" FullStack Service  read All posts" );
		return postDao.readAllPosts();
	}

	@Override
	public List<Post> readAllPostsByUser(int userId) {
		return postDao.readAllPostsByUser(userId);
	}
	
	@Override
	public int updatePost(int postId, Post post) {
		log.info(" FullStack Service  update post" );
		return postDao.updatePost(postId, post);
	}

	@Override
	public int deletePost(int postId) {
		log.info(" FullStack Service delete post" );
		return postDao.deletePost(postId);
		
	}

	@Override
	public Post readPost(int postId) {
		log.info(" FullStack Service  read post" );
		return postDao.readPost(postId);
	}

	

	

}

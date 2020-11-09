package SoundSkies.service;
import java.util.List;

import SoundSkies.pojos.*;


public class PostServiceImpl implements PostService {
	
	private CustomCacheService <Post> postCache= new CustomCacheServiceSimpleInMemory <Post>();
	
	public void setPostCache (CustomCacheService <Post> postCache) {
		this.postCache=postCache;
	}
	public PostServiceImpl (CustomCacheService<Post> postService) {
		super();
		this.postCache=postCache;
	}
	public PostServiceImpl() {
		super();
	}
	@Override
	public Post createPost (Post post) {
		
		System.out.println("Creating" + post + " post");
		postCache.addToCache(post);
		
		return post;
	}
	@Override
	public void addPostToList(Post post) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Post> getAllPosts() {
		
		return postCache.retrieveAllItems();
	}
	public List<Post> getAllPostsByUser(User user){
		
		
		return postCache.retrieveMatching(
				post-> Integer.toString(post.getUserId()).equals(Integer.toString(user.getUserId())));
		
	}
	
	
	
}

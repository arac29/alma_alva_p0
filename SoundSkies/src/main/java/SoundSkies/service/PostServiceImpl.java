package SoundSkies.service;
import java.util.List;

import SoundSkies.pojos.*;
import SoundSkies.pojos.Post.FileType;
import SoundSkies.pojos.Post.Genre;

public class PostServiceImpl implements PostService {
	private CustomCacheService <Post> postCache= new CustomCacheServiceSimpleInMemory <Post>();
	
	public void setPostCache (CustomCacheService <Post> postCache) {
		this.postCache=postCache;
	}
	public PostServiceImpl (CustomCacheService<Post> postService) {
		super();
		this.postCache=postCache;
	}
	@Override
	public Post createPost(int postID, User user, String title, double price, FileType fileType, Genre genre) {
		Post newPost = new Post(postID, user, title,price, fileType, genre);
		postCache.addToCache(newPost);
		// TODO Auto-generated method stub
		return newPost;
	}
	@Override
	public void addPostToList(Post post) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Post> getAllPosts() {
		
		return postCache.retrieveAllItems();
	}
	
	@Override
	public List<Post> getAllPostsByUserID(User userID) {
		// TODO Auto-generated method stub
		return postCache.retrieveMatching(
				post -> post.getUser().equals(userID));
	}
	
	
	
	
}

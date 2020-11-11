package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.Post;
import SoundSkies.pojos.Purchase;
import SoundSkies.pojos.User;


public interface PostService {
	
	public Post createPost(Post post);
	
	public Post readPost(int postId);

	public int updatePost(int postId,Post post);
	
	public int deletePost (int post);
	
	public List <Post> getAllPosts();
	
	public List<Post> readAllPostsByUser(int userId);



}

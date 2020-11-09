package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.Post;
import SoundSkies.pojos.Purchase;
import SoundSkies.pojos.User;


public interface PostService {
	
	public Post createPost(Post post);

	public void addPostToList(Post post);
	
	public List <Post> getAllPosts();
	
	public List<Post> getAllPostsByUser(User user);

}

package SoundSkies.Dao;
import java.util.List;

import SoundSkies.pojos.*;


public interface PostDao {
	
	public void createPost(Post post);
	
	public Post readPost(int postId);
	
	public List<Post> readAllPosts();
	
	public List <Post> readAllPostsByUser(int userId);
	
	public int updatePost(int postId, Post post);
	
	public int deletePost(int postId);

}

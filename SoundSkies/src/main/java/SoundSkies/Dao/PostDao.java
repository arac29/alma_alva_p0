package SoundSkies.Dao;
import SoundSkies.pojos.*;
public interface PostDao {
	public void createPost(Post post);
	
	public Post readPost(int postId);
	
	public Post readAllPosts();
	
	public Post updatePost(int postId, Post post);
	
	public void deletePost(Post post);

}

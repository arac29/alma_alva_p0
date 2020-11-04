package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.Post;
import SoundSkies.pojos.Purchase;
import SoundSkies.pojos.User;
import SoundSkies.pojos.Post.FileType;
import SoundSkies.pojos.Post.Genre;

public interface PostService {
	
	public Post createPost(User user, String title, double price, FileType fileType, Genre genre);

	public void addPostToList( Post post);
	
	public List <Post> getAllPosts();
	
	public List <Post> getAllPostsByUserID(User userID);


}

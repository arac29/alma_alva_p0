package SoundSkies.Dao;
import java.util.List;

import SoundSkies.pojos.*;

public interface UserDao {
	
	public void createUser(User user);
	
	public User readUser(int userId);
	
	public List<User> readAllUsers();
	
	public int updateUser(int userId, User user);
	
	public int deleteUser(String username);

	public User signIn(String username, String password);
	
	public void simplefunc(int userId);
}

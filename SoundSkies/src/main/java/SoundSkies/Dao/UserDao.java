package SoundSkies.Dao;
import SoundSkies.pojos.*;

public interface UserDao {
	
	public void createUser(User user);
	
	public User readUser(int userId);
	
	public User readAllUsers();
	
	public User updateUser(int userId, User user);
	
	public void deleteUser(User user);
}

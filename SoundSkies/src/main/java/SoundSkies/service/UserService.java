package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.*;
import SoundSkies.util.*;

public interface UserService {
	
	public User createUser(User user);
	
	public User readUser(int userId);
	
	public List<User> getAllUsers();
	
	public void updateUser(int userId, User user) throws UserUpdateException;
	
	public void deleteUser(String username);
	
	public User signIn(String username, String password);

	public void simplefunc(int userId);
}

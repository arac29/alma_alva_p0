package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.*;
import SoundSkies.util.UserUpdateException;

public class UserServiceImpl implements UserService {
	
	private CustomCacheService<User> userCache = new CustomCacheServiceSimpleInMemory<User>();
	
	public void setGuestCache(CustomCacheService<User> userCache) {
		this.userCache=userCache;
	}
	
	public UserServiceImpl(CustomCacheService<User> userCache) {
		super();
		this.userCache = userCache;
	}
	

	
	public UserServiceImpl() {
		super();
	}

	
	
	

	@Override
	public User createUser(User user) {
		System.out.println("Creating " + user + " object");
		userCache.addToCache(user);
		return user;
	}

	@Override
	public List<User> getAllGuests() {
		return userCache.retrieveAllItems();
	}

	@Override
	public void updateUser(int userId, User user) throws UserUpdateException {
		// TODO Auto-generated method stub
		
	}
	

}

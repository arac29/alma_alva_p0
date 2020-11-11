package SoundSkies.service;

import java.util.ArrayList;

import java.util.List;

import SoundSkies.Dao.UserDao;
import SoundSkies.Dao.UserDaoPostgres;
import SoundSkies.pojos.User;
import SoundSkies.util.UserUpdateException;
import org.apache.log4j.Logger;
public class UserServiceFullStack implements UserService {
	
	private static Logger log = Logger.getRootLogger();
	
	UserDao userDao= new UserDaoPostgres();

	@Override
	public User createUser(User user) {
		
		userDao.createUser(user);
		// validate data?
		
		log.info(" FullStack Service  create User" );
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		log.info(" FullStack Service  read All Users" );
		return userDao.readAllUsers();
		
	}
	
	@Override
	public void updateUser(int userId, User user) throws UserUpdateException{
		log.info(" FullStack Service  update User" );
		userDao.updateUser(userId, user);
	}

	@Override
	public User readUser(int userId) {
		log.info(" FullStack Service  read User" );
		return userDao.readUser(userId);
	}

	@Override
	public void deleteUser(String username) {
		log.info(" FullStack Service delete User" );
		userDao.deleteUser(username);
		
	}

	@Override
	public User signIn(String username, String password) {
		
		log.info(" FullStack Service  Authentication" );
		
		return userDao.signIn(username,password);
	}

	@Override
	public void simplefunc(int userId) {
		userDao.simplefunc(userId);
		
	}
	

}

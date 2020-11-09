package SoundSkies.service;

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
		
		return user;
	}



	@Override
	public List<User> getAllGuests() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateUser(int userId, User user) throws UserUpdateException{
		userDao.updateUser(userId, user);
	}

}

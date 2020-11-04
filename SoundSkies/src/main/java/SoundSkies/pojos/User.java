package SoundSkies.pojos;

import java.util.Arrays;

public class User { 
	private  static  int userCount;
	
	private int userID;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Post posts;
	
	private Purchase purchases;


	public User(int userID, String username, String password, String email, Post posts, Purchase purchases) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.posts = posts;
		this.purchases = purchases;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((purchases == null) ? 0 : purchases.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (purchases == null) {
			if (other.purchases != null)
				return false;
		} else if (!purchases.equals(other.purchases))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", posts=" + posts + ", purchases=" + purchases + "]";
	}


	public static int getUserCount() {
		return userCount;
	}


	public static void setUserCount(int userCount) {
		User.userCount = userCount;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Post getPosts() {
		return posts;
	}


	public void setPosts(Post posts) {
		this.posts = posts;
	}


	public Purchase getPurchases() {
		return purchases;
	}


	public void setPurchases(Purchase purchases) {
		this.purchases = purchases;
	}


	
	
}

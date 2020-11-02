package SoundSkies.pojos;

public class Post {
	private static int postCount;
	private int postID;
	
	private User user;
	
	private String title;
	
	private int size;
	
	public double price;
	
	public enum FileType{
		MP3,
		WAV,
		AIFF,
		WMA,
		FLAC,
		MIDI
		
	}
	public enum genre{
		PODCAST,
		EFFECT,
		ROCK,
		EDM,
		INDIE,
		JAZZ,
		POP,
		HIPHOP
	}
	
	public Post(int postID, User user, String title, int size, double price) {
		super();
		Post.postCount++;
		
		this.postID = Post.postCount;
		this.user = user;
		this.title = title;
		this.size = size;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Post [postID=" + postID + ", user=" + user + ", title=" + title + ", size=" + size + ", price=" + price
				+ "]";
	}

	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postID;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + size;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Post other = (Post) obj;
		if (postID != other.postID)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size != other.size)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
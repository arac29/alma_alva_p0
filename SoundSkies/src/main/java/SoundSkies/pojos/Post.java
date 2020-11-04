package SoundSkies.pojos;

public class Post {
	private static int postCount;
	private int postID;
	
	private User user;
	
	private String title;
		
	public double price;
	
	public enum FileType{
		MP3,
		WAV,
		AIFF,
		WMA,
		FLAC,
		MIDI
		
	}
	public enum Genre{
		PODCAST,
		EFFECT,
		ROCK,
		EDM,
		INDIE,
		JAZZ,
		POP,
		HIPHOP
	}
	
	private FileType fileType;
	
	private Genre genre;

	public Post(int postID, User user, String title, double price, FileType fileType, Genre genre) {
		super();
		Post.postCount++;
		this.postID = Post.postCount;
		this.user = user;
		this.title = title;
		this.price = price;
		this.fileType = fileType;
		this.genre = genre;
	}

	public static int getPostCount() {
		return postCount;
	}

	public static void setPostCount(int postCount) {
		Post.postCount = postCount;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + postID;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (fileType != other.fileType)
			return false;
		if (genre != other.genre)
			return false;
		if (postID != other.postID)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
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

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", user=" + user + ", title=" + title + ", price=" + price + ", fileType="
				+ fileType + ", genre=" + genre + "]";
	}




}
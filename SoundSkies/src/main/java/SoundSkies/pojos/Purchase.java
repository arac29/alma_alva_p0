package SoundSkies.pojos;

import java.util.Arrays;

public class Purchase {
	private static int purchaseCount;
	
	private User user;
	
	private int purchaseID;
	
	private Post post;
	
	private double amount;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Purchase(User user, int purchaseID, Post post, double amount) {
		super();
		Purchase.purchaseCount++;
		this.user = user;
		this.purchaseID = Purchase.purchaseCount;
		this.post = post;
		this.amount = amount;
	}

	public static int getPurchaseCount() {
		return purchaseCount;
	}

	public static void setPurchaseCount(int purchaseCount) {
		Purchase.purchaseCount = purchaseCount;
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + purchaseID;
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
		Purchase other = (Purchase) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (purchaseID != other.purchaseID)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Purchase [user=" + user + ", purchaseID=" + purchaseID + ", post=" + post + ", amount=" + amount + "]";
	}
	
	/*setters and getters */
	
	
	
	
	
	
	
	
	
}

package SoundSkies.pojos;

public class Purchase {
	private static int purchaseCount;
	
	private User[] users;
	
	private int purchaseID;
	
	private Post post;
	
	private double amount;

	public Purchase(User[] users, int purchaseID, Post post, double amount) {
		super();
		Purchase.purchaseCount++;
		this.users = users;
		this.purchaseID = Purchase.purchaseCount;
		this.post = post;
		this.amount = amount;
	}
	
	/*setters and getters */
	
	public static int getPurchaseCount() {
		return purchaseCount;
	}

	public static void setPurchaseCount(int purchaseCount) {
		Purchase.purchaseCount = purchaseCount;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
	
	
	
	
	
}

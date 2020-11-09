package SoundSkies.pojos;

import java.util.Arrays;

public class Purchase {
	private static int purchaseCount;
	
	private int purchaseId;
	
	private int postId; //FK
	
	private double amount;

	public Purchase() {
		super();
	}

	public Purchase( int postId, double amount) {
		super();
		purchaseCount++;
		this.purchaseId = purchaseCount;
		this.postId = postId;
		this.amount = amount;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", postId=" + postId + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + postId;
		result = prime * result + purchaseId;
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
		if (postId != other.postId)
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		return true;
	}
	
	
}
	
	
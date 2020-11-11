package SoundSkies.pojos;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

public class Purchase {
	private static int purchaseCount;
	
	private int purchaseId;
	
	private int postId; //FK
	
	private String date;

	public static int getPurchaseCount() {
		return purchaseCount;
	}

	public static void setPurchaseCount(int purchaseCount) {
		Purchase.purchaseCount = purchaseCount;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (postId != other.postId)
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		return true;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(int postId, String date) {
		super();
		purchaseCount++;
		this.purchaseId = purchaseCount;
		this.postId = postId;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", postId=" + postId + ", date=" + date + "]";
	}

	
	


}
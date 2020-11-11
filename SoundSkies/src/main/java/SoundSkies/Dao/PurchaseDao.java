package SoundSkies.Dao;
import java.util.List;

import SoundSkies.pojos.*;

public interface PurchaseDao {
	
	public void createPurchase(Purchase purchase);
	
	public Purchase readPurchase(int purchaseId);
	
	public List<Purchase> readAllPurchases();
	
	public List<Purchase> readAllPurchasesByPostId(int postId);
	
	public int updatePurchase(int purchaseId, Purchase purchase);
	
	public int deletePurchase(int purchaseId);

}

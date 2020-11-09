package SoundSkies.Dao;
import SoundSkies.pojos.*;
public interface PurchaseDao {
	
	public void createPurchase(Purchase purchase);
	
	public Purchase readPurchase(int purchaseId);
	
	public Purchase readAllPurchases();
	
	public Purchase updatePurchase(int purchaseId, Purchase purchase);
	
	public void deletePurchase(Purchase purchase);

}

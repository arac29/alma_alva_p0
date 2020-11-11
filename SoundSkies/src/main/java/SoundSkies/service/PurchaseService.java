package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.*;
public interface PurchaseService {
	
	public Purchase createPurchase(Purchase purchase);
	
	public Purchase readPurchase(int purchaseId);

	public void updatePurchase(int purchaseId,Purchase purchase);
	
	public void deletePurchase (int PurchaseId);
	
	public List<Purchase> readAllPurchases();
	
	public List<Purchase> readAllPurchasesByPostId(int postId);

	
}

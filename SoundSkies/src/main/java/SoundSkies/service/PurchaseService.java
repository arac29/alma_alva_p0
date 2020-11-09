package SoundSkies.service;

import java.util.List;

import SoundSkies.pojos.*;
public interface PurchaseService {
	
	public Purchase createPurchase(Purchase purchase);
	
	public void checkInPurchase(Purchase Purchase);
	
	public void checkOutPurchase(Purchase Purchase);
	
	public List<Purchase> getAllPurchases();
	
	public List<Purchase> getAllPurchasesByPost(Post post);

	
}

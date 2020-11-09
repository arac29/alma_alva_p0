package SoundSkies.service;
import java.util.List;

import SoundSkies.pojos.*;

public class PurchaseServiceImpl implements PurchaseService {
	
private CustomCacheService<Purchase>purchaseCache = new CustomCacheServiceSimpleInMemory<Purchase>();
	
	public void setGuestCache(CustomCacheService<Purchase> purchaseCache) {
		this.purchaseCache=purchaseCache;
	}
	
	public PurchaseServiceImpl(CustomCacheService<Purchase> purchaseCache) {
		super();
		this.purchaseCache = purchaseCache;
	}
	
	@Override
	public Purchase createPurchase(Purchase purchase) {
		System.out.println("Creating " + purchase + " object");
		purchaseCache.addToCache(purchase);
		return purchase;
	}
	@Override
	public void checkInPurchase(Purchase Purchase) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void checkOutPurchase(Purchase Purchase) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseCache.retrieveAllItems();
	}
	@Override
	public List<Purchase> getAllPurchasesByPost(Post post) {
		return purchaseCache.retrieveMatching(
				purchase ->Integer.toString(purchase.getPostId()).equals(Integer.toString(post.getPostId())));
	}

}

package SoundSkies.service;

import java.util.List;

import org.apache.log4j.Logger;

import SoundSkies.Dao.PurchaseDao;
import SoundSkies.Dao.PurchaseDaoPostgres;
import SoundSkies.pojos.Post;
import SoundSkies.pojos.Purchase;

public class PurchaseServiceFullStack implements PurchaseService {

	private static Logger log = Logger.getRootLogger();
	
	PurchaseDao purchaseDao= new PurchaseDaoPostgres();

	@Override
	public Purchase createPurchase(Purchase purchase) {
		purchaseDao.createPurchase(purchase);
		log.info(" FullStack Service  create Purchase" );
		return purchase;
	}

	@Override
	public Purchase readPurchase(int purchaseId) {
		log.info(" FullStack Service  read purchase" );
		return purchaseDao.readPurchase(purchaseId);
	}

	@Override
	public void updatePurchase(int purchaseId, Purchase purchase) {
		log.info(" FullStack Service  update User" );
		purchaseDao.updatePurchase(purchaseId, purchase);
	}
	

	@Override
	public void deletePurchase(int purchaseId) {
		log.info(" FullStack Service delete Purchase" );
		purchaseDao.deletePurchase(purchaseId);
	}

	@Override
	public List<Purchase> readAllPurchases() {
		log.info(" FullStack Service  read All Purchases" );
		return purchaseDao.readAllPurchases();
	}

	@Override
	public List<Purchase> readAllPurchasesByPostId(int postId) {
		return purchaseDao.readAllPurchasesByPostId(postId);
	}
	
	
}

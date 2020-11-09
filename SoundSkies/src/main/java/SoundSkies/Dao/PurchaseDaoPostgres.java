package SoundSkies.Dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import SoundSkies.pojos.Purchase;
import SoundSkies.util.ConnectionUtil;
import org.apache.log4j.Logger;
public class PurchaseDaoPostgres implements PurchaseDao {
	private static Logger log = Logger.getRootLogger();
	private Statement statement;
	private PreparedStatement prepSt;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Purchase readPurchase(int purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase readAllPurchases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase updatePurchase(int purchaseId, Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		
	}

}

package SoundSkies.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import SoundSkies.pojos.Post;
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
		String sql= "insert into purchases (post_id, date)"
				+ "values(?,?);" ;
	
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setInt(1, purchase.getPostId());
			prepSt.setTimestamp(2, Timestamp.valueOf(purchase.getDate()));
			//prepSt.(2,purchase.getDate());
			//prepSt.setTimestamp(2, purchase.getDate());
			prepSt.executeUpdate();
			log.info(" PostgreSQL created Purchase " );
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Purchase readPurchase(int purchaseId) {
		
		String sql= "Select * from purchases where purchase_id="+purchaseId;
		Purchase purchase= new Purchase();
		try (Connection conn = connUtil.createConnection()) {
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				
				int purchaseid=rs.getInt("purchase_id");
				int postId= rs.getInt("post_id");
				String date=rs.getString("date");
				
				purchase.setPurchaseId(purchaseid);
				purchase.setPostId(postId);
				purchase.setDate(date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return purchase;
	}

	@Override
	public List <Purchase> readAllPurchases() {
		
		List<Purchase> purchasesList = new ArrayList<>();
		
		String sql= "Select * from purchases";
		
		try (Connection conn = connUtil.createConnection()) {
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				
				Purchase purchase= new Purchase();
				
				int purchaseId=rs.getInt("purchase_id");
				int postId= rs.getInt("post_id");
				String date=rs.getString("date");
				
				purchase.setPurchaseId(purchaseId);
				purchase.setPostId(postId);
				purchase.setDate(date);
				
				purchasesList.add(purchase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return purchasesList;
	}

	@Override
	public int updatePurchase(int purchaseId, Purchase purchase) {
		String sql = "update purchases set post_id=? ,date=? where purchase_id =? ;" ;
		int rows=0;
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setInt(1, (purchase.getPostId()));
			//prepSt.setString(2, (purchase.getDate()));
			prepSt.setTimestamp(2, Timestamp.valueOf(purchase.getDate()));
			prepSt.setInt(3, (purchaseId));
			
			rows=prepSt.executeUpdate();
			//
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	
	}

	@Override
	public int deletePurchase(int purchaseId) {
		int rowsDeleted=0;
		
		String sql="delete from purchases where purchase_id=" + purchaseId;
		
		try ( Connection conn = connUtil.createConnection()){
			statement = conn.createStatement();
			
			rowsDeleted=statement.executeUpdate(sql);
			
			if (rowsDeleted==0) {
				System.out.println("No rows deleted");
			}
			log.info(" Controller ----- deleting purchase" + purchaseId );
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}

	@Override
	public List<Purchase> readAllPurchasesByPostId(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}

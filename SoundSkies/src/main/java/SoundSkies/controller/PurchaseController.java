package SoundSkies.controller;

import org.apache.log4j.Logger;

import SoundSkies.pojos.Post;
import SoundSkies.pojos.Purchase;
import SoundSkies.service.*;
import io.javalin.http.Context;

public class PurchaseController {
	
	private static Logger log = Logger.getRootLogger();
	
	PurchaseService purchaseService= new PurchaseServiceFullStack();

	public void createPurchase(Context ctx) {
	
		log.info(" Controller ----- creating Purchase");
		
		int postId=Integer.parseInt(ctx.formParam( "post_id"));
		
		String date = ctx.formParam("date");
	
		Purchase purchase = new Purchase(postId, date);
		
		purchaseService.createPurchase(purchase);
		
		ctx.html(Integer.toString(purchase.getPurchaseId()));
	
	}

	public void readPurchase(Context ctx) {
		log.info(" Controller -----reading a Purchase" );
		
		int purchaseId=Integer.parseInt(ctx.formParam( "purchase_id"));
		
		ctx.html(purchaseService.readPurchase(purchaseId).toString());
	
	}

	public void updatePurchase(Context ctx) {
		log.info(" Controller ----- update Purchase");
		
		int purchaseId=Integer.parseInt(ctx.formParam("purchase_id"));
		
		int postId=Integer.parseInt(ctx.formParam( "post_id"));
		
		String date = ctx.formParam("date");
		
		Purchase purchase=new Purchase(postId,date);
	
		try {
			purchaseService.updatePurchase(purchaseId,purchase);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}

	public void deletePurchase(Context ctx) {
		log.info(" Controller ----- deleting Purchase" );
		
		int purchaseId=Integer.parseInt(ctx.formParam( "purchase_id"));
		
		purchaseService.deletePurchase(purchaseId);
	}

	public void readAllPurchases(Context ctx) {
		log.info(" Controller ----- reads all purchases" );
		
		
		ctx.html(purchaseService.readAllPurchases().toString());
	}

	public void readAllPurchasesByPostId(Context ctx) {
		
		
		int postId=Integer.parseInt(ctx.formParam("user_id"));
		log.info(" Controller ----- reads all posts" +postId );
		
		ctx.html(purchaseService.readAllPurchasesByPostId(postId).toString());
	}

}

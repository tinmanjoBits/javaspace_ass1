package com.jsauctiondr.model;

import net.jini.core.entry.Entry;


public class Lot extends AbstractIndexedEntry implements Entry {
	
	
	
	public AuctionUser seller;
	public String itemTitle;
	public String itemDesc;
	public String itemID;
	public Integer currentPrice;
	public Integer targetPrice;
	

	public Lot() {

		// TODO Auto-generated constructor stub
	}
	
	
	public Lot(AuctionUser user, String title, String itemID){
		
	}

}

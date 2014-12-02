package com.jsauctiondr.model;

import java.util.Date;

import net.jini.core.entry.Entry;


public class Bid extends AbstractIndexedEntry implements Entry {
	
	
	
	public AuctionUser bidder;
	public Lot	lotBidded;
	public Integer amountBidded;
	public Date biddedAt;

	public Bid() {

		
	}

	
	public Bid(AuctionUser bidder, Lot lot, int amount){
		
		
		this.bidder = bidder;
		this.lotBidded = lot;
		this.amountBidded = amount;
		
	}
}

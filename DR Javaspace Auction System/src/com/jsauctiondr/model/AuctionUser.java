package com.jsauctiondr.model;

import net.jini.core.entry.Entry;


public class AuctionUser extends AbstractIndexedEntry implements Entry {
	
	
	public Integer id=1;
	public String username;
	public String password;
	public Integer totalBids;
	public Integer totalLots;
	

	public AuctionUser() {

		// TODO Auto-generated constructor stub
	}
	
	public AuctionUser(String user, String password){
		
		this.username = user;
		this.password = password;
	}

}

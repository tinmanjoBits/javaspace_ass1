
package com.jsauctiondr.util;

import com.jsauctiondr.model.AuctionUser;

import net.jini.space.JavaSpace;

public class JavaSpaceTest {

	public static void main(String[] args) {

		JavaSpace space;
		space = SpaceUtils.getSpace();

		System.out.println("Javaspace found and accessed: PASS");
		EntryManager entMgr = new EntryManager(space);

		AuctionUser userTmp = new AuctionUser();
		AuctionUser user = new AuctionUser("userNorm", "meme");

		System.out.println("Testing Javaspace write and take with no transactions...");

		entMgr.writeEntry(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace writen to : PASS");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AuctionUser result = (AuctionUser) entMgr.takeEntry(userTmp, 4000l);

		if (result != null) {
			System.out.println("Javaspace reclaimed entry: PASS");
		} else {
			System.out.println("Javaspace reclaimed entry: FAILED");
		}

		System.out.println("Testing Javaspace write and take with transaction... ");
		result = null;
		user.username="userTrans";	
		
		entMgr.writeEntryTransaction(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace written to with transaction : PASS");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result=(AuctionUser) entMgr.takeEntryTransaction(userTmp, 4000l);
		
		if (result != null) {
			System.out.println("Javaspace reclaimed entry with transaction: PASS");
		} else {
			System.out.println("Javaspace reclaimed entry with transaction: FAILED");
		}
		
		
		System.out.println("Javaspace test transaction failed due intermittant system takes...");
		
		result = null;
		user.username="userTransFail";	
		
		entMgr.writeEntryTransaction(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace written to with transaction : PASS");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		AuctionUser resultFailed=(AuctionUser) entMgr.takeEntry(userTmp, 4000l);
		
		
		result=(AuctionUser) entMgr.takeEntryTransaction(userTmp, 4000l);
		
		if(resultFailed == null){
			System.out.println("Javaspace intermitant take test with transaction: PASS");
		}else{
			System.out.println("Javaspace intermitant take test with transaction: FAIL");
		}

	}

}


package com.jsauctiondr.util;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingUtilities;

import com.jsauctiondr.model.AuctionUser;
import com.jsauctiondr.model.GenericIndexer;

import net.jini.space.JavaSpace;

public class JavaSpaceTest {

	public JavaSpace space;
	public EntryManager entMgr;
	public AuctionUser user1, user2, userTmp, result, user;

	public JavaSpaceTest() {

		System.out.println("Javaspace found and accessed: PASS \n");
		space = SpaceUtils.getSpace();

		// testSpace();
		testReadWrite();
		// testTransactionsReadWrite();
		// testTransactionsIntermittantTake();
		testAddingRemovingEntries();
		testNotifyAdding();
		testNotifyRemoved();

	}

	private void testNotifyRemoved() {

		// TODO Auto-generated method stub

	}

	private void testNotifyAdding() {

		// TODO Auto-generated method stub

	}

	private void testAddingRemovingEntries() {

		Random rnd = new Random();

		GenericIndexer userIndexer = new GenericIndexer("users111122");
		GenericIndexer tmpIndexer = new GenericIndexer(userIndexer.indexerName);

		// ArrayList<AuctionUser> usersList=new ArrayList<AuctionUser>();

		// write indexer
		entMgr.writeEntry(userIndexer, Long.MAX_VALUE);

		// add users to array
		for (int i = 0; i < 10; i++) {

			// get indexer
			GenericIndexer result = (GenericIndexer) entMgr.takeEntry(tmpIndexer, 4000l);
			System.out.println("\nTake the indexer:" + result.indexerName + ", " + result.indexerLength);

			// add user index, name etc..
			user.index = result.incrementIndex();
			user.username = String.valueOf("user:" + rnd.nextInt() + "|" + user.index);
			user.indexer = result.indexerName;
			System.out.println("User created ready to write:" + user.indexer + ", " + user.username);

			// write indexer
			entMgr.writeEntry(result, Long.MAX_VALUE);
			System.out.println("Write the indexer:" + result.indexerName + ", " + result.indexerLength);

			// write user
			entMgr.writeEntry(user, Long.MAX_VALUE);
			System.out.println("User written to space:" + user.indexer + ", " + user.username + "\n");

		}

		System.out.println("\n User indexer and users written to space :PASS");

		System.out.println("Attempting retrieval of users,  last counted(" + user.index + ")");

		result =null;
		
		for (int i = 0; i < 10; i++) {

			// get indexer
			GenericIndexer result = (GenericIndexer) entMgr.takeEntry(tmpIndexer, 4000l);
			System.out.println("\nTake the indexer:" + result.indexerName + ", " + result.indexerLength);

			
			
			
			// set user index, name etc..
			user.index = result.decrementIndex();
			user.indexer = result.indexerName;
			System.out.println("User set ready to take:" + user.indexer + ", " + user.username);

			// write indexer
			entMgr.writeEntry(result, Long.MAX_VALUE);
			System.out.println("Write the indexer:" + result.indexerName + ", " + result.indexerLength);

			// take user
			entMgr.writeEntry(user, Long.MAX_VALUE);
			System.out.println("User removed from space:" + user.indexer + ", " + user.username + "\n");

		}
		
		
		System.out.println("Removed all users, last("+user.index+")");

	}

	private void testTransactionsIntermittantTake() {

		System.out.println("\nJavaspace test transaction failed due intermittant system takes...");

		AuctionUser result = null;
		user.username = "userTransFail";

		entMgr.writeEntryTransaction(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace written to with transaction : PASS");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntryManager tmpEntryManager = new EntryManager(space);
		AuctionUser resultFailed = (AuctionUser) tmpEntryManager.takeEntryTransaction(userTmp, 4000l);

		result = (AuctionUser) entMgr.takeEntryTransaction(userTmp, 4000l);

		if (resultFailed == null && result != null) {
			System.out.println("Javaspace intermitant take test with transaction: PASS");
		} else {
			System.out.println("Javaspace intermitant take test with transaction: FAIL");
		}

	}

	private void testTransactionsReadWrite() {

		System.out.println("\nTesting Javaspace write and take with transaction... ");
		result = null;
		user.username = "userTrans";

		entMgr.writeEntryTransaction(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace written to with transaction : PASS");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = (AuctionUser) entMgr.takeEntryTransaction(userTmp, 4000l);

		if (result != null) {
			System.out.println("Javaspace reclaimed entry with transaction: PASS");
		} else {
			System.out.println("Javaspace reclaimed entry with transaction: FAILED");
		}// TODO Auto-generated method stub

	}

	private void testReadWrite() {

		entMgr = new EntryManager(space);

		userTmp = new AuctionUser();
		user = new AuctionUser("userNorm", "meme");

		System.out.println("Testing Javaspace write and take with no transactions...");

		entMgr.writeEntry(userTmp, Long.MAX_VALUE);
		System.out.println("Javaspace writen to : PASS");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = (AuctionUser) entMgr.takeEntry(userTmp, 4000l);

		if (result != null) {
			System.out.println("Javaspace reclaimed entry: PASS");
		} else {
			System.out.println("Javaspace reclaimed entry: FAILED");
		}// TODO Auto-generated method stub

	}

	private void testSpace() {

		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				JavaSpaceTest test = new JavaSpaceTest();

			}
		});

	}

}


package com.jsauctiondr.util;

import javax.swing.SwingUtilities;

import com.jsauctiondr.model.AuctionUser;

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
		testTransactionsReadWrite();
		testTransactionsIntermittantTake();
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

		// TODO Auto-generated method stub

	}

	private void testTransactionsIntermittantTake() {

		System.out
				.println("\nJavaspace test transaction failed due intermittant system takes...");

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
		AuctionUser resultFailed = (AuctionUser) tmpEntryManager
				.takeEntryTransaction(userTmp, 4000l);

		result = (AuctionUser) entMgr.takeEntryTransaction(userTmp, 4000l);

		if (resultFailed == null && result != null) {
			System.out
					.println("Javaspace intermitant take test with transaction: PASS");
		} else {
			System.out
					.println("Javaspace intermitant take test with transaction: FAIL");
		}

	}

	private void testTransactionsReadWrite() {

		System.out
				.println("\nTesting Javaspace write and take with transaction... ");
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
			System.out
					.println("Javaspace reclaimed entry with transaction: PASS");
		} else {
			System.out
					.println("Javaspace reclaimed entry with transaction: FAILED");
		}// TODO Auto-generated method stub

	}

	private void testReadWrite() {

		EntryManager entMgr = new EntryManager(space);

		userTmp = new AuctionUser();
		user = new AuctionUser("userNorm", "meme");

		System.out
				.println("Testing Javaspace write and take with no transactions...");

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

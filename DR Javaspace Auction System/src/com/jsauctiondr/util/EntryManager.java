package com.jsauctiondr.util;
import java.rmi.RemoteException;

import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lease.Lease;
import net.jini.core.lease.LeaseDeniedException;
import net.jini.core.transaction.CannotAbortException;
import net.jini.core.transaction.Transaction;
import net.jini.core.transaction.Transaction.Created;
import net.jini.core.transaction.TransactionException;
import net.jini.core.transaction.TransactionFactory;
import net.jini.core.transaction.UnknownTransactionException;
import net.jini.core.transaction.server.TransactionManager;
import net.jini.space.JavaSpace;


public class EntryManager {



	private JavaSpace space;
	private TransactionManager transMgr;
	private Transaction txn;
	//private Transaction.Created trc;

	public EntryManager(JavaSpace space)
	{
		this.space=space;
		transMgr = SpaceUtils.getManager();
		txn = null;
		//Transaction.Created trc =null;
	}



	public Entry takeEntryTransaction(Entry template, Long lease){

		Transaction.Created trc=null;

		try {
			trc =TransactionFactory.create(transMgr, 8000);

		} catch (LeaseDeniedException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(trc == null){
			System.err.println("Transaction not created.");
			return null;
		}

		txn=trc.transaction;



		try {
			Entry entry=space.take(template, txn, lease);
			return entry;
		} catch (RemoteException | UnusableEntryException
				| TransactionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return null;


	}



	public Entry takeEntry(Entry template, Long lease){



		try {
			Entry entry=space.take(template, null, lease);
			return entry;
		} catch (RemoteException | UnusableEntryException
				| TransactionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return null;


	}

	public Entry copyEntry(Entry template, Long lease){


		try {
			Entry entry=space.read(template, null, lease);
			return entry;
		} catch (RemoteException | UnusableEntryException
				| TransactionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return null;


	}

	public void writeEntryTransaction(Entry template, Long leaseDuration) {


		try {
			space.write(template, txn, leaseDuration);
			if(txn!=null){
				txn.commit();
			}
		} catch (RemoteException | TransactionException e) {

			try {
				txn.abort();
			} catch (UnknownTransactionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CannotAbortException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		



	}


	public void writeEntry(Entry template, Long leaseDuration) {
		try {
			space.write(template,null, leaseDuration);

		} catch (RemoteException | TransactionException e) {


		}
	}


}

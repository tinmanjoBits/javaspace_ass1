
package com.jsauctiondr.util;

import net.jini.space.JavaSpace;

import com.jsauctiondr.model.AbstractEntry;
import com.jsauctiondr.model.GenericIndexer;


public class RemoveAllEntries {

	public static void main(String[] args) {

		// get space and manager
		JavaSpace space = SpaceUtils.getSpace();
		EntryManager entMgr = new EntryManager(space);

		// remove indexers id 2000
		GenericIndexer tmpIndexer = new GenericIndexer();
		GenericIndexer resultIndexer;
		tmpIndexer.id = 2000;
		
		boolean noElements = false;

		while (!noElements) {

			resultIndexer = (GenericIndexer) entMgr.takeEntry(tmpIndexer, 5000l);

			if (resultIndexer !=null){
				System.out.println(resultIndexer.indexerName + ":  " + resultIndexer.toString() + ": Removed!");
				noElements=false;
			}else{
				noElements=true;
			}
			
		}

		// remove lots id 2
		noElements =false;
		
		AbstractEntry tmpEntry = new AbstractEntry();
		AbstractEntry resultEntry;
		tmpEntry.id = 1;

		while (!noElements) {

			resultEntry =  (AbstractEntry) entMgr.takeEntry(tmpEntry, 5000l);

			if (resultEntry !=null){
				System.out.println(tmpEntry.toString() + ": Removed!");
			}else{
				noElements=true;
			}
			
		}
		
		
		System.out.println("Entries removed or none found...");
	}

}

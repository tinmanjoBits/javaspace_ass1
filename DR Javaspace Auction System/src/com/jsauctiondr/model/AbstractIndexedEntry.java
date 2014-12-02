package com.jsauctiondr.model;

import net.jini.core.entry.Entry;


public class AbstractIndexedEntry implements Entry {
	
	
	
	public Integer index;
	public String indexer;

	public AbstractIndexedEntry() {

		// TODO Auto-generated constructor stub
	}
	
	public AbstractIndexedEntry(String indexer){
		this.indexer = indexer;
	}

}

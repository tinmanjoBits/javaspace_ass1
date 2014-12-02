
package com.jsauctiondr.model;

import net.jini.core.entry.Entry;

public class GenericIndexer implements Entry {

	public Integer id = 2000;
	public String indexerName;
	public Integer indexerLength;

	public GenericIndexer() {

		// TODO Auto-generated constructor stub
	}

	public GenericIndexer(String name) {

		this.indexerName = name;
		//this.indexerLength = new Integer(0);
	}

	public Integer incrementIndex() {

		if (this.indexerLength == null) {
			this.indexerLength = new Integer(1);
			return this.indexerLength;
		} else {

			this.indexerLength = new Integer(this.indexerLength + 1);
			return this.indexerLength;
		}
	}
	
	public Integer decrementIndex() {

		if (this.indexerLength == null) {
			this.indexerLength = new Integer(0);
			return this.indexerLength;
		} else {

			this.indexerLength = new Integer(this.indexerLength -1);
			return this.indexerLength+1;
		}
	}

}

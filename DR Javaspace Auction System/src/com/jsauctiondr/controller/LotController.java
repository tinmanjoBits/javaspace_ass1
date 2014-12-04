package com.jsauctiondr.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import net.jini.space.JavaSpace;

import com.jsauctiondr.model.Lot;
import com.jsauctiondr.util.EntryManager;
import com.jsauctiondr.view.AuctionPanel;


public class LotController implements Observer {
	
	AuctionPanel lotPanel;
	JavaSpace space;

	public LotController(JavaSpace space, AuctionPanel aPanel) {

		
		this.lotPanel=aPanel;
		this.space = space;
		
		
		
	}
	
	
	public void createLot(){
		
		EntryManager entMgr=new EntryManager(space);
		
		
		Lot lotTmp=new Lot();
		
		
		
	}


	@Override
	public void update(Observable o, Object arg) {

		// TODO Auto-generated method stub
		
	}
	
	

	
	

}

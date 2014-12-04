package com.jsauctiondr.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.jini.space.JavaSpace;

import com.jsauctiondr.model.Lot;
import com.jsauctiondr.util.EntryManager;
import com.jsauctiondr.view.AuctionPanel;


public class LotController {
	
	AuctionPanel lotPanel;
	JavaSpace space;

	public LotController(JavaSpace space, AuctionPanel aPanel) {

		
		this.lotPanel=aPanel;
		this.space = space;
		
		
		lotPanel.btnAddLot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				createLot();
				
			}
		});
	}
	
	
	public void createLot(){
		
		EntryManager entMgr=new EntryManager(space);
		
		
		Lot lotTmp=new Lot();
		
		if(lotPanel.panelLots)
		
	}
	
	

	
	

}

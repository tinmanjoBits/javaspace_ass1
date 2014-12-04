package com.jsauctiondr.controller;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.jini.space.JavaSpace;

import com.jsauctiondr.util.SpaceUtils;
import com.jsauctiondr.view.*;


public class MainController extends JFrame {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuctionPanel aPanel;
	private JPanel contentPane;
	private BidManager bidMgr;
	private LotController lotMgr;
	private UserManager userMgr;

	public MainController()  {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		aPanel=new AuctionPanel();
		contentPane.add(aPanel, BorderLayout.CENTER);
		
		JavaSpace space=SpaceUtils.getSpace();
		
		lotMgr = new LotController(space, aPanel);
		//bidMgr = new BidManager(aPanel);
		//userMgr = new UserManager(aPanel);
		
		
		
		
		
		
		
	}

	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainController frame = new MainController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

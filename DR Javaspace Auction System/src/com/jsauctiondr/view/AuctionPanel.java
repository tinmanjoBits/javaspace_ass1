package com.jsauctiondr.view;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;




public class AuctionPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtLotPrice;
	public JTextField txtLotMin;
	public JTextField txtBidAmount;
	public JTextField txtInfDesc;
	public JLabel lbUser;
	public JTabbedPane tabbedPane;
	public JPanel sellPanel;
	public JTextField txtLotid;
	public JTextField txtLotTitle;
	public JTextField txtLotDesc;
	public JButton btnNewLot;
	public JButton btnCancelLot;
	public JComboBox cboCat;
	public JLabel lbLotExpirary;
	public JButton btnAddLot;
	public JLabel lbBidID;
	public JLabel lblLot;
	public JButton btnSaveBid;
	public JButton btnNewBid;
	public JButton btnCancelBid;
	public JLabel lbInfLotId;
	public JLabel lbInfLotTitle;
	public JLabel lbInfPrice;
	public JLabel lbInffExpires;
	public JLabel lblLots;
	public JLabel lblBids;
	public JLabel lblSold;
	public JLabel lblWon;
	public DefaultTableModel yourLotsModel;
	public JTable tblYourLots;
	public JPanel panelYourLots;
	public JPanel panelBidsPlaced;
	public JPanel panelAllLotSelltb;
	public JLabel lblUser;
	public JPanel panelLotDet;
	public JLabel lblLotId;
	public JLabel lblTitle;
	public JLabel lblDesc;
	public JLabel lblPrice;
	public JLabel lblMinBid;
	public JLabel lblExpires;
	public JPanel buyPanel;
	public JPanel panelLots;
	public JPanel panelBids;
	public JPanel panelYourBids;
	public JPanel panelBidDetails;
	public JLabel lblBidid;
	public JLabel lblLotid;
	public JLabel lblBidAmount;
	public JPanel panelLotDetails;

	public AuctionPanel(){
		
		setLayout(null);
		
		lblUser = new JLabel("User:");
		lblUser.setBounds(10, 11, 46, 14);
		add(lblUser);
		
		lbUser = new JLabel("u100000");
		lblUser.setBounds(55, 11, 80, 14);
		add(lblUser);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 854, 477);
		add(tabbedPane);
		
		sellPanel = new SellingPanel();
		tabbedPane.addTab("Selling", null, sellPanel, null);
		sellPanel.setLayout(null);
		
		panelYourLots = new JPanel();
		panelYourLots.setBorder(new TitledBorder(null, "Your lots:-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelYourLots.setBounds(10, 11, 270, 255);
		sellPanel.add(panelYourLots);
		
		panelBidsPlaced = new JPanel();
		panelBidsPlaced.setBorder(new TitledBorder(null, "Bids Placed", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBidsPlaced.setBounds(290, 11, 270, 255);
		sellPanel.add(panelBidsPlaced);
		
		panelAllLotSelltb = new JPanel();
		panelAllLotSelltb.setBorder(new TitledBorder(null, "All lots", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAllLotSelltb.setBounds(570, 11, 269, 416);
		sellPanel.add(panelAllLotSelltb);
		
		panelLotDet = new JPanel();
		panelLotDet.setBorder(new TitledBorder(null, "Lot details:-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLotDet.setBounds(10, 277, 546, 161);
		sellPanel.add(panelLotDet);
		panelLotDet.setLayout(null);
		
		lblLotId = new JLabel("Lot id:");
		lblLotId.setBounds(10, 22, 46, 14);
		panelLotDet.add(lblLotId);
		
		txtLotid = new JTextField("l3333334");
		txtLotid.setEditable(false);
		txtLotid.setBounds(51, 22, 92, 14);
		panelLotDet.add(txtLotid);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 39, 46, 14);
		panelLotDet.add(lblTitle);
		
		txtLotTitle = new JTextField("dsdfsdfsdf");
		txtLotTitle.setBounds(51, 39, 210, 14);
		panelLotDet.add(txtLotTitle);
		
		lblDesc = new JLabel("Desc:");
		lblDesc.setBounds(10, 58, 46, 14);
		panelLotDet.add(lblDesc);
		
		txtLotDesc = new JTextField("dfsggsdfsd f sdf sdf sd f");
		txtLotDesc.setBounds(51, 58, 193, 37);
		panelLotDet.add(txtLotDesc);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 106, 46, 14);
		panelLotDet.add(lblPrice);
		
		txtLotPrice = new JTextField();
		txtLotPrice.setText("34.00");
		txtLotPrice.setBounds(51, 106, 86, 20);
		panelLotDet.add(txtLotPrice);
		txtLotPrice.setColumns(10);
		
		lblMinBid = new JLabel("Min Bid:");
		lblMinBid.setBounds(10, 136, 46, 14);
		panelLotDet.add(lblMinBid);
		
		txtLotMin = new JTextField();
		txtLotMin.setText("40.00");
		txtLotMin.setBounds(61, 133, 86, 20);
		panelLotDet.add(txtLotMin);
		txtLotMin.setColumns(10);
		
		btnNewLot = new JButton("New Lot");
		btnNewLot.setBounds(331, 127, 89, 23);
		panelLotDet.add(btnNewLot);
		
		btnCancelLot = new JButton("Cancel Lot");
		btnCancelLot.setBounds(430, 127, 89, 23);
		panelLotDet.add(btnCancelLot);
		
		
		lblExpires = new JLabel("Expires:");
		lblExpires.setBounds(268, 72, 46, 14);
		panelLotDet.add(lblExpires);
		
		lbLotExpirary = new JLabel("2345s");
		lbLotExpirary.setBounds(324, 72, 46, 14);
		panelLotDet.add(lbLotExpirary);
		
		btnAddLot = new JButton("Add Lot");
		btnAddLot.setEnabled(false);
		
		btnAddLot.setBounds(331, 93, 89, 23);
		panelLotDet.add(btnAddLot);
		
		buyPanel = new JPanel();
		tabbedPane.addTab("Buying", null, buyPanel, null);
		buyPanel.setLayout(null);
		
		panelLots = new JPanel();
		panelLots.setBorder(new TitledBorder(null, "Lots:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLots.setBounds(10, 11, 241, 233);
		buyPanel.add(panelLots);
		
		panelBids = new JPanel();
		panelBids.setBorder(new TitledBorder(null, "All bids:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBids.setBounds(261, 11, 305, 233);
		buyPanel.add(panelBids);
		
		panelYourBids = new JPanel();
		panelYourBids.setBorder(new TitledBorder(null, "Your bids:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelYourBids.setBounds(576, 11, 263, 233);
		buyPanel.add(panelYourBids);
		
		panelBidDetails = new JPanel();
		panelBidDetails.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bid details:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBidDetails.setBounds(403, 249, 436, 189);
		buyPanel.add(panelBidDetails);
		panelBidDetails.setLayout(null);
		
		lblBidid = new JLabel("BidID:");
		lblBidid.setBounds(10, 31, 46, 14);
		panelBidDetails.add(lblBidid);
		
		lbBidID = new JLabel("b123455");
		lbBidID.setBounds(53, 31, 111, 14);
		panelBidDetails.add(lbBidID);
		
		lblLotid = new JLabel("LotID:");
		lblLotid.setBounds(10, 56, 46, 14);
		panelBidDetails.add(lblLotid);
		
		lblLot = new JLabel("lot2233333333");
		lblLot.setBounds(53, 56, 111, 14);
		panelBidDetails.add(lblLot);
		
		lblBidAmount = new JLabel("Bid amount:");
		lblBidAmount.setBounds(10, 80, 69, 14);
		panelBidDetails.add(lblBidAmount);
		
		txtBidAmount = new JTextField();
		txtBidAmount.setText("45.00");
		txtBidAmount.setBounds(78, 81, 86, 14);
		panelBidDetails.add(txtBidAmount);
		txtBidAmount.setColumns(10);
		
		btnNewBid = new JButton("New Bid");
		btnNewBid.setBounds(22, 141, 89, 23);
		panelBidDetails.add(btnNewBid);
		
		btnSaveBid = new JButton("Save Bid");
		btnSaveBid.setEnabled(false);
		btnSaveBid.setBounds(22, 107, 89, 23);
		panelBidDetails.add(btnSaveBid);
		
		btnCancelBid = new JButton("Cancel Bid");
		btnCancelBid.setBounds(138, 141, 89, 23);
		panelBidDetails.add(btnCancelBid);
		
		panelLotDetails = new JPanel();
		panelLotDetails.setBorder(new TitledBorder(null, "Lot details:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLotDetails.setBounds(10, 249, 383, 189);
		buyPanel.add(panelLotDetails);
		panelLotDetails.setLayout(null);
		
		lbInfLotId = new JLabel("LotID:");
		lbInfLotId.setBounds(10, 22, 150, 14);
		panelLotDetails.add(lbInfLotId);
		
		lbInfLotTitle = new JLabel("Lot title:");
		lbInfLotTitle.setBounds(10, 40, 178, 14);
		panelLotDetails.add(lbInfLotTitle);
		
		txtInfDesc = new JTextField();
		txtInfDesc.setText("Desc:");
		txtInfDesc.setBounds(10, 59, 178, 45);
		panelLotDetails.add(txtInfDesc);
		txtInfDesc.setColumns(10);
		
		lbInfPrice = new JLabel("Price:");
		lbInfPrice.setBounds(10, 115, 140, 14);
		panelLotDetails.add(lbInfPrice);
		
		lbInffExpires = new JLabel("Expires:");
		lbInffExpires.setBounds(10, 140, 140, 14);
		panelLotDetails.add(lbInffExpires);
		
		lblLots = new JLabel("Lots: 3");
		lblLots.setBounds(160, 11, 60, 14);
		add(lblLots);
		
		lblBids = new JLabel("Bids: 2");
		lblBids.setBounds(233, 11, 60, 14);
		add(lblBids);
		
		lblSold = new JLabel("Sold: 1");
		lblSold.setBounds(160, 24, 60, 14);
		add(lblSold);
		
		lblWon = new JLabel("Won: 0");
		lblWon.setBounds(233, 24, 60, 14);
		add(lblWon);
		
		
		
		
		addYourLots();
	}

	private void addYourLots() {

		
		yourLotsModel=new DefaultTableModel();
		tblYourLots= new JTable(yourLotsModel);
		
		
		yourLotsModel.addColumn("Lot");
		yourLotsModel.addColumn("Price");
		yourLotsModel.addColumn("Best Bid");
		
		
		
		panelYourLots.setLayout(new FlowLayout());
		panelYourLots.add(new JScrollPane(tblYourLots));
		
		
		
		
	}
	
	
}

class SellingPanel extends JPanel{
	
	
	
	
	
}
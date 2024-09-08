package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Reservation extends JFrame
{
	JLabel headingJLabel = new JLabel("Luxury Bus Services");
	JLabel scourceStationJLabel = new JLabel("Source Station :");
	JLabel destinationJLabel = new JLabel("Destination :");
	JLabel enterDateJLabel = new JLabel("Enter Date :");
	JLabel selectBusJLabel = new JLabel("Select Bus From List & Click Load :");
	
	JLabel busIdJLabel = new JLabel("Bus ID :");
	JLabel dataOfJourneyJLabel = new JLabel("D.O.Journey :");
	JLabel displayBusIdJLabel = new JLabel("");
	JLabel displaydataOfJourney = new JLabel("");
	
	JButton searchBusJButton = new JButton("Search Bus");
	JButton resetJButton = new JButton("Reset");
	JButton loadJButton = new JButton("Load");
	JButton backJButton = new JButton("Back");
	
	
	String sourceStations[] = {"JALGAON","NANDURBAR","DHULE","NASHIK"};
	JComboBox<String> sourceStationJComboBox = new JComboBox<String>(sourceStations);
	
	String destination [] = {"JALGAON","NANDURBAR","DHULE","NASHIK"};
	JComboBox<String> destinationJComboBox = new JComboBox<String>(destination);
	
	String dates [] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox<String> dateJComboBox = new JComboBox<String>(dates);
	
	String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox<String> monthJComboBox = new JComboBox<String>(months);
	
	String years [] = {"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"};
	JComboBox<String> yearJComboBox = new JComboBox<String>(years);
	
	JComboBox<String> displayBusesJComboBox = new JComboBox<String>();
	
	JPanel busSeatingArrangementJPanel = new JPanel();
	Border border =  BorderFactory.createLineBorder(Color.RED);
	ImageIcon imageIcon  = new ImageIcon("C:\\Users\\DIPTESH\\Desktop\\seatimage.png");
   
	JButton seat1 = new JButton(imageIcon);
	JButton seat2 = new JButton(imageIcon);
	JButton seat3 = new JButton(imageIcon);
	JButton seat4 = new JButton(imageIcon);
	JButton seat5 = new JButton(imageIcon);
	JButton seat6 = new JButton(imageIcon);
	JButton seat7 = new JButton(imageIcon);
	JButton seat8 = new JButton(imageIcon);
	JButton seat9 = new JButton(imageIcon);
	JButton seat10 = new JButton(imageIcon);
	JButton seat11 = new JButton(imageIcon);
	JButton seat12 = new JButton(imageIcon);
	JButton seat13 = new JButton(imageIcon);
	JButton seat14 = new JButton(imageIcon);
	JButton seat15 = new JButton(imageIcon);
	JButton seat16 = new JButton(imageIcon);
	JButton seat17 = new JButton(imageIcon);
	JButton seat18 = new JButton(imageIcon);
	JButton seat19 = new JButton(imageIcon);
	JButton seat20 = new JButton(imageIcon);
	JButton seat21 = new JButton(imageIcon);
	JButton seat22 = new JButton(imageIcon);
	JButton seat23 = new JButton(imageIcon);
	JButton seat24 = new JButton(imageIcon);
	JButton seat25 = new JButton(imageIcon);
	JButton seat26 = new JButton(imageIcon);
	JButton seat27 = new JButton(imageIcon);
	JButton seat28 = new JButton(imageIcon);
	JButton seat29 = new JButton(imageIcon);
	JButton seat30 = new JButton(imageIcon);
	
	long id;
	
	public Reservation()
	{
		setSize(1200, 800);
		setTitle("Travels Reservation System - Reservation Page");
		setLayout(null);
		setLocation(170, 15);
		
		add(headingJLabel);
		headingJLabel.setBounds(410, 2, 470, 42);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
	   
		add(scourceStationJLabel);
		scourceStationJLabel.setBounds(30, 80, 200, 20);
		scourceStationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(sourceStationJComboBox);
		sourceStationJComboBox.setBounds(230, 81, 250, 25);
		sourceStationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(destinationJLabel);
		destinationJLabel.setBounds(740, 80, 160, 20);
		destinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(destinationJComboBox);
		destinationJComboBox.setBounds(900, 81, 250, 25);
		destinationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(enterDateJLabel);
		enterDateJLabel.setBounds(110, 130, 150, 20);
		enterDateJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(dateJComboBox);
		dateJComboBox.setBounds(270, 131, 60, 25);
		dateJComboBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		add(monthJComboBox);
		monthJComboBox.setBounds(350, 131, 140, 25);
		monthJComboBox.setFont(new Font("Monospaced", Font.BOLD, 17));
		add(yearJComboBox);
		yearJComboBox.setBounds(510, 131, 100, 25);
		yearJComboBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(searchBusJButton);
		searchBusJButton.setBounds(680, 131, 200, 25);
		searchBusJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		searchBusJButton.setBackground(Color.BLACK);
		searchBusJButton.setForeground(Color.WHITE);
		
		add(resetJButton);
		resetJButton.setBounds(910, 131, 120, 25);
		resetJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		resetJButton.setBackground(Color.BLACK);
		resetJButton.setForeground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(20, 710, 150, 35);
		backJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);

		searchBusJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String source = (String)sourceStationJComboBox.getSelectedItem();
					String destination = (String)destinationJComboBox.getSelectedItem();
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BUSES where SOURCE=? and DESTINATION=?");
					
					ps.setString(1, source);
					ps.setString(2, destination);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) 
					{
						id = rs.getLong(1);
						String bName = rs.getString(2);
						String timing = rs.getString(7);
					    
						add(selectBusJLabel);
						selectBusJLabel.setBounds(30, 230, 430, 20);
						selectBusJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
						selectBusJLabel.setVisible(true);
						add(displayBusesJComboBox);
						displayBusesJComboBox.setBounds(460, 230, 450, 25);
						displayBusesJComboBox.setFont(new Font("Monospaced", Font.BOLD, 20));
						displayBusesJComboBox.addItem(id+"  "+bName+"  "+timing);
						displayBusesJComboBox.setVisible(true);
						
						add(loadJButton);
						loadJButton.setBounds(940, 230, 150, 25);
						loadJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
						loadJButton.setBackground(Color.BLACK);
						loadJButton.setForeground(Color.WHITE);
						loadJButton.setVisible(true);
						
						sourceStationJComboBox.setEnabled(false);
						destinationJComboBox.setEnabled(false);
						dateJComboBox.setEnabled(false);
						monthJComboBox.setEnabled(false);
						yearJComboBox.setEnabled(false);
						searchBusJButton.setEnabled(false);
					}
				} catch (Exception e2) 
				{
					e2.printStackTrace();
				}
			}
		});
		
		resetJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sourceStationJComboBox.setEnabled(true);
				destinationJComboBox.setEnabled(true);
				dateJComboBox.setEnabled(true);
				monthJComboBox.setEnabled(true);
				yearJComboBox.setEnabled(true);
				searchBusJButton.setEnabled(true);
				
				selectBusJLabel.setVisible(false);
				displayBusesJComboBox.setVisible(false);
				loadJButton.setVisible(false);
				busIdJLabel.setVisible(false);
				displayBusIdJLabel.setVisible(false);
				dataOfJourneyJLabel.setVisible(false);
				displaydataOfJourney.setVisible(false);
				busSeatingArrangementJPanel.setVisible(false);
				
				
			}
		});
		
		loadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String busIdString = (String)displayBusesJComboBox.getSelectedItem();
					long idofBus = Long.parseLong((String)busIdString.substring(0, 4));
					String dateOfJourney = (String)dateJComboBox.getSelectedItem();
					String monthOfJourney = (String)monthJComboBox.getSelectedItem();
					String yearOfJourney = (String)yearJComboBox.getSelectedItem();
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BUSES where ID=?");
					ps.setLong(1, idofBus);
					
				    ResultSet rs = ps.executeQuery();
				    
				    if(rs.next())
				    {
				    	long BusId = rs.getLong(1);
				    	displayBusIdJLabel.setText(""+BusId);
				    	
				    	displaydataOfJourney.setText(dateOfJourney+"/"+monthOfJourney+"/"+yearOfJourney);
				    	
				    	add(busSeatingArrangementJPanel);	
					    busSeatingArrangementJPanel.setBounds(550, 410,610, 270);
						busSeatingArrangementJPanel.setLayout(null);
						busSeatingArrangementJPanel.setBorder(border);
						busSeatingArrangementJPanel.setVisible(true);
						    
						busSeatingArrangementJPanel.add(seat1);
						seat1.setBounds(20, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat2);
						seat2.setBounds(78, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat3);
						seat3.setBounds(136, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat4);
						seat4.setBounds(194, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat5);
						seat5.setBounds(252, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat6);
						seat6.setBounds(310, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat7);
						seat7.setBounds(368, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat8);
						seat8.setBounds(426, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat9);
						seat9.setBounds(484, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat10);
						seat10.setBounds(542, 3, 50, 50);
						
						busSeatingArrangementJPanel.add(seat11);
						seat11.setBounds(20, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat12);
						seat12.setBounds(78, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat13);
						seat13.setBounds(136, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat14);
						seat14.setBounds(194, 70, 50,50);
						
						busSeatingArrangementJPanel.add(seat15);
						seat15.setBounds(252, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat16);
						seat16.setBounds(310, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat17);
						seat17.setBounds(368, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat18);
						seat18.setBounds(426, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat19);
						seat19.setBounds(484, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat20);
						seat20.setBounds(542, 70, 50, 50);
						
						busSeatingArrangementJPanel.add(seat21);
						seat21.setBounds(20, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat22);
						seat22.setBounds(78, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat23);
						seat23.setBounds(136, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat24);
						seat24.setBounds(194, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat25);
						seat25.setBounds(252, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat26);
						seat26.setBounds(310, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat27);
						seat27.setBounds(368, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat28);
						seat28.setBounds(426, 210, 50, 50);
						
						busSeatingArrangementJPanel.add(seat29);
						seat29.setBounds(484, 210, 50, 50);

						busSeatingArrangementJPanel.add(seat30); 
						seat30.setBounds(542, 210, 50, 50);
						
						add(busIdJLabel);
						busIdJLabel.setBounds(50, 400, 100, 20);
						busIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
						busIdJLabel.setVisible(true);
						add(displayBusIdJLabel);
						displayBusIdJLabel.setBounds(150, 400, 100, 20);
						displayBusIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
						displayBusIdJLabel.setVisible(true);
						
						add(dataOfJourneyJLabel);
						dataOfJourneyJLabel.setBounds(50, 450, 160, 25);
						dataOfJourneyJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
						dataOfJourneyJLabel.setVisible(true);
						add(displaydataOfJourney);
						displaydataOfJourney.setBounds(210, 450, 230, 23);
						displaydataOfJourney.setFont(new Font("Monospaced", Font.BOLD, 20));
						displaydataOfJourney.setVisible(true);
				    }
				}catch (Exception e1) {
			       e1.printStackTrace();
				}
				
				String seatNo;
				String busIdString = (String)displayBusesJComboBox.getSelectedItem();
				String idofBus =busIdString.substring(0, 4);
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps1 = con.prepareStatement("Select SEAT_NO from CUSTOMERS where BUS_ID=?");
					ps1.setString(1,idofBus);
					ResultSet rs = ps1.executeQuery();
					
					while(rs.next())
					{
						seatNo = rs.getString("SEAT_NO");
						if (seatNo.equals("1"))
						{
							seat1.setEnabled(false);
						}
						if (seatNo.equals("1"))
						{
							seat1.setEnabled(false);
						}
						if (seatNo.equals("2"))
						{
							seat2.setEnabled(false);
						}
						if (seatNo.equals("3"))
						{
							seat3.setEnabled(false);
						}
						if (seatNo.equals("4"))
						{
							seat4.setEnabled(false);
						}
						if (seatNo.equals("5"))
						{
							seat5.setEnabled(false);
						}
						if (seatNo.equals("6"))
						{
							seat6.setEnabled(false);
						}
						if (seatNo.equals("7"))
						{
							seat7.setEnabled(false);
						}
						if (seatNo.equals("8"))
						{
							seat8.setEnabled(false);
						}
						if (seatNo.equals("9"))
						{
							seat9.setEnabled(false);
						}
						if (seatNo.equals("10"))
						{
							seat10.setEnabled(false);
						}
						if (seatNo.equals("11"))
						{
							seat11.setEnabled(false);
						}
						if (seatNo.equals("12"))
						{
							seat12.setEnabled(false);
						}
						if (seatNo.equals("13"))
						{
							seat13.setEnabled(false);
						}
						if (seatNo.equals("14"))
						{
							seat14.setEnabled(false);
						}
						if (seatNo.equals("15"))
						{
							seat15.setEnabled(false);
						}
						if (seatNo.equals("16"))
						{
							seat16.setEnabled(false);
						}
						if (seatNo.equals("17"))
						{
							seat17.setEnabled(false);
						}
						if (seatNo.equals("18"))
						{
							seat18.setEnabled(false);
						}
						if (seatNo.equals("19"))
						{
							seat19.setEnabled(false);
						}
						if (seatNo.equals("20"))
						{
							seat20.setEnabled(false);
						}
						if (seatNo.equals("21"))
						{
							seat21.setEnabled(false);
						}
						if (seatNo.equals("22"))
						{
							seat22.setEnabled(false);
						}
						if (seatNo.equals("23"))
						{
							seat23.setEnabled(false);
						}
						if (seatNo.equals("24"))
						{
							seat24.setEnabled(false);
						}
						if (seatNo.equals("25"))
						{
							seat25.setEnabled(false);
						}
						if (seatNo.equals("26"))
						{
							seat26.setEnabled(false);
						}
						if (seatNo.equals("27"))
						{
							seat27.setEnabled(false);
						}
						if (seatNo.equals("28"))
						{
							seat28.setEnabled(false);
						}
						if (seatNo.equals("29"))
						{
							seat29.setEnabled(false);
						}
						if (seatNo.equals("30"))
						{
							seat30.setEnabled(false);
						}
						
						
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		
		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		//store all values of this JFrame
	     
		seat1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "1";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
		
			}
		});
		
		seat2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "2";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
		
			}
		});		
		
		seat3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "3";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
		
			}
		});
		
		seat4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "4";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
		
			}
		});
		
		seat5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "5";
				
			    Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
		
			}
		});
		
		seat6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "6";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "7";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "8";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "9";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "10";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "11";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "12";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "13";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "14";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "15";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "16";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "17";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "18";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat19.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "19";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "20";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "21";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "22";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "23";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat24.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "24";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat25.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "25";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat26.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "26";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat27.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "27";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat28.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "28";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat29.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "29";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
		
		seat30.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sourceString = (String)sourceStationJComboBox.getSelectedItem();
				String destinationString = (String)destinationJComboBox.getSelectedItem();
				String dateOfJourneyString = (String)dateJComboBox.getSelectedItem();
				String monthOfJourneyString = (String)monthJComboBox.getSelectedItem();
				String yearOfJourneyString = (String)yearJComboBox.getSelectedItem();
				String busIdString = displayBusIdJLabel.getText();
				String seatNoString = "30";
				
				Reservation2.passingValues(sourceString,destinationString,dateOfJourneyString,monthOfJourneyString,yearOfJourneyString,busIdString,seatNoString);
				
				new Reservation2().setVisible(true);
				setVisible(false);
			}
		});
	}
	public static void main(String[] args) 
	{
		Reservation reservation = new Reservation();
		reservation.setVisible(true);
		reservation.setResizable(false);
	}
}

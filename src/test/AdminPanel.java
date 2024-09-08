package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class AdminPanel extends JFrame
{
	JLabel headingJLabel = new JLabel("Luxury Bus Services");
	JLabel userNameJLabel = new JLabel("UserName :");
	JLabel passwordJLabel = new JLabel("Password :");
	
	JTextField userNameJTextField = new JTextField();
	JPasswordField passwordJPasswordField = new JPasswordField();
	
	JButton loginJButton = new JButton("Login");
	JButton addbusJButton = new JButton("Add Bus");
	JButton deletebusJButton = new JButton("Delete Bus");
	JButton viewBusJButton = new JButton("View Bus");
	JButton updatebusInfoJButton = new JButton("Update Bus Info");
	
	JPanel addBusJPanel = new JPanel();
	JPanel deleteBusJPanel = new JPanel();
	JPanel viewBusJPanel = new JPanel();
	JPanel updateBusJPanel = new JPanel();
	
	JButton backJButton = new JButton("Back");
	
	//addBusComponents
	JLabel addHeadingJLabel = new JLabel("ADD TRAVELS");
	JLabel idJLabel = new JLabel("Bus ID :");
	JLabel displayIdJLabel = new JLabel("");
	JLabel busnameJLabel = new JLabel("Bus Name :");
	JLabel sourceJLabel = new JLabel("Source :");
	JLabel destinationJLabel = new JLabel("Destination :");
	JLabel distanceJLabel = new JLabel("Distance :");
	JLabel chargesJLabel = new JLabel("Charges :");
	JLabel busTimingJLabel = new JLabel("Bus Timing :");
	JLabel seatsJLabel = new JLabel("No Of Seats :");
	
	JTextField busnameJTextField = new JTextField();
	String sourceStations[] = {"JALGAON","NANDURBAR","DHULE","NASHIK"};
	JComboBox<String> sourceStationJComboBox = new JComboBox<String>(sourceStations);
	
	String destination [] = {"JALGAON","NANDURBAR","DHULE","NASHIK"};
	JComboBox<String> destinationJComboBox = new JComboBox<String>(destination);
	JTextField distanceJTextField = new JTextField();
	JTextField chargesJTextField = new JTextField();
	JTextField busTImingJTextField = new JTextField();
	JTextField seatsJTextField = new JTextField();
	
	JButton generateIdJButton = new JButton("Generate");
	JButton addJButton = new JButton("Add");
	
	//ViewBusComponent
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	JScrollPane scrollPane = new JScrollPane(table);
    String ColumnNames[] = {"ID","BUS NAME","SOURCE","DESTINATION","DISTANCE","CHARGES","BUS TIMING","SEATS"};
    long id = 0;
    String busNameString = "";
    String sourceString = "";
    String destinationString = "";
    long distance = 0;
    float charges = 0;
    String timingString = "";
    long seats = 0;
    
    //DeleteBusComponents
    JLabel deleteHeadingJLabel = new JLabel("DELETE TRAVEL");
    JButton searchForDeleteJButton = new JButton("SEARCH");
    
    JLabel enterDeleteIdJLabel = new JLabel("Bus ID :");
    JLabel deleteBusNameJLabel = new JLabel("Bus Name :");
    JLabel deleteSourceJLabel = new JLabel("Source :");
    JLabel deleteDestinationJLabel = new JLabel("Destination");
    JLabel deleteDistanceJLabel = new JLabel("Distance :");
    JLabel deleteChargesJLabel = new JLabel("Charges :");
    JLabel deleteBusTimingJLabel = new JLabel("Bus Timing :");
    JLabel deleteNoOfSeatsJLabel = new JLabel("No of Seats :");
    
    JTextField enterDeleteIdJTextField = new JTextField();
    JTextField deleteBusNameJTextField = new JTextField();
    JTextField deleteSourceJTextField = new JTextField();
    JTextField delteDestinationJTextField = new JTextField();
    JTextField deleteDistanceJTextField = new JTextField();
    JTextField deleteChargesJTextField = new JTextField();
    JTextField deleteBusTimingJTextField = new JTextField();
    JTextField deleteNoOfSeatsJTextField = new JTextField();
    
    JButton deleteButton = new JButton("Delete");
    
    //update Bus Component 
    JLabel updateHeadingJLabel = new JLabel("UPDATE TRAVEL");
    JLabel enterUpdateBusIdJLabel = new JLabel("Enter Bus ID :");
    JTextField enterUpdateBusIdJTextField = new JTextField();
    JButton searchBusJButton = new JButton("SEARCH");
    
    JLabel separatorJLabel = new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");
    
    JLabel updatebusnameJLabel = new JLabel("Bus Name :");
	JLabel updatesourceJLabel = new JLabel("Source :");
	JLabel updatedestinationJLabel = new JLabel("Destination :");
	JLabel updatedistanceJLabel = new JLabel("Distance :");
	JLabel updatechargesJLabel = new JLabel("Charges :");
	JLabel updatebusTimingJLabel = new JLabel("Bus Timing :");
	JLabel updateseatsJLabel = new JLabel("No Of Seats :");

	JTextField updateBusNameJTextField = new JTextField();
	JComboBox<String> updateSourceStationJComboBox = new JComboBox<String>(sourceStations);
	JComboBox<String> updateDestinationJComboBox = new JComboBox<String>(destination);
	JTextField updatedistanceJTextField = new JTextField();
	JTextField updatechargesJTextField = new JTextField();
	JTextField updatebusTImingJTextField = new JTextField();
	JTextField updateseatsJTextField = new JTextField();
	
	JButton updateJButton = new JButton("UPDATE");
	
	public AdminPanel()
	{
		setSize(1200, 800);
		setTitle("Travels Reservation System - Admin Panel");
		setLayout(null);
		
		add(headingJLabel);
		headingJLabel.setBounds(375, 5, 450, 40);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 38));
		
		add(userNameJLabel);
		userNameJLabel.setBounds(50, 80, 140, 20);
		userNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(userNameJTextField);
		userNameJTextField.setBounds(190, 80, 250, 25);
		userNameJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
		
		add(passwordJLabel);
		passwordJLabel.setBounds(500, 80, 120, 20);
		passwordJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(passwordJPasswordField);
		passwordJPasswordField.setBounds(630, 80, 250, 25);
		passwordJPasswordField.setFont(new Font("Monospaced", Font.BOLD, 23));
		passwordJPasswordField.setEchoChar('X');
		
		add(loginJButton);
		loginJButton.setBounds(920, 80, 200, 30);
		loginJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		loginJButton.setBackground(Color.BLACK);
		loginJButton.setForeground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(10, 720, 200, 35);
		backJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);		
		
		//Sample Code for Measurement
		

	 // Sample Code ends Here
	    
		
		loginJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String userId = userNameJTextField.getText();
					String password = passwordJPasswordField.getText();
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from ADMINLOGIN where USER_ID=? and PASSWORD=?");
					ps.setString(1,userId);
					ps.setString(2,password);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next())
					{
						add(addbusJButton);
						addbusJButton.setBounds(1, 130, 295, 35);
						addbusJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
						addbusJButton.setBackground(Color.BLACK);
						addbusJButton.setForeground(Color.WHITE);
						add(deletebusJButton);
						deletebusJButton.setBounds(296, 130, 298, 35);
						deletebusJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
						deletebusJButton.setBackground(Color.BLACK);
						deletebusJButton.setForeground(Color.WHITE);
						add(viewBusJButton);
						viewBusJButton.setBounds(595, 130, 299, 35);
						viewBusJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
						viewBusJButton.setBackground(Color.BLACK);
						viewBusJButton.setForeground(Color.WHITE);
						add(updatebusInfoJButton);
						updatebusInfoJButton.setBounds(895, 130, 290, 35);
						updatebusInfoJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
						updatebusInfoJButton.setBackground(Color.BLACK);
						updatebusInfoJButton.setForeground(Color.WHITE);
						   
					} else {
						JOptionPane.showMessageDialog(AdminPanel.this, "Incorrect UserId and Password");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		generateIdJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rdm  = new Random();
				long ID = (rdm.nextLong() % 9000L) + 1000L;
				long generatedID = Math.abs(ID);
				
				displayIdJLabel.setText(""+generatedID);
				generateIdJButton.setText("Generated");
				generateIdJButton.setEnabled(false);
			}
		});
		
		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		addbusJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deleteBusJPanel.setVisible(false);
				viewBusJPanel.setVisible(false);
				updateBusJPanel.setVisible(false);
				
				add(addBusJPanel);
				addBusJPanel.setBounds(5, 175, 1175, 530);
				addBusJPanel.setBackground(Color.DARK_GRAY);
				addBusJPanel.setVisible(true);
				addBusJPanel.setLayout(null);
				
				addBusJPanel.add(addHeadingJLabel);
				addHeadingJLabel.setBounds(470, 2, 280, 32);
				addHeadingJLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
				addHeadingJLabel.setForeground(Color.WHITE);
				
				addBusJPanel.add(idJLabel);
				idJLabel.setBounds(250, 50, 200, 25);
				idJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				idJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(displayIdJLabel);
				displayIdJLabel.setBounds(460, 50, 350, 25);
				displayIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				displayIdJLabel.setOpaque(true);
				displayIdJLabel.setBackground(Color.WHITE);
				addBusJPanel.add(generateIdJButton);
				generateIdJButton.setBounds(820, 50, 200, 25);
				generateIdJButton.setFont(new Font("Monospaced", Font.BOLD, 21));
				generateIdJButton.setBackground(Color.GRAY);
				
				addBusJPanel.add(busnameJLabel);
				busnameJLabel.setBounds(250, 100, 200, 25);
				busnameJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				busnameJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(busnameJTextField);
				busnameJTextField.setBounds(460, 100, 350, 25);
				busnameJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(sourceJLabel);
				sourceJLabel.setBounds(250, 150, 200, 25);
				sourceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				sourceJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(sourceStationJComboBox);
				sourceStationJComboBox.setBounds(460, 150, 350, 25);
				sourceStationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(destinationJLabel);
				destinationJLabel.setBounds(250, 200, 200, 25);
				destinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				destinationJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(destinationJComboBox);
				destinationJComboBox.setBounds(460, 200, 350, 25);
				destinationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(distanceJLabel);
				distanceJLabel.setBounds(250, 250, 200, 25);
				distanceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				distanceJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(distanceJTextField);
				distanceJTextField.setBounds(460, 250, 350, 25);
				distanceJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(chargesJLabel);
				chargesJLabel.setBounds(250, 300, 200, 25);
				chargesJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				chargesJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(chargesJTextField);
				chargesJTextField.setBounds(460, 300, 350, 25);
				chargesJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(busTimingJLabel);
				busTimingJLabel.setBounds(250, 350, 200, 25);
				busTimingJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				busTimingJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(busTImingJTextField);
				busTImingJTextField.setBounds(460, 350, 350, 25);
				busTImingJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(seatsJLabel);
				seatsJLabel.setBounds(250, 400, 200, 25);
				seatsJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				seatsJLabel.setForeground(Color.WHITE);
				addBusJPanel.add(seatsJTextField);
				seatsJTextField.setBounds(460, 400, 350, 25);
				seatsJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				addBusJPanel.add(addJButton);
				addJButton.setBounds(460, 450, 350, 35);
				addJButton.setFont(new Font("Monospaced", Font.BOLD, 25));
				addJButton.setBackground(Color.GRAY);
				
			}
		});
		
		deletebusJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addBusJPanel.setVisible(false);
			    viewBusJPanel.setVisible(false);
			    updateBusJPanel.setVisible(false);
			    
			    add(deleteBusJPanel);
			    deleteBusJPanel.setBounds(5, 175, 1175, 530);
			    deleteBusJPanel.setBackground(Color.darkGray);
			    deleteBusJPanel.setLayout(null);
			    deleteBusJPanel.setVisible(true);
			    
			    deleteBusJPanel.add(enterDeleteIdJLabel);
				enterDeleteIdJLabel.setBounds(100, 50, 200, 25);
				enterDeleteIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				enterDeleteIdJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(enterDeleteIdJTextField);
				enterDeleteIdJTextField.setBounds(310, 50, 300, 25);
				enterDeleteIdJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteBusJPanel.add(searchForDeleteJButton);
				searchForDeleteJButton.setBounds(650, 50, 250, 25);
				searchForDeleteJButton.setFont(new Font("Monospaced", Font.BOLD, 21));
				searchForDeleteJButton.setBackground(Color.GRAY);
				searchForDeleteJButton.setForeground(Color.WHITE);
				
				deleteBusJPanel.add(deleteHeadingJLabel);
				deleteHeadingJLabel.setBounds(430, 2, 320, 32);
				deleteHeadingJLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
				deleteHeadingJLabel.setForeground(Color.WHITE);
				
				deleteBusJPanel.add(separatorJLabel);
				separatorJLabel.setBounds(0, 77, 1175, 17);
				separatorJLabel.setForeground(Color.WHITE);
				
				deleteBusJPanel.add(deleteBusNameJLabel);
				deleteBusNameJLabel.setBounds(250, 120, 200, 25);
				deleteBusNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteBusNameJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteBusNameJTextField);
				deleteBusNameJTextField.setBounds(460, 120, 350, 25);
				deleteBusNameJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteSourceJLabel);
				deleteSourceJLabel.setBounds(250, 170, 200, 25);
				deleteSourceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteSourceJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteSourceJTextField);
				deleteSourceJTextField.setBounds(460, 170, 350, 25);
				deleteSourceJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteDestinationJLabel);
				deleteDestinationJLabel.setBounds(250, 220, 200, 25);
				deleteDestinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteDestinationJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(delteDestinationJTextField);
				delteDestinationJTextField.setBounds(460, 220, 350, 25);
				delteDestinationJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteDistanceJLabel);
				deleteDistanceJLabel.setBounds(250, 270, 200, 25);
				deleteDistanceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteDistanceJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteDistanceJTextField);
				deleteDistanceJTextField.setBounds(460, 270, 350, 25);
				deleteDistanceJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteChargesJLabel);
				deleteChargesJLabel.setBounds(250, 320, 200, 25);
				deleteChargesJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteChargesJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteChargesJTextField);
				deleteChargesJTextField.setBounds(460, 320, 350, 25);
				deleteChargesJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteBusTimingJLabel);
				deleteBusTimingJLabel.setBounds(250, 370, 200, 25);
				deleteBusTimingJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteBusTimingJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteBusTimingJTextField);
				deleteBusTimingJTextField.setBounds(460, 370, 350, 25);
				deleteBusTimingJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteNoOfSeatsJLabel);
				deleteNoOfSeatsJLabel.setBounds(250, 420, 200, 25);
				deleteNoOfSeatsJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteNoOfSeatsJLabel.setForeground(Color.WHITE);
				deleteBusJPanel.add(deleteNoOfSeatsJTextField);
				deleteNoOfSeatsJTextField.setBounds(460, 420, 350, 25);
				deleteNoOfSeatsJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				deleteBusJPanel.add(deleteButton);
				deleteButton.setBounds(460, 470, 350, 35);
				deleteButton.setFont(new Font("Monospaced", Font.BOLD, 23));
				deleteButton.setBackground(Color.GRAY);
				deleteButton.setForeground(Color.WHITE);
			}
		});
		
		viewBusJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addBusJPanel.setVisible(false);
				deleteBusJPanel.setVisible(false);
				updateBusJPanel.setVisible(false);
				
				add(viewBusJPanel);
				viewBusJPanel.setBounds(5, 175, 1175, 530);
				viewBusJPanel.setBackground(Color.DARK_GRAY);
				viewBusJPanel.setVisible(true);
				viewBusJPanel.setLayout(null);
				
				 DefaultTableModel dtm = new DefaultTableModel();
				  dtm.setColumnIdentifiers(ColumnNames);
				  JTable table = new JTable(dtm);
				  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				  table.setBackground(Color.DARK_GRAY);
				  table.setForeground(Color.WHITE);
				  table.setRowHeight(30);
				  table.setFont(new Font("Arial", Font.BOLD, 15));
				  table.setFillsViewportHeight(true); 
				  JScrollPane scrollPane = new JScrollPane(table); 
			   	  viewBusJPanel.add(scrollPane); 
				  scrollPane.setBounds(1,1, 1174, 529);
				  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				  
				  try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BUSES");
					
					ResultSet rs = ps.executeQuery();
					while (rs.next()) 
					{
						id = rs.getLong(1);
						busNameString = rs.getString(2);
						sourceString = rs.getString(3);
						destinationString = rs.getString(4);
						distance = rs.getLong(5);
						charges = rs.getFloat(6);
						timingString = rs.getString(7);
						seats = rs.getLong(8);
						
						Object [] rows = {id,busNameString,sourceString,destinationString,distance,charges,timingString,seats};
						dtm.addRow(rows);
					} 	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		 
			}
		});
		
		updatebusInfoJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addBusJPanel.setVisible(false);
				deleteBusJPanel.setVisible(false);
				viewBusJPanel.setVisible(false);
				
				add(updateBusJPanel);
				updateBusJPanel.setBounds(5, 175, 1175, 530);
				updateBusJPanel.setBackground(Color.DARK_GRAY);
				updateBusJPanel.setVisible(true);
				updateBusJPanel.setLayout(null);
				
				updateBusJPanel.add(enterUpdateBusIdJLabel);
				enterUpdateBusIdJLabel.setBounds(100, 50, 200, 25);
				enterUpdateBusIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				enterUpdateBusIdJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(enterUpdateBusIdJTextField);
				enterUpdateBusIdJTextField.setBounds(310, 50, 300, 25);
				enterUpdateBusIdJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				updateBusJPanel.add(searchBusJButton);
				searchBusJButton.setBounds(650, 50, 250, 25);
				searchBusJButton.setFont(new Font("Monospaced", Font.BOLD, 21));
				searchBusJButton.setBackground(Color.GRAY);
				searchBusJButton.setForeground(Color.WHITE);
				
				updateBusJPanel.add(updateHeadingJLabel);
				updateHeadingJLabel.setBounds(430, 2, 320, 32);
				updateHeadingJLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
				updateHeadingJLabel.setForeground(Color.WHITE);
				
				updateBusJPanel.add(separatorJLabel);
				separatorJLabel.setBounds(0, 77, 1175, 17);
				separatorJLabel.setForeground(Color.WHITE);
				
				updateBusJPanel.add(updatebusnameJLabel);
				updatebusnameJLabel.setBounds(250, 120, 200, 25);
				updatebusnameJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatebusnameJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updateBusNameJTextField);
				updateBusNameJTextField.setBounds(460, 120, 350, 25);
				updateBusNameJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updatesourceJLabel);
				updatesourceJLabel.setBounds(250, 170, 200, 25);
				updatesourceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatesourceJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updateSourceStationJComboBox);
				updateSourceStationJComboBox.setBounds(460, 170, 350, 25);
				updateSourceStationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updatedestinationJLabel);
				updatedestinationJLabel.setBounds(250, 220, 200, 25);
				updatedestinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatedestinationJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updateDestinationJComboBox);
				updateDestinationJComboBox.setBounds(460, 220, 350, 25);
				updateDestinationJComboBox.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updatedistanceJLabel);
				updatedistanceJLabel.setBounds(250, 270, 200, 25);
				updatedistanceJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatedistanceJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updatedistanceJTextField);
				updatedistanceJTextField.setBounds(460, 270, 350, 25);
				updatedistanceJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updatechargesJLabel);
				updatechargesJLabel.setBounds(250, 320, 200, 25);
				updatechargesJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatechargesJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updatechargesJTextField);
				updatechargesJTextField.setBounds(460, 320, 350, 25);
				updatechargesJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updatebusTimingJLabel);
				updatebusTimingJLabel.setBounds(250, 370, 200, 25);
				updatebusTimingJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updatebusTimingJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updatebusTImingJTextField);
				updatebusTImingJTextField.setBounds(460, 370, 350, 25);
				updatebusTImingJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updateseatsJLabel);
				updateseatsJLabel.setBounds(250, 420, 200, 25);
				updateseatsJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
				updateseatsJLabel.setForeground(Color.WHITE);
				updateBusJPanel.add(updateseatsJTextField);
				updateseatsJTextField.setBounds(460, 420, 350, 25);
				updateseatsJTextField.setFont(new Font("Monospaced", Font.BOLD, 23));
				
				updateBusJPanel.add(updateJButton);
				updateJButton.setBounds(460, 470, 350, 35);
				updateJButton.setFont(new Font("Monospaced", Font.BOLD, 23));
				updateJButton.setBackground(Color.GRAY);
				updateJButton.setForeground(Color.WHITE);

				
			}
		});
		
		addJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (generateIdJButton.getText().equals("Generated"))
				{
					try
					  {
						long id = Long.parseLong(displayIdJLabel.getText());
						String busName = busnameJTextField.getText();
						String source = sourceStationJComboBox.getSelectedItem().toString();
						String destination = destinationJComboBox.getSelectedItem().toString();
						long distance = Long.parseLong(distanceJTextField.getText());
						float charges = Float.parseFloat(chargesJTextField.getText());
						String busTiming = (String)busTImingJTextField.getText();
						long seats = Long.parseLong(seatsJTextField.getText());
						
						Connection con = DBConnection.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO BUSES VALUES(?,?,?,?,?,?,?,?)");
						
						ps.setLong(1, id);
						ps.setString(2, busName);
						ps.setString(3, source);
						ps.setString(4, destination);
						ps.setLong(5, distance);
						ps.setFloat(6, charges);
						ps.setString(7, busTiming);
						ps.setLong(8, seats);
						
						int i = ps.executeUpdate();
						
						if (i==1)
						{
							JOptionPane.showMessageDialog(AdminPanel.this, "Bus added Successfully");
						} else {
							JOptionPane.showMessageDialog(AdminPanel.this, "Someting went wrong"+"\nUnable to add the Bus");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(AdminPanel.this, "First click on generate button"+"\n Generate the Id of Bus");
				}
			}
		});
		
		searchBusJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int enteredID = Integer.parseInt(enterUpdateBusIdJTextField.getText());
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BUSES where ID=?");
					ps.setInt(1, enteredID);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						updateBusNameJTextField.setText(rs.getString("BUS_NAME"));
						updatedistanceJTextField.setText(rs.getString("DISTANCE"));
						updatechargesJTextField.setText(rs.getString("CHARGES"));
						updatebusTImingJTextField.setText(rs.getString("BUS_TIMING"));
						updateseatsJTextField.setText(Integer.toString(rs.getInt("SEATS")));
					}else {
						JOptionPane.showMessageDialog(AdminPanel.this, "Please enter valid bus Id");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		searchForDeleteJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int enteredID = Integer.parseInt(enterDeleteIdJTextField.getText());
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BUSES where ID=?");
					ps.setInt(1, enteredID);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						deleteBusNameJTextField.setText(rs.getString("BUS_NAME"));
						deleteSourceJTextField.setText(rs.getString("SOURCE"));
						delteDestinationJTextField.setText(rs.getString("DESTINATION"));
						deleteDistanceJTextField.setText(rs.getString("DISTANCE"));
						deleteChargesJTextField.setText(rs.getString("CHARGES"));
						deleteBusTimingJTextField.setText(rs.getString("BUS_TIMING"));
						deleteNoOfSeatsJTextField.setText(Integer.toString(rs.getInt("SEATS")));
					}else {
						JOptionPane.showMessageDialog(AdminPanel.this, "Please enter valid bus Id");
					}	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		updateJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String bid = enterUpdateBusIdJTextField.getText().toString();
				String bname = updateBusNameJTextField.getText().toString();
				String source = updateSourceStationJComboBox.getSelectedItem().toString();
				String destination = updateDestinationJComboBox.getSelectedItem().toString();
				int distance = Integer.parseInt(updatedistanceJTextField.getText());
				float charges = Float.parseFloat(updatechargesJTextField.getText());
				String busTiming = updatebusTImingJTextField.getText().toString();
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Update BUSES SET BUS_NAME=? , SOURCE=? , DESTINATION=? , DISTANCE=? , CHARGES=? , BUS_TIMING=? WHERE ID=?");
					ps.setString(1, bname);
					ps.setString(2, source);
					ps.setString(3, destination);
					ps.setInt(4, distance);
					ps.setFloat(5, charges);
					ps.setString(6, busTiming);
					ps.setString(7, bid);
					
					int i = ps.executeUpdate();
					if (i==1)
					{
						JOptionPane.showMessageDialog(AdminPanel.this, "Travels updated successfully");
					} else {
						JOptionPane.showMessageDialog(AdminPanel.this, "Unable to update the travels");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int enteredID = Integer.parseInt(enterDeleteIdJTextField.getText());
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Delete from BUSES where ID=?");
					ps.setInt(1, enteredID);
					int i = ps.executeUpdate();
					
					if (i==1) 
					{
						JOptionPane.showMessageDialog(AdminPanel.this, "Travel Deleted Successfully");
					} else {
						JOptionPane.showMessageDialog(AdminPanel.this, "Unable to delete the Travel");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
	public static void main(String[] args)
	{
		AdminPanel adminPanel = new AdminPanel();
		adminPanel.setVisible(true);
		adminPanel.setResizable(false);
	}
}

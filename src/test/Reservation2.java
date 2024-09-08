package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Reservation2 extends JFrame
{
    JLabel headingJLabel = new JLabel("Luxury Bus Services");
    JLabel dateofJourneyJLabel = new JLabel("D.O.Journey :");
    JLabel busIdJLabel = new JLabel("Bus ID :");
    JLabel sourceStationJLabel = new JLabel("Source Station :");
    JLabel destinationStationJLabel = new JLabel("Destination :");
    JLabel seatNoJLabel = new JLabel("Seat NO :");
    JLabel passengerJLabel = new JLabel("Passenger :");
    JLabel passengerNameJLabel = new JLabel("Name :");
    JLabel passengerMobileNoJLabel = new JLabel("Mobile No :");
    JLabel userIdJLabel = new JLabel("User ID :");
    
    static JLabel displayDateOfJourneyJLabel = new JLabel("");
    static JLabel displayBusIdJLabel = new JLabel("");
    static JLabel displaysourceStationJLabel = new JLabel("");
    static JLabel displaydestinationJLabel = new JLabel("");
    static JLabel displaySeatNoJLabel = new JLabel("");
    
    JTextField passengerNameJTextField = new JTextField();
    JTextField passengerMobileJTextField = new JTextField();
    JTextField passengerUserIdJTextField = new JTextField();
    
    JButton submitJButton = new JButton("Submit");
    JButton cancelJButton = new JButton("Back");
    
	public Reservation2()
	{
	  setSize(1100, 650);
	  setLayout(null);
	  setLocation(220, 70);
	  
	  add(headingJLabel);
	  headingJLabel.setBounds(340, 10, 470, 43);
	  headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
	  
	  add(dateofJourneyJLabel);
	  dateofJourneyJLabel.setBounds(50, 100, 170, 23);
	  dateofJourneyJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(displayDateOfJourneyJLabel);
	  displayDateOfJourneyJLabel.setBounds(210, 100, 250, 23);
	  displayDateOfJourneyJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	 
	  add(busIdJLabel);
	  busIdJLabel.setBounds(50, 150, 100, 20);
	  busIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(displayBusIdJLabel);
	  displayBusIdJLabel.setBounds(160, 150, 250, 20);
	  displayBusIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(sourceStationJLabel);
	  sourceStationJLabel.setBounds(50, 200, 220, 20);
	  sourceStationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(displaysourceStationJLabel);
	  displaysourceStationJLabel.setBounds(250, 200, 250, 20);
	  displaysourceStationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(destinationStationJLabel);
	  destinationStationJLabel.setBounds(50, 250, 170, 20);
	  destinationStationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(displaydestinationJLabel);
	  displaydestinationJLabel.setBounds(210, 250, 250, 20);
	  displaydestinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(seatNoJLabel);
	  seatNoJLabel.setBounds(50, 300, 110, 20);
	  seatNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(displaySeatNoJLabel);
	  displaySeatNoJLabel.setBounds(170, 300, 100, 20);
	  displaySeatNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(passengerJLabel);
	  passengerJLabel.setBounds(30, 350, 160, 24);
	  passengerJLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
	  
	  add(passengerNameJLabel);
	  passengerNameJLabel.setBounds(50, 400, 120, 20);
	  passengerNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(passengerNameJTextField);
	  passengerNameJTextField.setBounds(180, 400, 300, 25);
	  passengerNameJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	  add(passengerMobileNoJLabel);
	  passengerMobileNoJLabel.setBounds(550, 400, 150, 20);
	  passengerMobileNoJLabel.setFont(new Font("Monospaced",  Font.BOLD, 20));
	  add(passengerMobileJTextField);
	  passengerMobileJTextField.setBounds(710, 400, 300, 25);
	  passengerMobileJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(userIdJLabel);
	  userIdJLabel.setBounds(50, 450, 120, 20);
	  userIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	  add(passengerUserIdJTextField);
	  passengerUserIdJTextField.setBounds(180, 450, 300, 25);
	  passengerUserIdJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	  
	  add(submitJButton);
	  submitJButton.setBounds(750, 550, 200, 35);
	  submitJButton.setFont(new  Font("Monospaced", Font.BOLD, 20));
	  submitJButton.setBackground(Color.BLACK);
	  submitJButton.setForeground(Color.WHITE);
	  
	  add(cancelJButton);
	  cancelJButton.setBounds(150, 550, 200, 35);
	  cancelJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
	  cancelJButton.setBackground(Color.BLACK);
	  cancelJButton.setForeground(Color.WHITE);
	  
	  submitJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String userIdString = passengerUserIdJTextField.getText();
				long id = Long.parseLong(displayBusIdJLabel.getText());
				
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Select * from Registration where USER_ID=?");
				PreparedStatement ps2 = con.prepareStatement("Select * from BUSES where ID=?");
				ps.setString(1, userIdString);
				
				ResultSet rs = ps.executeQuery();
				if (rs.next())
				{
					ps2.setLong(1, id);
					
					ResultSet rs2 = ps2.executeQuery();
					if (rs2.next())
					{
						String timingString  = rs2.getString(7);
						float charges = rs2.getFloat(6);
						long distance = rs2.getLong(5);
						String dateofJourney = displayDateOfJourneyJLabel.getText();
						long busId = Long.parseLong(displayBusIdJLabel.getText());
						String source = displaysourceStationJLabel.getText();
						String destination = displaydestinationJLabel.getText();
						int seatNo = Integer.parseInt(displaySeatNoJLabel.getText());
						String cname = passengerNameJTextField.getText();
						long mobile = Long.parseLong(passengerMobileJTextField.getText());
						
						Reservation3.passingValuestoThird(source,destination,dateofJourney,timingString,distance,charges,busId,seatNo,cname,mobile);
						
						new Reservation3().setVisible(true);
						setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(Reservation2.this, "Something went wrong "+"\n Unable to access timing and charges of Bus");
					}
				} else {
					JOptionPane.showMessageDialog(Reservation2.this, "Invalid User Id "+"\n Please enter correct UserId");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	});
	  
	  cancelJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Reservation().setVisible(true);
			setVisible(false);
		}
	});
	  
	}
	public static void main(String[] args)
	{
		Reservation2 reservation2 = new Reservation2();
		reservation2.setVisible(true);
		reservation2.setResizable(false);
	}

     boolean status = false;
	public static int passingValues(String sourceString, String destinationString, String dateOfJourneyString,
			String monthOfJourneyString, String yearOfJourneyString, String busIdString, String seatNoString) 
	{
		try {
			 displayDateOfJourneyJLabel.setText(dateOfJourneyString+"/"+monthOfJourneyString+"/"+yearOfJourneyString);
			 displayBusIdJLabel.setText(busIdString);
			 displaysourceStationJLabel.setText(sourceString);
			 displaydestinationJLabel.setText(destinationString);
			 displaySeatNoJLabel.setText(seatNoString);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

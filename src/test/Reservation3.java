package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Reservation3 extends JFrame
{
	static Random rdm = new Random();
 	static long first8 = (rdm.nextLong() % 9000000000000L) + 0000000000000L;
	static long bigPin = Math.abs(first8);
	
	JLabel headingJLabel = new JLabel("Luxury Bus Services");
	JLabel borderJLabel = new JLabel("________________________________________________________________________________________________________");
	JLabel lastBorderJLabel = new JLabel("_________________________________________________________________________________________________________");
	JLabel pnrNoJLabel = new JLabel("PNR Number");
	JLabel sourceJLabel = new JLabel("Source Station");
	JLabel destinationJLabel = new JLabel("Destination");
	JLabel dateofJourneyJLabel = new JLabel("Date Of Journey");
	JLabel busTimingJLabel = new JLabel("Bus Timing");
	JLabel totalDistanceinKmJLabel =new JLabel("Total Distance In KM");
	JLabel totalCostOfTicketJLabel = new JLabel("Total Cost Of Ticket");
	JLabel busIdJLabel = new JLabel("Bus ID");
	
	JLabel passengerINformatoinJLabel = new JLabel("Passenger(s) Information");
	
	JLabel seatNumberJLabel = new JLabel("Seat Number");
	JLabel passengerNameJLabel = new JLabel("Passenger Name");
	JLabel mobileNoJLabel  = new JLabel("Mobile Number");
	
	static JLabel displayPnrNoJLabel = new JLabel("");
	static JLabel displaySourceJLabel = new JLabel("");
	static JLabel displaydestinationJLabel = new JLabel("");
	static JLabel displayDateOfJourneyJLabel = new JLabel("");
	static JLabel displayBusTimingJLabel = new JLabel("");
	static JLabel displayTotalDistanceInKmJLabel = new JLabel("");
	static JLabel displayTotalCostOfTicketJLabel = new JLabel("");
	static JLabel displayBusIdJLabel = new JLabel("");
	static JLabel displayseatNumberJLabel = new JLabel("");
	static JLabel displayPassengerNameJLabel = new JLabel("");
	static JLabel displayMobileNoJLabel = new JLabel("");
	
	JButton printTicketJButton = new JButton("Print Ticket");
	JButton closeJButton = new JButton("Close");
	
   public Reservation3() 
   {
	   setSize(800, 700);
	   setTitle("Travels Reservation System - Reservation3");
	   setLayout(null);
	   setLocation(400,70);
	   
	   add(headingJLabel);
	   headingJLabel.setBounds(130, 5, 520, 48);
	   headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 45));
	   
	   add(borderJLabel);
	   borderJLabel.setBounds(60, 60, 760, 20);
	   
	   add(pnrNoJLabel);
	   pnrNoJLabel.setBounds(60, 100, 150, 20);
	   pnrNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayPnrNoJLabel);
	   displayPnrNoJLabel.setBounds(450, 100, 250, 20);
	   displayPnrNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(sourceJLabel);
	   sourceJLabel.setBounds(60, 140, 210, 20);
	   sourceJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displaySourceJLabel);
	   displaySourceJLabel.setBounds(450, 140, 250, 20);
	   displaySourceJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(destinationJLabel);
	   destinationJLabel.setBounds(60, 180, 210, 20);
	   destinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displaydestinationJLabel);
	   displaydestinationJLabel.setBounds(450, 180, 250, 20);
	   displaydestinationJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(dateofJourneyJLabel);
	   dateofJourneyJLabel.setBounds(60, 220, 210, 23);
	   dateofJourneyJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayDateOfJourneyJLabel);
	   displayDateOfJourneyJLabel.setBounds(450, 220, 250, 23);
	   displayDateOfJourneyJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(busTimingJLabel);
	   busTimingJLabel.setBounds(60, 260, 210, 23);
	   busTimingJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayBusTimingJLabel);
	   displayBusTimingJLabel.setBounds(450, 260, 250, 20);
	   displayBusTimingJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(totalDistanceinKmJLabel);
	   totalDistanceinKmJLabel.setBounds(60, 300, 270, 20);
	   totalDistanceinKmJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayTotalDistanceInKmJLabel);
	   displayTotalDistanceInKmJLabel.setBounds(450, 300, 250, 20);
	   displayTotalDistanceInKmJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(totalCostOfTicketJLabel);
	   totalCostOfTicketJLabel.setBounds(60, 340, 270, 20);
	   totalCostOfTicketJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayTotalCostOfTicketJLabel);
	   displayTotalCostOfTicketJLabel.setBounds(450, 340, 250, 20);
	   displayTotalCostOfTicketJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(busIdJLabel);
	   busIdJLabel.setBounds(60, 380, 210, 20);
	   busIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayBusIdJLabel);
	   displayBusIdJLabel.setBounds(450, 380, 250, 20);
	   displayBusIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(passengerINformatoinJLabel);
	   passengerINformatoinJLabel.setBounds(200, 430, 390, 30);
	   passengerINformatoinJLabel.setFont(new Font("Monospaced", Font.ITALIC, 27));
	   
	   add(seatNumberJLabel);
	   seatNumberJLabel.setBounds(60, 470, 135, 20);
	   seatNumberJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayseatNumberJLabel);
	   displayseatNumberJLabel.setBounds(60, 510, 135, 23);
	   displayseatNumberJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(passengerNameJLabel);
	   passengerNameJLabel.setBounds(280, 470, 200, 23);
	   passengerNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayPassengerNameJLabel);
	   displayPassengerNameJLabel.setBounds(280, 510, 200, 23);
	   displayPassengerNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(mobileNoJLabel);
	   mobileNoJLabel.setBounds(560, 470, 160, 20);
	   mobileNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   add(displayMobileNoJLabel);
	   displayMobileNoJLabel.setBounds(560, 510, 160, 23);
	   displayMobileNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   
	   add(lastBorderJLabel);
	   lastBorderJLabel.setBounds(60, 550, 760, 20);
	   
	   add(printTicketJButton);
	   printTicketJButton.setBounds(60, 580, 200, 30);
	   printTicketJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
	   printTicketJButton.setBackground(Color.BLACK);
	   printTicketJButton.setForeground(Color.WHITE);
	   
	   add(closeJButton);
	   closeJButton.setBounds(530, 580, 200, 30);
	   closeJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
	   closeJButton.setBackground(Color.BLACK);
	   closeJButton.setForeground(Color.WHITE);
	   
	   closeJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(Reservation3.this, "Ticket is Booked "+"\n\n HAPPY JOURNEY");
			new Home().setVisible(true);
			setVisible(false);
		}
	});
	   
   }
   public static void main(String[] args)
   {
	   Reservation3 reservation3 = new Reservation3();
	   reservation3.setVisible(true);
	   reservation3.setResizable(false);
   }
   
   public static int passingValuestoThird(String source, String destination, String dateofJourney, String timingString,long distance,
		float charges, long busId, int seatNo, String cname, long mobile) {
	   
	   	try {
	   		
		    displayPnrNoJLabel.setText(""+bigPin);
			displaySourceJLabel.setText(source);
			displaydestinationJLabel.setText(destination);
			displayDateOfJourneyJLabel.setText(dateofJourney);
			displayBusTimingJLabel.setText(timingString);
			displayTotalDistanceInKmJLabel.setText(""+distance+" km");
			displayTotalCostOfTicketJLabel.setText(""+charges);
			displayBusIdJLabel.setText(""+busId);
			displayseatNumberJLabel.setText(""+seatNo);
			displayPassengerNameJLabel.setText(cname);
			displayMobileNoJLabel.setText(""+mobile);
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Insert into CUSTOMERS values(?,?,?,?,?,?,?,?,?,?)");
			
			long pnrNo = Long.parseLong(displayPnrNoJLabel.getText());
			String sourceString =displaySourceJLabel.getText();
			String destnationString  = 	displaydestinationJLabel.getText();
			String dateOfJourneyString = displayDateOfJourneyJLabel.getText();
			String ticketCharges =displayTotalCostOfTicketJLabel.getText();
			long busIdlong = Long.parseLong(displayBusIdJLabel.getText());
			String seatNoString = displayseatNumberJLabel.getText();
			String passengerNameString = displayPassengerNameJLabel.getText();
			long mobileNo = Long.parseLong(displayMobileNoJLabel.getText());
			String busTimingString = displayBusTimingJLabel.getText();
	
			ps.setLong(1, pnrNo);
			ps.setString(2, passengerNameString);
			ps.setLong(3, mobileNo);
			ps.setString(4, sourceString);
			ps.setString(5, destnationString);
			ps.setLong(6, busIdlong);
			ps.setString(7, dateOfJourneyString);
			ps.setString(8, seatNoString);
			ps.setString(9, ticketCharges);
			ps.setString(10, busTimingString);
			
			int i = ps.executeUpdate();
			if (i==1) 
			{
				System.out.println("Ticket is Booked "+"\n Happy Journey");	
			} else {
				System.out.println("Something went wrong Ticket is not Booked yet ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	return 0;
   }
}

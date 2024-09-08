package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TicketCancelation extends JFrame
{
	JLabel headingJLabel = new JLabel("Ticket Cancelation");
	JLabel pnrNoJLabel = new JLabel("PNR Number :");
	JLabel nameJLabel = new JLabel("Name as per Ticket :");
	JLabel busIdJLabel = new JLabel("Bus Id :");
	
	JTextField pnrNoJTextField = new JTextField();
	JTextField nameJTextField = new JTextField();
	JTextField busIdJTextField = new JTextField();
	
	JButton cancelTicketJButton = new JButton("Cancel Ticket");
	JButton backJButton = new JButton("Back");
	
	public TicketCancelation() 
	{
		setSize(800, 400);
		setTitle("Travles Reservation System");
		setLayout(null);
		setLocation(400, 170);
		
		add(headingJLabel);
		headingJLabel.setBounds(230, 5, 400, 30);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		
		add(pnrNoJLabel);
		pnrNoJLabel.setBounds(70, 80,150, 20);
		pnrNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(pnrNoJTextField);
		pnrNoJTextField.setBounds(400, 80, 300, 25);
		pnrNoJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(nameJLabel);
		nameJLabel.setBounds(70, 130, 250, 23);
		nameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(nameJTextField);
		nameJTextField.setBounds(400, 130, 300, 25);
		nameJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(busIdJLabel);
		busIdJLabel.setBounds(70, 180, 150, 20);
		busIdJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(busIdJTextField);
		busIdJTextField.setBounds(400, 180, 300, 25);
		busIdJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(cancelTicketJButton);
		cancelTicketJButton.setBounds(500, 250, 200, 35);
		cancelTicketJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		cancelTicketJButton.setBackground(Color.BLACK);
		cancelTicketJButton.setForeground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(70, 250, 200, 35);
		backJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);
		
		cancelTicketJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					long pnrNo = Long.parseLong(pnrNoJTextField.getText());
					String cName = nameJTextField.getText();
					long busID = Long.parseLong(busIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Delete from CUSTOMERS where PNR_NO=? AND C_NAME=? AND BUS_ID=?");
					ps.setLong(1, pnrNo);
					ps.setString(2, cName);
					ps.setLong(3, busID);
					
					int i = ps.executeUpdate();
					
					if (i==1) 
					{
						JOptionPane.showMessageDialog(TicketCancelation.this, "Ticket is Canceled Successfully ");
					} else {
						JOptionPane.showMessageDialog(TicketCancelation.this, "Something went wrong Please check the Entered detials");
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
	}
	public static void main(String[] args)
	{
		TicketCancelation ticketCancelation = new TicketCancelation();
		ticketCancelation.setVisible(true);
		ticketCancelation.setResizable(false);
	}
}

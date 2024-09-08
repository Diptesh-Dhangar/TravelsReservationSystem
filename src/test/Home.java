package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Home extends JFrame
{ 
	JLabel headingJLabel = new JLabel("Travels Reservation System");
	ImageIcon homeImageIcon = new ImageIcon("C:\\Users\\DIPTESH\\Desktop\\travels.png");
	JLabel displayImageJLabel = new JLabel(homeImageIcon);
	
	JButton registractionJButton = new JButton("New Registration");
	
	JButton reservationJButton = new JButton("Reservation");
	JButton adminPanelJButton = new JButton("Admin Panel");
	JButton aboutSystemJButton = new JButton("About System");
	JButton cencelTicketJButton = new JButton("Cancel Ticket");
	
	public Home()
	{
		setSize(1300, 790);
		setTitle("Travels Reservation System");
		setLayout(null);
		setLocation(110, 20);
		
		add(headingJLabel);
		headingJLabel.setBounds(170, 10, 750, 42);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 41));
		
		add(registractionJButton);
		registractionJButton.setBounds(963, 28, 320, 35);
		registractionJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		registractionJButton.setBackground(Color.BLACK);
		registractionJButton.setForeground(Color.WHITE);
		
		add(reservationJButton);
		reservationJButton.setBounds(2, 65, 319, 35);
		reservationJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		reservationJButton.setBackground(Color.BLACK);
		reservationJButton.setForeground(Color.WHITE);
		
		add(adminPanelJButton);
		adminPanelJButton.setBounds(321, 65, 320, 35);
		adminPanelJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		adminPanelJButton.setBackground(Color.BLACK);
		adminPanelJButton.setForeground(Color.WHITE);
		
		add(aboutSystemJButton);
		aboutSystemJButton.setBounds(642, 65, 320, 35);
		aboutSystemJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		aboutSystemJButton.setBackground(Color.BLACK);
		aboutSystemJButton.setForeground(Color.WHITE);
		
		add(cencelTicketJButton);
		cencelTicketJButton.setBounds(963, 65, 320, 35);
		cencelTicketJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		cencelTicketJButton.setBackground(Color.BLACK);
		cencelTicketJButton.setForeground(Color.WHITE);
		
		add(displayImageJLabel);
		displayImageJLabel.setBounds(3, 101, 1280, 630);
			
		reservationJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Reservation().setVisible(true);
				setVisible(false);
			}
		});
		
		registractionJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewRegistration().setVisible(true);
				setVisible(false);
			}
		});
         
		adminPanelJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminPanel().setVisible(true);
				setVisible(false);
			}
		});
		
		aboutSystemJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutSystem().setVisible(true);
				setVisible(false);
			}
		});
		
		cencelTicketJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TicketCancelation().setVisible(true);
				setVisible(false);
			}
		});
		
	}
	public static void main(String[] args)
	{
		Home home = new Home();
		home.setVisible(true);
		home.setResizable(false);
	}
}

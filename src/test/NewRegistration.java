package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewRegistration extends JFrame
{
	 
	Random rdm = new Random();
	long first4 = (rdm.nextLong() % 9000L) + 1000L;
	long first = Math.abs(first4);
	
	JLabel headingJLabel = new JLabel("Luxury Bus Services");
	JLabel subheadingJLabel = new JLabel("New Registration");
	JLabel fullNameJLabel = new JLabel("Full Name :");
	JLabel mobileNoJLabel = new JLabel("Mobile No :");
	JLabel genderJLabel = new JLabel("Gender :");
	JLabel emailJLabel = new JLabel("Email :");
	JLabel addressJLabel = new JLabel("Address :");
	JLabel stateJLabel = new JLabel("State :");
	
	JTextField fullNameJTextField = new JTextField();
	JTextField mobileJTextField = new JTextField();
	JTextField genderJTextField = new JTextField();
	JTextField emailJTextField = new JTextField();
	JTextField addressJTextField = new JTextField();
	JTextField stateJTextField = new JTextField();
	
	ButtonGroup genderButtonGroup = new ButtonGroup();
	JRadioButton maleJRadioButton = new JRadioButton("Male");
	JRadioButton femaleJRadioButton = new JRadioButton("Female");
	JRadioButton otherJRadioButton = new JRadioButton("Other");
	
	
	JButton registerJButton = new JButton("Register");
	JButton cancelJButton = new JButton("Cancel");
	
	public NewRegistration()
	{
		setSize(600, 550);
		setTitle("Travels Reservation System");
		setLayout(null);
		setLocation(500, 130);
		
		add(headingJLabel);
		headingJLabel.setBounds(100, 10, 400, 40);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
		
		add(subheadingJLabel);
		subheadingJLabel.setBounds(200, 80, 250, 23);
		subheadingJLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
		
		add(fullNameJLabel);
		fullNameJLabel.setBounds(50, 150, 140, 20);
		fullNameJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(fullNameJTextField);
		fullNameJTextField.setBounds(250, 150, 250, 25);
		fullNameJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(mobileNoJLabel);
		mobileNoJLabel.setBounds(50, 200, 140, 20);
		mobileNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(mobileJTextField);
		mobileJTextField.setBounds(250, 200, 250, 25);
		mobileJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		genderButtonGroup.add(maleJRadioButton);
		genderButtonGroup.add(femaleJRadioButton);
		genderButtonGroup.add(otherJRadioButton);
		
		add(genderJLabel);
		genderJLabel.setBounds(50, 250, 140, 20);
		genderJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(maleJRadioButton);
		maleJRadioButton.setBounds(250, 250, 80, 20);
		maleJRadioButton.setFont(new Font("Monospaced", Font.BOLD, 20));

		add(femaleJRadioButton);
		femaleJRadioButton.setBounds(330, 250, 100, 20);
		femaleJRadioButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(otherJRadioButton);
		otherJRadioButton.setBounds(430, 250, 120, 20);
		otherJRadioButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(emailJLabel);
		emailJLabel.setBounds(50, 300, 100, 20);
		emailJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(emailJTextField);
		emailJTextField.setBounds(250, 300, 250, 25);
		emailJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(addressJLabel);
		addressJLabel.setBounds(50, 350, 120, 20);
		addressJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(addressJTextField);
		addressJTextField.setBounds(250, 350, 250, 25);
		addressJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(stateJLabel);
		stateJLabel.setBounds(50, 400, 90, 20);
		stateJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(stateJTextField);
		stateJTextField.setBounds(250, 400, 250, 25);
		stateJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(cancelJButton);
		cancelJButton.setBounds(10, 470, 200, 35);
		cancelJButton.setFont(new Font("Monospaced", Font.BOLD, 22));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(registerJButton);
		registerJButton.setBounds(370, 470, 200, 35);
		registerJButton.setFont(new Font("Monospaced", Font.BOLD, 22));
		registerJButton.setBackground(Color.BLACK);
		registerJButton.setForeground(Color.WHITE);
		
		
		registerJButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String UserId = "TRVLS"+first;
				
	             String fullName = fullNameJTextField.getText();
	             long mobile  = Long.parseLong(mobileJTextField.getText());
	             String selectedGender = "";
	             if (maleJRadioButton.isSelected())
	             {
					selectedGender = "Male";
			   	 } 
	             else if(femaleJRadioButton.isSelected()) 
			        	 {
			   		 		selectedGender = "Female";
				         }
	             else if(otherJRadioButton.isSelected()) 
	             {
	            	 selectedGender = "Other";
	             }
			   	 else {
			   	         selectedGender = "";
				      }
	             
	             String email = emailJTextField.getText();
	             String address = addressJTextField.getText();
	             String state = stateJTextField.getText();
	             
				try {
					 Connection con = DBConnection.getCon();
					 PreparedStatement ps = con.prepareStatement("Insert into Registration values(?,?,?,?,?,?,?)");
					 ps.setString(1, UserId);
					 ps.setString(2, fullName);
					 ps.setLong(3, mobile);
					 ps.setString(4, selectedGender);
					 ps.setString(5, email);
					 ps.setString(6, address);
					 ps.setString(7, state);
					 
					 int i = ps.executeUpdate();
					 
					 if (i==1)
					 {
						 JOptionPane.showMessageDialog(NewRegistration.this, "Registration Successfull"+"\n\n your USER ID :-"+UserId);  
					 }
					 else {
						JOptionPane.showMessageDialog(NewRegistration.this, "OOPS...!!!"+"\n\n Something went Wrong Please try again");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	    	}
		});
		
		cancelJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
	public static void main(String[] args) 
	{
		NewRegistration newRegistration = new NewRegistration();
		newRegistration.setVisible(true);
		newRegistration.setResizable(false);
	}
}

package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PaymentWindow extends JFrame
{
   JLabel headingJLabel  = new JLabel("Make Payment");
   
   JButton debitCardJButton = new JButton("Debit Card");
   JButton creditCardJButton = new JButton("Credit Card");
   JButton netBankingJButton = new JButton("Net Banking");
   JButton qrCodeJButton = new JButton("Generte QR");
   JButton proceedPaymentJButton = new JButton("Proceed Payment");
   
   JLabel cardNoJLabel = new JLabel("Card No :");
   JLabel cvvNoJLabel = new JLabel("CVV Code :");
   JLabel cardHolderJLabel = new JLabel("Card Holder :");
   JLabel expiryJLabel = new JLabel("Expiry :");
   
   JTextField cardNoFirst4JTextField = new JTextField();
   JTextField cardNo5to8JTextField = new JTextField();
   JTextField cardNo9to12JTextField = new JTextField();
   JTextField cardNo13to16JTextField = new JTextField();
   JTextField cvvNoJTextField = new JTextField();
   JTextField cardHolderJTextField = new JTextField();
   JTextField expiryMonthJTextField = new JTextField();
   JTextField expiryYearJTextField = new JTextField();
   
   JPanel creditCardJPanel = new JPanel();
   JPanel debitCardJPanel = new JPanel();
   JPanel netBankingJPanel = new JPanel();
   JPanel qrCodeJPanel = new JPanel();
   
   
	public PaymentWindow()
	{
		setSize(700,600);
		setTitle("Travels Reservation System - Payment Window");
		setLayout(null);
		
		add(headingJLabel);
		headingJLabel.setBounds(230, 5, 300, 39);
		headingJLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
		
		add(creditCardJButton);
		creditCardJButton.setBounds(30, 100, 200, 30);
		creditCardJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(debitCardJButton);
		debitCardJButton.setBounds(30, 150, 200, 30);
		debitCardJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(netBankingJButton);
		netBankingJButton.setBounds(30, 200, 200, 30);
		netBankingJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		add(qrCodeJButton);
		qrCodeJButton.setBounds(30, 250, 200, 30);
		qrCodeJButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		
	    add(proceedPaymentJButton);
	    proceedPaymentJButton.setBounds(300, 510, 300, 40);
	    proceedPaymentJButton.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    add(creditCardJPanel);
	    creditCardJPanel.setBackground(Color.WHITE);
	    creditCardJPanel.setBounds(250, 100, 400, 400);
	    creditCardJPanel.setLayout(null);
	    
	    creditCardJPanel.add(cardNoJLabel);
	    cardNoJLabel.setBounds(20, 20, 120, 20);
	    cardNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(cardNoFirst4JTextField);
	    cardNoFirst4JTextField.setBounds(80, 50, 60, 25);
	    cardNoFirst4JTextField.setFont(new Font("Monospaced", Font.BOLD, 22));
	    
	    creditCardJPanel.add(cardNo5to8JTextField);
	    cardNo5to8JTextField.setBounds(150, 50, 60, 25);
	    cardNo5to8JTextField.setFont(new Font("Monospaced", Font.BOLD, 22));
	    
	    creditCardJPanel.add(cardNo9to12JTextField);
	    cardNo9to12JTextField.setBounds(220, 50, 60, 25);
	    cardNo9to12JTextField.setFont(new Font("Monospaced", Font.BOLD, 22));
	    
	    creditCardJPanel.add(cardNo13to16JTextField);
	    cardNo13to16JTextField.setBounds(290, 50, 60, 25);
	    cardNo13to16JTextField.setFont(new Font("Monospaced", Font.BOLD, 22));
	    
	    creditCardJPanel.add(cardHolderJLabel);
	    cardHolderJLabel.setBounds(20, 100, 170, 20);
	    cardHolderJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(cardHolderJTextField);
	    cardHolderJTextField.setBounds(80, 130, 270, 25);
	    cardHolderJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(cvvNoJLabel);
	    cvvNoJLabel.setBounds(20, 180, 130, 20);
	    cvvNoJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(cvvNoJTextField);
	    cvvNoJTextField.setBounds(150, 180, 50, 25);
	    cvvNoJTextField.setFont(new Font("Monospaced", Font.BOLD, 22));   
	    
	    creditCardJPanel.add(expiryJLabel);
	    expiryJLabel.setBounds(20, 230, 120, 23);
	    expiryJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(expiryMonthJTextField);
	    expiryMonthJTextField.setBounds(150, 230, 50, 25);
	    expiryMonthJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	    
	    creditCardJPanel.add(expiryYearJTextField);
	    expiryYearJTextField.setBounds(210, 230, 50, 25);
	    expiryYearJTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
	}
	public static void main(String[] args) 
	{
		PaymentWindow paymentWindow = new PaymentWindow();
		paymentWindow.setVisible(true);
		paymentWindow.setResizable(false);
	}
}

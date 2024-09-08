package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AboutSystem extends JFrame
{
	JLabel headingJLabel = new JLabel("About System");
	JButton backJButton = new JButton("BACK");
    
   public AboutSystem()
   {
	   setSize(1200, 700);
	   setTitle("Travels Reservation System");
	   setLayout(null);
	   setLocation(170, 60);
	   
	   
	   add(backJButton);
	   backJButton.setBounds(60, 620, 200, 25);
	   backJButton.setFont(new Font("Monospaced", Font.BOLD, 21));
	   backJButton.setBackground(Color.BLACK);
	   backJButton.setForeground(Color.WHITE);
	   
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
	 AboutSystem aboutSystem = new AboutSystem();
	 aboutSystem.setVisible(true);
	 aboutSystem.setResizable(false);
   }
}

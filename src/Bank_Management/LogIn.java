

package Bank_Management;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class LogIn extends JFrame implements ActionListener																													
{
	//Declaire in GLOBAL
	JButton Longin,clear,signin;
	JTextField cardTextField;
	JPasswordField idTextField;
	String formNo;
	
	LogIn(String formNo )
	
	{
		this.formNo=formNo;
		setTitle("AUTOMATED TELLER MECHINE");
		setLayout(null);
		
		
		JLabel label=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/bank.jpg"));
		Image i2=img.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(i2);
		label.setIcon(img2);
		label.setBounds(31,22,100,86);
		getContentPane().add(label);
		
		//Heading
		JLabel text=new JLabel("Welcom TO ATM");		text.setFont(new Font("Osword",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		//Card Number Text
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,25));
		cardno.setBounds(100,150,150,30);
		add(cardno);
		
		//Card Number Text Box
		 cardTextField=new JTextField();
		cardTextField.setBounds(250,150,250,30);
		cardTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(cardTextField);
		
		//Pin Number Text
		JLabel pinno=new JLabel("Pin No:");
		pinno.setFont(new Font("Raleway",Font.BOLD,25));
		pinno.setBounds(120,220,250,30);
		add(pinno);
		
		//Pin Number Text Box
		 idTextField=new JPasswordField();
		idTextField.setBounds(250,220,250,30);
		idTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(idTextField);
		
		//Button Long In Box
		 Longin=new JButton("Log In");
		Longin.setBounds(250,300,100,30);
		Longin.setBackground(Color.DARK_GRAY);
		Longin.setForeground(Color.white);
		Longin.addActionListener(this);
		add(Longin);
		
		//Button Clear Box
		 clear=new JButton("Clear");
		clear.setBounds(400,300,100,30);
		clear.setBackground(Color.DARK_GRAY);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		
		//Button Sign In Box
		 signin=new JButton("Sign In");
		signin.setBounds(250,350,250,30);
		signin.setBackground(Color.DARK_GRAY);
		signin.setForeground(Color.white);
		signin.addActionListener(this);
		add(signin);
		
		getContentPane().setBackground(Color.white);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==clear)
		{
			cardTextField.setText("");
			idTextField.setText("");
			
		}
		else if(e.getSource()==Longin)
		{
			Comn conn=new Comn();
//String inside the store values of  (cardTextField & idTextField)
			String cardnumber=cardTextField.getText();
			String pinnumber=idTextField.getText();
			
//	This Query to use  Get the values of DataBase(CardNumber And PinNumber)
			String query="select * from longin where CardNumber='"+cardnumber+"'and PinNumber='"+pinnumber+"'";
			
			try
			{
				
//			"executeQuery" it is DDL Command 
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next())
				{
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect PassWord OR User Name");
				}
			}
			catch(Exception d)
			{
				System.out.println(d);
			}
			
			
		}
		else if(e.getSource()==signin)
		{
//		It connect for Other Class this two steps use
			setVisible(false);
			new SinginOne().setVisible(true);
			
		}
		
	}

	
	
	
	public static void main(String args [])
	{
		new LogIn("");
		
		
	}
	
		
}


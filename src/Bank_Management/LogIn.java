

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
		setTitle("Automated Teller Machine Login/Sign Up Page");
		setLayout(null);
		
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/img3.png"));
		Image i2=img.getImage().getScaledInstance(400,500,Image.SCALE_SMOOTH);
		ImageIcon img2=new ImageIcon(i2);
//		Image img=new ImageIcon(LogIn.class.getResource("/bankpng.png")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);?
		
		JLabel label=new JLabel();
		label.setBackground(Color.MAGENTA);
		label.setIcon(img2);
		label.setBounds(0,0,400,500);
		getContentPane().add(label);
		
		//Heading
		JLabel text=new JLabel("Welcom TO ATM");		
		text.setFont(new Font("Osword",Font.BOLD,38));
		text.setBounds(450,50,400,40);
		add(text);
		
		//Card Number Text
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,25));
		cardno.setBounds(450,150,150,30);
		add(cardno);
		
		//Card Number Text Box
		 cardTextField=new JTextField();
		cardTextField.setBounds(600,150,150,30);
		cardTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(cardTextField);
		
		//Pin Number Text
		JLabel pinno=new JLabel("Pin No:");
		pinno.setFont(new Font("Raleway",Font.BOLD,25));
		pinno.setBounds(450,250,250,30);
		add(pinno);
		
		//Pin Number Text Box
		 idTextField=new JPasswordField();
		idTextField.setBounds(600,250,150,30);
		idTextField.setFont(new Font("Raleway",Font.BOLD,15));
		add(idTextField);
		
		//Button Long In Box
		 Longin=new JButton("Log In");
		Longin.setBounds(480,330,100,30);
		Longin.setBackground(Color.GREEN);
		Longin.setForeground(Color.black);
		Longin.addActionListener(this);
		add(Longin);
		
		//Button Clear Box
		 clear=new JButton("Clear");
		clear.setBounds(630,330,100,30);
		clear.setBackground(Color.GREEN);
		clear.setForeground(Color.black);
		clear.addActionListener(this);
		add(clear);
		
		
		//Button Sign In Box
		 signin=new JButton("Sign Up");
		signin.setBounds(480,380,250,30);
		signin.setBackground(Color.GREEN);
		signin.setForeground(Color.black);
		signin.addActionListener(this);
		add(signin);
		
		getContentPane().setBackground(Color.PINK);
		setSize(800,500);
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
			new SignInOne(formNo).setVisible(true);
			
		}
		
	}

	
	
	
	public static void main(String args [])
	{
		new LogIn("");
				
	}
	
		
}


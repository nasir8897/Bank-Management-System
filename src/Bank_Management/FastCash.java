package Bank_Management;


import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener
{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	String pinnumber;
	
	FastCash(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setUndecorated(true);
		setLayout(null);
		
		JLabel imglabel=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/atm.jpg"));
		Image i2=img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(i2);
		imglabel.setIcon(img2);
		imglabel.setBounds(0,0,900,900);
		getContentPane().add(imglabel);
		
		JLabel atmheading=new JLabel("SELECT WITHDRAW AMOUNT");
		atmheading.setBounds(190,300,300,40);
		atmheading.setForeground(Color.white);
		atmheading.setFont(new Font("Raleway",Font.BOLD,20));
		imglabel.add(atmheading);
		
		 b1=new JButton("Rs 100");
		b1.setBounds(153,417,130,28);
		b1.setFont(new Font("Raleway",Font.BOLD,12));
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		imglabel.add(b1);
		
		
		 b2=new JButton("Rs 500");
		b2.setBounds(390,417,130,28);
		b2.setFont(new Font("Raleway",Font.BOLD,12));
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		imglabel.add(b2);
		
		
		 b3=new JButton("Rs 1000");
		b3.setBounds(153,452,130,28);
		b3.setFont(new Font("Raleway",Font.BOLD,12));
		b3.setForeground(Color.blue);
		b3.addActionListener(this);
		imglabel.add(b3);
				
		
		 b4=new JButton("Rs 2000");
		b4.setBounds(390,452,130,28);
		b4.setFont(new Font("Raleway",Font.BOLD,12));
		b4.setForeground(Color.blue);
		b4.addActionListener(this);
		imglabel.add(b4);
		
//		
		 b5=new JButton("Rs 5000");
		b5.setBounds(153,485,130,28);
		b5.setFont(new Font("Raleway",Font.BOLD,12));
		b5.setForeground(Color.blue);
		b5.addActionListener(this);
		imglabel.add(b5);
		
		
		 b6=new JButton("Rs 10000");
		b6.setBounds(390,485,130,28);
		b6.setFont(new Font("Raleway",Font.BOLD,12));
		b6.setForeground(Color.blue);
		b6.addActionListener(this);
		imglabel.add(b6);
		
	
		
		 b7=new JButton("Back");
		b7.setBounds(153,520,130,28);
		b7.setFont(new Font("Raleway",Font.BOLD,12));
		b7.setForeground(Color.blue);
		b7.addActionListener(this);
		imglabel.add(b7);
		
		 b8=new JButton("Exit");
		b8.setBounds(390,520,130,28);
		b8.setFont(new Font("Raleway",Font.BOLD,12));
		b8.setForeground(Color.blue);
		b8.addActionListener(this);
		imglabel.add(b8);
			
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
//		setUndecoret(true);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
//----------		Exit Button Work Condition		-----------
		if(e.getSource()==b7)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
		else if(e.getSource()==b8)
		{
			System.exit(0);
		}
		
		else
		{
			String amount=((JButton)e.getSource()).getText().substring(3); 		//rs 100
			
			Comn conn=new Comn();
			try
			{
				ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
				
//=====================================		Find the Balence	===========================================
				int balence=0;
				while(rs.next())
				{
					if(rs.getString("type").equals("Deposit"))
					{
						
//=======================		"Integer.parseInt"  is convert to String to integer.	==========
						
						balence += Integer.parseInt (rs.getString("Amount"));
					}
					else
					{
						balence -= Integer.parseInt (rs.getString("Amount"));
					}
					
					if(e.getSource() != b7 && balence < Integer.parseInt(amount))
					{
						JOptionPane.showMessageDialog(null,"Insuffisient Balence");
						return;
					}
					
				}
				Date date=new Date();	
				String query="insert into bank value('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs "+amount+".00/- Withdraw Successfully" );
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
			}
			catch(Exception ea)
			{
				System.out.println(ea);
			}
		}
		
	}
	
	
	public static void main(String args [])
	{
		new FastCash("");
	}


}

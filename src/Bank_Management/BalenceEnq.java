package Bank_Management;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class BalenceEnq extends JFrame implements ActionListener
{
	
	String pinnumber;
	JButton b1,b2;
	
	BalenceEnq(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setUndecorated(true);
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/atm.jpg"));
		JLabel imglabel=new JLabel();
		imglabel.setIcon(img);
		imglabel.setBounds(0,0,900,900);
		getContentPane().add(imglabel);
		
		b1=new JButton("Back");
		b1.setFont(new Font("Raleway",Font.BOLD,15));
		b1.setBounds(170,535,100,30);
		b1.addActionListener(this);
		imglabel.add(b1);
		
		b2=new JButton("Exit");
		b2.setFont(new Font("Raleway",Font.BOLD,15));
		b2.setBounds(450,535,100,30);
		b2.addActionListener(this);
		imglabel.add(b2);
		
		
		int balence=0;
		try
		{
			
			Comn conn=new Comn();
			ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balence += Integer.parseInt(rs.getString("Amount"));
				}
				else 
				{
					balence -= Integer.parseInt(rs.getString("Amount"));
				}
			}
			
		}
		catch(Exception ea)
		{
			System.out.println(ea);
		}
		
		JLabel balenceDisplay=new JLabel("Your Current Account Balence:");
		balenceDisplay.setBounds(200,250,400,30);
		balenceDisplay.setFont(new Font("Raleway",Font.BOLD,20));
		balenceDisplay.setForeground(Color.CYAN);
		imglabel.add(balenceDisplay);
		
		JLabel balenceDisplay1=new JLabel(""+balence+".00/-");
		balenceDisplay1.setBounds(330,300,400,30);
		balenceDisplay1.setFont(new Font("Raleway",Font.BOLD,20));
		balenceDisplay1.setForeground(Color.GREEN);
		imglabel.add(balenceDisplay1);
		
		
		setSize(900,900);
		setLocation(350,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
			
		}
		else if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		
	}
	
	public static void main(String args [])
	{
		new BalenceEnq("");
	}


}

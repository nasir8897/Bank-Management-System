package Bank_Management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener
{
	
	
	JButton b1,b2,b3;
	JTextField conpintext,newpintext;
	String pinnumber;
	
	
	ChangePin(String pinnumber)
	{
		
		this.pinnumber=pinnumber;
		
		setUndecorated(true);
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/atm.jpg"));
		JLabel imglabel=new JLabel();
		imglabel.setIcon(img);
		imglabel.setBounds(0,0,900,900);
		getContentPane().add(imglabel);
		
		JLabel heading=new JLabel("Change Your Pin");
		heading.setForeground(Color.white);
		heading.setFont(new Font("raleway",Font.BOLD,20));
		heading.setBounds(280,250,250,40);
		imglabel.add(heading);
		
		
		JLabel newpin=new JLabel("New PIn Enter");
		newpin.setForeground(Color.white);
		newpin.setFont(new Font("raleway",Font.BOLD,20));
		newpin.setBounds(180,310,250,30);
		imglabel.add(newpin);
		
		
		JLabel conformpin=new JLabel("RE-Enter New Pin");
		conformpin.setForeground(Color.white);
		conformpin.setFont(new Font("raleway",Font.BOLD,20));
		conformpin.setBounds(180,340,350,30);
		imglabel.add(conformpin);
		
		 newpintext=new JTextField();
		newpintext.setFont(new Font("raleway",Font.ROMAN_BASELINE,20));
		newpintext.setBounds(400,310,150,25);
		imglabel.add(newpintext);
		
		 conpintext=new JTextField();
		conpintext.setFont(new Font("raleway",Font.ROMAN_BASELINE,20));
		conpintext.setBounds(400,340,150,25);
		imglabel.add(conpintext);
		
		
		 b1=new JButton("Change");
		b1.setFont(new Font("Raleway",Font.BOLD,15));
		b1.setBounds(440,490,100,30);
		b1.addActionListener(this);
		imglabel.add(b1);
		
		 b2=new JButton("Exit");
		b2.setFont(new Font("Raleway",Font.BOLD,15));
		b2.setBounds(440,530,100,30);
		b2.addActionListener(this);
		imglabel.add(b2);
		
		 b3=new JButton("Back");
		b3.setFont(new Font("Raleway",Font.BOLD,15));
		b3.setBounds(170,530,100,30);
		b3.addActionListener(this);
		imglabel.add(b3);
		
		
		setSize(900,900);
		setLocation(350,0);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			try
			{
				String newpin=newpintext.getText();
				String changepin=conpintext.getText();
				
				if(!newpin.equals(changepin))
				{
					JOptionPane.showMessageDialog(null,"Your Pin Does Not Match Please Try Again" );
					return;
				}
				if(newpin.equals("") || changepin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter New Pin ");
					return;
				}
				
				
				Comn conn=new Comn();
				String query1="update bank set pin='"+changepin+"' where pin='"+pinnumber+"'";
				String query2="update longin set PinNumber='"+changepin+"' where PinNumber='"+pinnumber+"'";
				String query3="update singin3 set PinNumber='"+changepin+"' where PinNumber='"+pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null,"Pin Number Changed Successfullt");
				
				setVisible(false);
				new Transactions(changepin).setVisible(true);
				
				
			}
			catch(Exception ea)
			{
				System.out.println(ea);
			}
			
			
			
		}
		else if(e.getSource()==b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==b3)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);;
		}
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String args[])
	{
		new ChangePin("");
	}


}

package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener
{
	
	
	JButton b1,b2,b3;
	JTextField enteramount;
	
	
	String pinnumber;
	
	Withdraw(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		JLabel label=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/atm.jpg")); 
		label.setIcon(img);
		label.setBounds(0,0,900,900);
		getContentPane().add(label);
		
		
		JLabel heading=new JLabel("Enter The Amount You Want TO Withdraw");
		heading.setFont(new Font("Raleway",Font.BOLD,17));
		heading.setForeground(Color.white);		
		heading.setBounds(200,280,350,40);
		label.add(heading);
		
		 enteramount=new JTextField();
		enteramount.setFont(new Font("Raleway",Font.BOLD,17));
		enteramount.setBounds(200,350,300,40);
		label.add(enteramount);
		
		b1=new JButton("Withdraw");
		b1.setBounds(400,455,150,30);
		b1.setFont(new Font("Raleway",Font.BOLD,18));
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		label.add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(400,495,150,30);
		b2.setFont(new Font("Raleway",Font.BOLD,18));
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		label.add(b2);
		
		
		b3=new JButton("Exit");
		b3.setBounds(400,535,150,30);
		b3.setFont(new Font("Raleway",Font.BOLD,18));
		b3.setForeground(Color.blue);
		b3.addActionListener(this);
		label.add(b3);
		
		
		setSize(900,900);
		setLocation(350,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==b2)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
			
		}
		else if(e.getSource()==b1)
		{
			
			try
			{
				
				Comn conn=new Comn();
				String number=enteramount.getText();
				
				if(number.equals(""))
				 {
					 JOptionPane.showMessageDialog(null,"Please Enter The Amount" );
					 
					 
				 }
				else
				{
					ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
					int balence=0;
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
					
					
					if (balence > Integer.parseInt(number))
					{
						
						Date date=new Date();
						String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
						conn.s.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null,"Rs "+number+".00/- Withdraw Successfully");
						
						setVisible (false);
						new Transactions(pinnumber).setVisible(true);
						
						
						
					}
					
					else 
					{
						JOptionPane.showMessageDialog(null,"Insuffisient Balence" );
					}
					
				}
				
				
			}
			
			catch(Exception ea)
			{
				System.out.println(ea);
			}
		}
		else if(e.getSource()==b3)
		{
			System.exit(0);
		}
			
	}
	
	
	public static void main(String args [])
	{
		new Withdraw("");
	}

	

}

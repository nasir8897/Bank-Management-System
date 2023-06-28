package Bank_Management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Transactions extends JFrame implements ActionListener
{
	
	JButton b1,b2,b3,b4,b5,b6,b7;
	String pinnumber;
	
	
	
	Transactions(String pinnumber)
	{
		
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
		
		JLabel imglabel=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/atm.jpg"));
//		Image i2=img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
//		ImageIcon img2=new ImageIcon(i2);
		imglabel.setIcon(img);
		imglabel.setBounds(0,0,900,900);
		getContentPane().add(imglabel);
		
		
		JLabel welcome=new JLabel("Welcome To ABC ATM ");
		welcome.setBounds(250,280,300,40);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Raleway",Font.BOLD,20));
		imglabel.add(welcome);
		
		JLabel name1=new JLabel( );
		name1.setBounds(260,310,300,40);
		name1.setForeground(Color.GREEN);
		name1.setFont(new Font("Raleway",Font.BOLD,20));
		imglabel.add(name1);
		
		JLabel atmheading=new JLabel("Please Select your Transaction");
		atmheading.setBounds(200,350,300,40);
		atmheading.setForeground(Color.white);
		atmheading.setFont(new Font("Raleway",Font.BOLD,20));
		imglabel.add(atmheading);
		
		 b1=new JButton("Deposit");
		b1.setBounds(165,417,130,28);
		b1.setFont(new Font("Raleway",Font.BOLD,12));
		b1.setForeground(Color.blue);
		b1.addActionListener(this);
		imglabel.add(b1);
		
		
		 b2=new JButton("Chash Withdrawl");
		b2.setBounds(420,417,130,28);
		b2.setFont(new Font("Raleway",Font.BOLD,12));
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		imglabel.add(b2);
		
		
		 b3=new JButton("Fast Cash");
		b3.setBounds(165,460,130,28);
		b3.setFont(new Font("Raleway",Font.BOLD,12));
		b3.setForeground(Color.blue);
		b3.addActionListener(this);
		imglabel.add(b3);
				
		
		 b4=new JButton("Mini Statement");
		b4.setBounds(420,460,130,28);
		b4.setFont(new Font("Raleway",Font.BOLD,12));
		b4.setForeground(Color.blue);
		b4.addActionListener(this);
		imglabel.add(b4);
		
//		
		 b5=new JButton("Pin Change");
		b5.setBounds(165,500,130,28);
		b5.setFont(new Font("Raleway",Font.BOLD,12));
		b5.setForeground(Color.blue);
		b5.addActionListener(this);
		imglabel.add(b5);
		
		
		 b6=new JButton("Balence Enquiry");
		b6.setBounds(420,500,130,28);
		b6.setFont(new Font("Raleway",Font.BOLD,12));
		b6.setForeground(Color.blue);
		b6.addActionListener(this);
		imglabel.add(b6);
		
	
		
		 b7=new JButton("Exit");
		b7.setBounds(420,540,130,28);
		b7.setFont(new Font("Raleway",Font.BOLD,12));
		b7.setForeground(Color.blue);
		b7.addActionListener(this);
		imglabel.add(b7);
		
//===================================================================================
		
//		String name2;
		try
		{
			Comn conn=new Comn();
			ResultSet rs=conn.s.executeQuery("select * from longin where PinNumber='"+pinnumber+"'");
			int name = 0;
			while(rs.next())
			{
				
				 name=Integer.parseInt(rs.getString("formNo"));
			}
			
			
			ResultSet rs1=conn.s.executeQuery("select * from singin where formNo='"+name+"'");
			
			
		
			while(rs1.next())
			{
				name1.setText("Mr/Ms:-"+(rs1.getString("name")));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
//----------		Exit Button Work Condition		-----------
		if(e.getSource()==b7)
		{
			System.exit(0);
		}
		else if (e.getSource()==b1)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		
		else if(e.getSource()==b2)
		{
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		}
		
		else if(e.getSource()==b3)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		else if(e.getSource()==b5)
		{
			setVisible (false);
			new ChangePin(pinnumber).setVisible(true);
		}
		else if(e.getSource()==b6)
		{
			setVisible(false);
			new BalenceEnq(pinnumber).setVisible(true);
		}
		
		else if(e.getSource()==b4)
		{
			
//			setVisible(true);
			new MiniStatement(pinnumber).setVisible(true);
		}
		
	}
	
	
	public static void main(String args [])
	{
		new Transactions("");
	}


}

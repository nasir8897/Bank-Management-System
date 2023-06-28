package Bank_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SignInThree extends JFrame implements ActionListener {
	
	
//=================	Global Declarartion ====================
	JRadioButton saccount,fdaccount,cuaccount,rdaccount;
	ButtonGroup accountGroup;	
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel,back;
	String formNo;
	
	
//=======	the perameter inside recive the value of 'form number'
	SignInThree(String formNo)
	{
		this.formNo=formNo;
		
		setLayout(null);
		
		JLabel i1=new JLabel("Page 3: Accout Details");
		i1.setFont(new Font("Railway",Font.BOLD,20));
		i1.setBounds(330,50,300,40);
		add(i1);
		
		
		JLabel actype=new JLabel("Accout Type");
		actype.setFont(new Font("Railway",Font.BOLD,20));
		actype.setBounds(100,150,200,30);
		add(actype);
		
		 saccount=new JRadioButton("Saving Accout");
		 saccount.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		 saccount.setBounds(100,200,200,30);
		 saccount.setBackground(Color.LIGHT_GRAY);
		add(saccount);
		
		
		fdaccount=new JRadioButton("Fixed Deposit Accout");
		fdaccount.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		fdaccount.setBounds(400,200,300,30);
		fdaccount.setBackground(Color.LIGHT_GRAY);
		add(fdaccount);
		
		
		cuaccount=new JRadioButton("Current Accout");
		cuaccount.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		cuaccount.setBounds(100,250,200,30);
		cuaccount.setBackground(Color.LIGHT_GRAY);
		add(cuaccount);
		
		rdaccount=new JRadioButton("Recurring Deposit Accout");
		rdaccount.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		rdaccount.setBounds(400,250,300,30);
		rdaccount.setBackground(Color.LIGHT_GRAY);
		add(rdaccount);
		
		accountGroup=new ButtonGroup();
		accountGroup.add(saccount);
		accountGroup.add(fdaccount);
		accountGroup.add(cuaccount);
		accountGroup.add(rdaccount);
		
		JLabel cardtype=new JLabel("Card Number:");
		cardtype.setFont(new Font("Railway",Font.BOLD,20));
		cardtype.setBounds(100,300,200,30);
		add(cardtype);
		
		JLabel massage=new JLabel("Your 16 Dezits Card Number");
		massage.setFont(new Font("Railway",Font.BOLD,15));
		massage.setBounds(100,320,300,30);
		massage.setForeground(Color.WHITE);;
		add(massage);
		
		
		JLabel cardno=new JLabel("XXXX-XXXX-XXXX-8897");
		cardno.setFont(new Font("Railway",Font.BOLD,20));
		cardno.setBounds(400,300,400,30);
		add(cardno);
		
		
		JLabel pintype=new JLabel("PIN Number:");
		pintype.setFont(new Font("Railway",Font.BOLD,20));
		pintype.setBounds(100,380,200,30);
		add(pintype);
		
		JLabel massage1=new JLabel("Your 4 Dezits Password");
		massage1.setFont(new Font("Railway",Font.BOLD,15));
		massage1.setBounds(100,400,300,30);
		massage1.setForeground(Color.white);;
		add(massage1);
		
		
		JLabel pinno=new JLabel("XXXX");
		pinno.setFont(new Font("Railway",Font.BOLD,20));
		pinno.setBounds(400,380,400,30);
		add(pinno);
		
		JLabel service=new JLabel("Services Required");
		service.setFont(new Font("Railway",Font.BOLD,20));
		service.setBounds(100,450,250,30);
		add(service);
		
		
		 c1=new JCheckBox("ATM Card");
		 c1.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c1.setBounds(100,500,150,30);
		c1.setBackground(Color.LIGHT_GRAY);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		 c2.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c2.setBounds(400,500,150,30);
		c2.setBackground(Color.LIGHT_GRAY);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		 c3.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c3.setBounds(100,550,150,30);
		c3.setBackground(Color.LIGHT_GRAY);
		add(c3);
		
		c4=new JCheckBox("Emain & Massage Allert");
		 c4.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c4.setBounds(400,550,300,30);
		c4.setBackground(Color.LIGHT_GRAY);
		add(c4);
		
		
		c5=new JCheckBox("Chack Book");
		 c5.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c5.setBounds(100,600,150,30);
		c5.setBackground(Color.LIGHT_GRAY);
		add(c5);
		
		c6=new JCheckBox("E-Statement");
		 c6.setFont(new Font("Railway",Font.ROMAN_BASELINE,15));
		c6.setBounds(400,600,150,30);
		c6.setBackground(Color.LIGHT_GRAY);
		add(c6);
		
		c7=new JCheckBox("I Here By Declaire that the Above Entered Details Are Correct To The Best Of My Knowlwdge");
		 c7.setFont(new Font("Railway",Font.ROMAN_BASELINE,13));
		c7.setBounds(100,650,600,30);
		c7.setBackground(Color.LIGHT_GRAY);
		add(c7);
		
		 submit=new JButton("Submit");
		submit.setFont(new Font("Railway",Font.BOLD,17));
		submit.setBounds(500,700,100,30);
		submit.setBackground(Color.BLUE);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		
		 cancel=new JButton("Cancel");
		cancel.setFont(new Font("Railway",Font.BOLD,17));
		cancel.setBounds(300,700,100,30);
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		
		back=new JButton("Back");
		back.setFont(new Font("Railway",Font.BOLD,17));
		back.setBounds(100,700,100,30);
		back.setBackground(Color.MAGENTA);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
//======================= Page set up : ==================================
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit)
		{
//=================================	  Type Of Account 	===================================
			
			String actype=null;
			if(saccount.isSelected())
			{
				actype="Saving Accout";
			}
			else if(fdaccount.isSelected())
			{
				actype="Fixed Deposit Accout";
			}
			else if(cuaccount.isSelected())
			{
				actype="Current Accout";
			}
			else if(rdaccount.isSelected())
			{
				actype="Recurring Deposit Accout";
			}
			
			Random random=new Random();
			
			//---------------------------------		Card Number Is Genarate		-----------------------------------------------
			
			String cardnumber=""+Math.abs((random.nextLong() % 90000000L) +1020105000000000L);
			
			//---------------------------------		PIN Number Is Genarate		-----------------------------------------------
			
			String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			
//==================================  Service Rquired  =========================================		
			
			String facility="";
			if(c1.isSelected())
			{
				facility=facility+" ATM Card";
			}
			else if(c2.isSelected())
			{
				facility=facility+" Internet Banking";
			}
			else if(c3.isSelected())
			{
				facility=facility+" Mobile Banking";
			}
			else if(c4.isSelected())
			{
				facility=facility+" Emain & Massage Allert";
			}
			else if(c5.isSelected())
			{
				facility=facility+" Chack Book";
			}
			else if(c6.isSelected())
			{
				facility=facility+" E-Statement";
				
			}
			
//=====================	Data Base Connection	==============================
			
			try
			{
				if(actype.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Account Type Is Required");
				}
//				else if(c7.equals(""))
//				{
//					JOptionPane.showMessageDialog(null,"click on the Declairation Box ");
//				}
				
//=============================	Insert INTO SQL Data Base This All Values	========================================
				
				else
				{
					Comn conn=new Comn();
//-------------------------------  4.Execute Query (Values insert into the SQL By using INSERT Query)	------------------------------
					
					String query1="insert into singin3 values('"+formNo+"','"+actype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"') ";
					
					String query2="insert into longin values('"+formNo+"','"+cardnumber+"','"+pinnumber+"') ";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null,"Card No: "+cardnumber+"\n"+"Pin No: "+pinnumber );
					
					setVisible(false);
					new LogIn(formNo).setVisible(true);;
					
					
					
					
				}
				
			}
			catch(Exception ea)
			{
				System.out.println(ea);
			}
	
		}
		else if(e.getSource()==cancel)
		{
			System.exit(0);
			
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			new SignIn_Two_Modify(formNo).setVisible(true);
		}
		
	}
	
	
	public static void main(String args[])
	{
		new SignInThree("");
	}

}

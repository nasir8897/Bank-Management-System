package Bank_Management;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SinginOne extends JFrame implements ActionListener {
	
//=================	Global Declaration ====================
	Long random;
	JTextField namebox,fanamebox,emailbox,AdressBox,cityBox,stateBox,pinBox;
	JDateChooser datechooser;
	JRadioButton male,female;
	ButtonGroup genderGroup;
	JRadioButton maried,unmaried,others;
	ButtonGroup statusGroup;
	JButton next,back;
	
	
	SinginOne()
	{
		setTitle("New Account Application Form: 1");
		setLayout(null);
		
		//Random Numbers Count 
		Random ran=new Random();
		 random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		//Form Heading And Form Number
		JLabel formNo=new JLabel("Application Form Number:-"+random);
		formNo.setFont(new Font("Ralway",Font.BOLD,40));
		formNo.setBounds(150,20,800,50);
		add(formNo);
		
		//Page Details
		JLabel personDetails=new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Ralway",Font.BOLD,20));
		personDetails.setBounds(380,80,300,30);
		add(personDetails);
		
//================== All Names Text: ========================
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Ralway",Font.BOLD,25));
		name.setBounds(100,150,100,30);
		add(name);	
				
		
		JLabel faname=new JLabel("Father Name:");
		faname.setFont(new Font("Ralway",Font.BOLD,25));
		faname.setBounds(100,200,200,30);
		add(faname);
		
		
		JLabel date=new JLabel("Date Of Birth:");
		date.setFont(new Font("Ralway",Font.BOLD,25));
		date.setBounds(100,250,200,30);
		add(date);
		
		JLabel g=new JLabel("Gender:");
		g.setFont(new Font("Ralway",Font.BOLD,25));
		g.setBounds(100,300,100,30);
		add(g);
		
		JLabel email=new JLabel("Email Id:");
		email.setFont(new Font("Ralway",Font.BOLD,25));
		email.setBounds(100,350,200,30);
		add(email);
		
		
		JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Ralway",Font.BOLD,25));
		marital.setBounds(100,400,200,30);
		add(marital);
		
		JLabel ad=new JLabel("Adress:");
		ad.setFont(new Font("Ralway",Font.BOLD,25));
		ad.setBounds(100,450,200,30);
		add(ad);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Ralway",Font.BOLD,25));
		city.setBounds(100,500,200,30);
		add(city);
		
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Ralway",Font.BOLD,25));
		state.setBounds(100,550,200,30);
		add(state);
		
		JLabel pincode=new JLabel("Pin Code:");
		pincode.setFont(new Font("Ralway",Font.BOLD,25));
		pincode.setBounds(100,600,200,30);
		add(pincode);
		
		
		
//================== All Text BOX: ==============================
		
		 namebox=new JTextField();
		namebox.setBounds(300,150,300,30);
		namebox.setFont(new Font("Railway",Font.ITALIC,20));
		add(namebox);
		
		 fanamebox=new JTextField();
		fanamebox.setBounds(300,200,300,30);
		fanamebox.setFont(new Font("Railway",Font.ITALIC,20));
		add(fanamebox);
		
		
		 emailbox=new JTextField();
		emailbox.setBounds(300,350,300,30);
		emailbox.setFont(new Font("Railway",Font.ITALIC,20));
		add(emailbox);
		
		
		 AdressBox=new JTextField();
		AdressBox.setBounds(300,450,300,30);
		AdressBox.setFont(new Font("Railway",Font.ITALIC,20));
		add(AdressBox);
		
		
		 cityBox=new JTextField();
		cityBox.setBounds(300,500,300,30);
		cityBox.setFont(new Font("Railway",Font.ITALIC,20));
		add(cityBox);
		
		 stateBox=new JTextField();
		stateBox.setBounds(300,550,300,30);
		stateBox.setFont(new Font("Railway",Font.ITALIC,20));
		add(stateBox);
		
		 pinBox=new JTextField();
		pinBox.setBounds(300,600,300,30);
		pinBox.setFont(new Font("Railway",Font.ITALIC,20));
		add(pinBox);
		
		//Date Of Birth
		 datechooser=new JDateChooser();
		datechooser.setBounds(300,250,300,30);
		add(datechooser);
		
		//Gender
		 male=new JRadioButton("Male");
		male.setBounds(300,300,80,30);
		male.setBackground(Color.white);
		add(male);
		
		//Fe Male
		 female=new JRadioButton("Fe Male");
		female.setBounds(520,300,80,30);
		female.setBackground(Color.white);
		add(female);
		
		//Group of Male and Fe Male
		 genderGroup=new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		
		
		//Status  Maried
		 maried=new JRadioButton("Married");
		maried.setBounds(300,400,80,30);
		maried.setBackground(Color.white);
		add(maried);
				
		//Un Maried
		 unmaried=new JRadioButton("Unmarried");
		unmaried.setBounds(400,400,90,30);
		unmaried.setBackground(Color.white);
		add(unmaried);
		
		//others
		 others=new JRadioButton("Others");
		others.setBounds(510,400,80,30);
		others.setBackground(Color.white);
		add(others);
				
		//Group of maried and Unmaried
		 statusGroup=new ButtonGroup();
		statusGroup.add(maried);
		statusGroup.add(unmaried);
		statusGroup.add(others);
		
		
		 next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway",Font.BOLD,20));
		next.setBounds(520,700,80,30);
		next.addActionListener(this);
		add(next);
		
		 back=new JButton("Back");
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.white);
		 back.setFont(new Font("Railway",Font.BOLD,20));
		 back.setBounds(100,700,100,30);
		 back.addActionListener(this);
		add(back);
		
		
//======================= Page set-up : ==================================
		
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ea) 
	{
		
		String formNo=""+random;
		String name=namebox.getText();
		String fname=fanamebox.getText();
		String email=emailbox.getText();
		String adress=AdressBox.getText();
		String city=cityBox.getText();
		String state=stateBox.getText();
		String pin=pinBox.getText();
		String dob=((JTextField) datechooser.getDateEditor()).getText();
//-------------------------------------------------------------------------------	
		String gender=null;
		if(male.isSelected())
		{
			gender="male";
		}
		else if(female.isSelected())
		{
			gender="Female";
		}
//-------------------------------------------------------------------------------	
		String status=null;
		if(maried.isSelected())
		{
			status="Married";
		}
		else if(unmaried.isSelected())
		{
			status="UnMarried";
		}
		else if (others.isSelected())
		{
			status="Others";
		}
		
//---------------------------------------------------------------------------------
		try
		{
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Name Is Reaqied");
			}
			else if(fname.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Father Name Is Reaqied");
			}
			else if(email.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Email Is Reaqied");
			}
			else if(adress.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Adress Is Reaqied");
			}
			else if(city.equals(""))
			{
				JOptionPane.showMessageDialog(null,"City Is Reaqied");
			}
			else if(state.equals(""))
			{
				JOptionPane.showMessageDialog(null,"State Is Reaqied");
			}
			else if(pin.equals(""))
			{
				JOptionPane.showMessageDialog(null,"PIN No Is Reaqied");
			}
			
			else if(dob.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Data Of Birth Is Reaqied");
			}
//			else if(gender.equals("Gender Is Requied"))
//			{
//				JOptionPane.showMessageDialog(null,"Data Of Birth Is Reaqied");
//			}
//			else if(status.equals("Status Is Requied"))
//			{
//				JOptionPane.showMessageDialog(null,"Data Of Birth Is Reaqied");
//			}
			
			
//=============================	Insert INTO SQL Data Base This All Values	========================================
			else
			{
				Comn c=new Comn();
//-------------------------------  4.Execute Query (Values insert into the SQL By using INSERT Query)	------------------------------
				String query="insert into singin values('"+formNo+"',' "+name+"','"+fname+"',' "+email+"',' "+adress+"',' "+city+"',' "+state+"',' "+pin+"',' "+dob+"' ,'"+gender+"' ,'"+status+"')";
		//Execute the query by using (Statement {s =c..createStatment}) with help of comn Class 
				c.s.executeUpdate(query);
				
//------------It connect for Other Class this two steps use (Form Number Also Pass Other CLass)--------------
				setVisible(false);
				
				new SinginTwo(formNo).setVisible(true);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if (ea.getSource()==back)
		{
			setVisible(false);
			new LogIn("").setVisible(true);
			
		}
	}

	public static void main(String[] args) 
	{
		new SinginOne();
	}

}

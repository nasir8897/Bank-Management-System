package Bank_Management;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class SigninOneModify extends JFrame implements ActionListener {
	
//=================	Global Declaration ====================
	
	JTextField namebox,fanamebox,emailbox,AdressBox,cityBox,stateBox,pinBox;
	JDateChooser datechooser;
	JRadioButton male,female;
	ButtonGroup genderGroup;
	JRadioButton maried,unmaried,others;
	ButtonGroup statusGroup;
	JButton next,back,cancel;
	String formNo;
	
	SigninOneModify(String formNo)
	{
		this.formNo=formNo;
		setTitle("New Account Application Form: 1");
		setLayout(null);
		
		//Random Numbers Count 
		
		
		
		
		//Form Heading And Form Number
		JLabel formNu=new JLabel("Application Form Number:- "+formNo);
		formNu.setFont(new Font("Ralway",Font.BOLD,40));
		formNu.setBounds(150,20,800,50);
		add(formNu);
		
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
		datechooser.setFont(new Font("Railway",Font.ITALIC,20));
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
		next.setBackground(Color.BLUE);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway",Font.BOLD,20));
		next.setBounds(520,700,80,30);
		next.addActionListener(this);
		add(next);
		
		 back=new JButton("Back");
		 back.setBackground(Color.MAGENTA);
		 back.setForeground(Color.white);
		 back.setFont(new Font("Railway",Font.BOLD,20));
		 back.setBounds(100,700,100,30);
		 back.addActionListener(this);
		add(back);
		
		 cancel=new JButton("Cancel");
			cancel.setFont(new Font("Railway",Font.BOLD,17));
			cancel.setBounds(300,700,100,30);
			cancel.setBackground(Color.RED);
			cancel.setForeground(Color.white);
			cancel.addActionListener(this);
			add(cancel);
		
		
			
//=======================================================================================================
			
			try
			{
				Comn conn=new Comn();
				
				
				ResultSet rs=conn.s.executeQuery("select * from singin where formNo='"+formNo+"'");
				
				
				while (rs.next())
				{
					
				namebox.setText(rs.getString("name"));
				fanamebox.setText(rs.getString("fname"));
				emailbox.setText(rs.getString("email"));
				AdressBox.setText(rs.getString("adress"));
				cityBox.setText(rs.getString("city"));
				stateBox.setText(rs.getString("state"));
				pinBox.setText(rs.getString("pincode"));
//				datechooser.setText(rs.getString("dob"));
//				genderGroup.setText(rs.getString("pincode"));
					
					
				}
				
				
				
				
			}
			catch(Exception e )
			{
				System.out.println(e);
			}
			
			
			
//=======================================================================================================
			
		
//======================= Page set-up : ==================================
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ea) 
	{
		

		
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
		if (ea.getSource()==next)
		{
			
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
					//String query1="insert into singin values('"+formNo+"',' "+name+"','"+fname+"',' "+email+"',' "+adress+"',' "+city+"',' "+state+"',' "+pin+"',' "+dob+"' ,'"+gender+"' ,'"+status+"')";
					String query1="update singin set name='"+name+"', fname='"+fname+"',email='"+email+"',adress='"+adress+"',city='"+city+"',state=' "+state+"',pincode=' "+pin+"',dob=' "+dob+"',gender=' "+gender+"',status=' "+status+"' where formNo='"+formNo+"' " ;
					
					//Execute the query by using (Statement {s =c..createStatment}) with help of comn Class 
					c.s.executeUpdate(query1);
					
//------------It connect for Other Class this two steps use (Form Number Also Pass Other CLass)--------------
					setVisible(false);
					
					new SignInTwo(formNo).setVisible(true);
					
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else if (ea.getSource()==back)
		{
			setVisible(false);
			new LogIn("").setVisible(true);
			
		}
		else if(ea.getSource()==cancel)
		{
			System.exit(0);
		}
	}

	public static void main(String[] args) 
	{
		new SigninOneModify("");
	}

}

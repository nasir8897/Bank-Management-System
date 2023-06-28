package Bank_Management;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignIn_Two_Modify extends JFrame implements ActionListener {
	
//=================	Global Declarartion ====================

	JTextField panBox,adharBox;
	JComboBox religionBox,categoryBox,incomeBox,educationBox,acupationBox;
	JRadioButton seniorBox1,seniorBox2;
	ButtonGroup seniorGroup;
	JRadioButton accountyes,accountno;
	ButtonGroup accountGroup;
	JButton next,back,cancel;
	String formNo;
	
//=======	the perameter inside recive the value of 'form number'
	SignIn_Two_Modify(String formNo)
	{
		this.formNo=formNo;
		setTitle("New Account Application Form: 2");
		setLayout(null);
		
				
		//Page Details
		JLabel personDetails=new JLabel("Page 2: Aditional Details");
		personDetails.setFont(new Font("Ralway",Font.BOLD,20));
		personDetails.setBounds(360,40,300,30);
		add(personDetails);
		
//================== All Nemes Text: ========================
		
		JLabel religion=new JLabel("Religion:");
		religion.setFont(new Font("Ralway",Font.BOLD,15));
		religion.setBounds(100,150,200,30);
		add(religion);	
				
		
		JLabel category=new JLabel("Category:");
		category.setFont(new Font("Ralway",Font.BOLD,15));
		category.setBounds(100,200,200,30);
		add(category);
		
		
		JLabel income=new JLabel("Income:");
		income.setFont(new Font("Ralway",Font.BOLD,15));
		income.setBounds(100,250,200,30);
		add(income);
		
		JLabel education=new JLabel("Education Qualification:");
		education.setFont(new Font("Ralway",Font.BOLD,15));
		education.setBounds(100,300,300,30);
		add(education);
		
		JLabel acupation=new JLabel("Accupation:");
		acupation.setFont(new Font("Ralway",Font.BOLD,15));
		acupation.setBounds(100,350,200,30);
		add(acupation);
		
		JLabel pan=new JLabel("PAN Number:");
		pan.setFont(new Font("Ralway",Font.BOLD,15));
		pan.setBounds(100,400,200,30);
		add(pan);
		
		
		
		JLabel adhar=new JLabel("Adhar Number:");
		adhar.setFont(new Font("Ralway",Font.BOLD,15));
		adhar.setBounds(100,450,200,30);
		add(adhar);
		
		JLabel senior=new JLabel("Senior Citizen:");
		senior.setFont(new Font("Ralway",Font.BOLD,15));
		senior.setBounds(100,500,200,30);
		add(senior);
		
		JLabel account=new JLabel("Exisiting Account:");
		account.setFont(new Font("Ralway",Font.BOLD,15));
		account.setBounds(100,550,200,30);
		add(account);
		
		
		
		
//================== All Text BOX: ==============================
		
		String[] values= {"Muslim","Hindu","Christian","Others"};
		 religionBox=new JComboBox(values);
		 religionBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 religionBox.setBounds(300,150,300,30);
		 religionBox.setBackground(Color.white);
		add(religionBox);	
				
		String[] cvalues= {"General","OC","OBC","SC","ST"};
		 categoryBox=new JComboBox(cvalues);
		 categoryBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 categoryBox.setBounds(300,200,300,30);
		 categoryBox.setBackground(Color.white);
		add(categoryBox);
		
		String[] ivalues= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
		 incomeBox=new JComboBox(ivalues);
		 incomeBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 incomeBox.setBounds(300,250,300,30);
		 incomeBox.setBackground(Color.white);
		add(incomeBox);
		
		String[] evalues= {"Non-Graduation","Graduation","Post-Graduation","Bachular-Degree","Others"};
		 educationBox=new JComboBox(evalues);
		 educationBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 educationBox.setBounds(300,300,300,30);
		 educationBox.setBackground(Color.white);
		add(educationBox);
		
		String[] acvalues= {"Student","Salaried","Self-Employed","Retired","Others"};
		 acupationBox=new JComboBox(acvalues);
		 acupationBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 acupationBox.setBounds(300,350,300,30);
		 acupationBox.setBackground(Color.white);
		add(acupationBox);
		
		 panBox=new JTextField();
		 panBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 panBox.setBounds(300,400,300,30);
		add(panBox);
		
		
		
		 adharBox=new JTextField();
		 adharBox.setFont(new Font("Ralway",Font.ITALIC,15));
		 adharBox.setBounds(300,450,300,30);
		add(adharBox);

		
		//setizenShip,Yes
		seniorBox1=new JRadioButton("YES");
		seniorBox1.setBounds(300,500,80,30);
		seniorBox1.setBackground(Color.white);
		add(seniorBox1);
		
		//setizenShip,NO
		seniorBox2=new JRadioButton("NO");
		seniorBox2.setBounds(400,500,80,30);
		seniorBox2.setBackground(Color.white);
		add(seniorBox2);
		
		//Group of Yes and No
		 seniorGroup=new ButtonGroup();
		 seniorGroup.add(seniorBox1);
		 seniorGroup.add(seniorBox2);
		
		
		
		//Account Existing, YES
		 accountyes=new JRadioButton("YES");
		 accountyes.setBounds(300,550,80,30);
		 accountyes.setBackground(Color.white);
		add(accountyes);
				
		//Account Existing, no
		accountno=new JRadioButton("NO");
		accountno.setBounds(400,550,90,30);
		accountno.setBackground(Color.white);
		add(accountno);
				
		//Group of yes and no
		accountGroup=new ButtonGroup();
		accountGroup.add(accountyes);
		accountGroup.add(accountno);
		
		
		 next=new JButton("Next");
		next.setBackground(Color.BLUE);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway",Font.BOLD,20));
		next.setBounds(520,700,80,30);
		next.addActionListener(this);
		add(next);
		
		
		back=new JButton("Back");
		back.setFont(new Font("Raleway",Font.BOLD,17));
		back.setBounds(100,700,80,30);
		back.setBackground(Color.MAGENTA);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		 cancel=new JButton("Cancel");
		cancel.setFont(new Font("Railway",Font.BOLD,17));
		cancel.setBounds(300,700,100,30);
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
//====================================================================================================		
		
		try
		{
			Comn conn=new Comn();
			
			
			ResultSet rs=conn.s.executeQuery("select * from singin2 where formNo='"+formNo+"'");
			
			
			while (rs.next())
			{
				
//			religionBox.setText(rs.getString("name"));
//			categoryBox.setText(rs.getString("fname"));
//			incomeBox.setText(rs.getString("email"));
//			educationBox.setText(rs.getString("adress"));
//			acupationBox.setText(rs.getString("city"));
			panBox.setText(rs.getString("PanNumber"));
			adharBox.setText(rs.getString("AdharNumber"));
//			seniorGroup.setText(rs.getString("dob"));
//			accountGroup.setText(rs.getString("pincode"));
				
			
				
			}
			
			
			
			
		}
		catch(Exception e )
		{
			System.out.println(e);
		}
		
		
		
//====================================================================================================
		
		
		
//======================= Page set up : ==================================
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ea) 
	{
		
		
		
		
		String sreligion=(String)religionBox.getSelectedItem();
		String scategory=(String) categoryBox.getSelectedItem();
		String sincome=(String) incomeBox.getSelectedItem();
		String seducation=(String)educationBox.getSelectedItem();
		String sacupation=(String) acupationBox.getSelectedItem();
		String span=panBox.getText();
		String sadhar=adharBox.getText();
//-------------------------------------------------------------------------------	
		String setizenShip=null;
		if(seniorBox1.isSelected())
		{
			setizenShip="YES";
		}
		else if(seniorBox2.isSelected())
		{
			setizenShip="NO";
		}
//-------------------------------------------------------------------------------	
		String ACCEX=null;
		if(accountyes.isSelected())
		{
			ACCEX="YES";
		}
		else if(accountno.isSelected())
		{
			ACCEX="NO";
		}
		
		
//---------------------------------------------------------------------------------
		if(ea.getSource()==cancel)
		{
			System.exit(0);
		}
		else if(ea.getSource()==back)
		{
			setVisible(false);
			new SigninOneModify(formNo).setVisible(true);
		}
		
		else if(ea.getSource()==next)
		{
			
			
			try
			{
				if(sreligion.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Religion Is Reaqied");
				}
				else if(scategory.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Category Is Reaqied");
				}
				else if(sincome.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Income Is Reaqied");
				}
				else if(seducation.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Education Is Reaqied");
				}
				else if(sacupation.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Accupation Is Reaqied");
				}
				else if(span.equals(""))
				{
					JOptionPane.showMessageDialog(null,"PAN Number Is Reaqied");
				}
				else if(sadhar.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Adhar Number Is Reaqied");
				}
				
				
//			else if(setizenShip.equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"Sitizen Is Reaqied");
//			}
//			else if(ACCEX.equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"Account Exicution Box Is Reaqied");
//			}
				
				
//=============================Insert INTO SQL Data Base This All Values========================================
				else
				{
					Comn conn=new Comn();
					
					
					String query="update singin2 set PanNumber='"+span+"',AdharNumber='"+sadhar+"',Religion='"+sreligion+"',Category='"+scategory+"',Income='"+sincome+"',Education='"+seducation+"',Acupation='"+sacupation+"' where formNo='"+formNo+"'" ;
					conn.s.executeUpdate(query);

					setVisible(false);
					
					new SignInThree(formNo).setVisible(true);
					
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		
	}

	public static void main(String[] args) 
	{
		new SignIn_Two_Modify("");
	}

}

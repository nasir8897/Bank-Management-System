package Bank_Management;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame 
{
	
	String pinnumber;
	
	MiniStatement(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setLayout(null);
		setTitle("Mini Statement");
		
		
		JLabel text=new JLabel();
		
		add(text);
		
		JLabel balence=new JLabel();
		balence.setBounds(20,600,400,30);
		balence.setFont(new Font("Raleway",Font.BOLD,15));
		balence.setForeground(Color.DARK_GRAY);
		add(balence);
		
		JLabel head=new JLabel("State Bank Of India");
		head.setFont(new Font("Raleway",Font.LAYOUT_NO_LIMIT_CONTEXT,20));
		head.setForeground(Color.RED);
		head.setBounds(150,20,200,30);
		add(head);
		
		JLabel head1=new JLabel("Mini Statement");
		head1.setFont(new Font("Raleway",Font.LAYOUT_NO_LIMIT_CONTEXT,15));
		head1.setForeground(Color.BLACK);
		head1.setBounds(180,50,200,30);
		add(head1);
		
		
		JLabel card=new JLabel();
		card.setBounds(20,100,300,30);
		card.setFont(new Font("Raleway",Font.BOLD,15));
		card.setForeground(Color.DARK_GRAY);
		add(card);
		
		//JTable ta=new JTable();
		
		JTable mini=new JTable();
		mini.setBounds(20,150,400,420);
		//mini.setBackground(Color.BLUE);
		add(mini);
		
		try
		{
			Comn conn=new Comn();
			ResultSet rs=conn.s.executeQuery("select * from longin where PinNumber='"+pinnumber+"'");
			ResultSetMetaData rdms=rs.getMetaData();
			DefaultTableModel model = null;
			
			
			int col=rdms.getColumnCount();
			String[] colName=new String[col];
			for(int i=0;i<col;i++)
			{
				colName[i]=rdms.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
		try
		{
			Comn conn=new Comn();
			ResultSet rs=conn.s.executeQuery("select * from longin where PinNumber='"+pinnumber+"'");
			
			while(rs.next())
			{
				card.setText("Card Number: "+rs.getString("CardNumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("CardNumber").substring(12));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try 
		
		{
			Comn conn=new Comn();
			int bal=0;
			ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next())
			{
				//mini.setText (mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br> <html>" );			
				
				if(rs.getString("type").equals("Deposit"))
				{
					bal += Integer.parseInt(rs.getString("Amount"));
				}
				else 
				{
					bal -= Integer.parseInt(rs.getString("Amount"));
				}
				
				
			}
			balence.setText("Your Current Account Balence Is Rs "+bal+".00/-");
			
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		setSize(500,800);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		
	}
	
	private void setTitel() 
	{
		
	}

	public static void main(String args [])
	{
		new MiniStatement("");
	}

}

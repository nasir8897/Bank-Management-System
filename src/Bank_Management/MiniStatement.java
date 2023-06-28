package Bank_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame implements ActionListener
{
	
	String pinnumber;
	JButton exit;
	
	MiniStatement(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setLayout(null);
		setTitle("Mini Statement");
		setUndecorated(true);
		
		
		ImageIcon img=new ImageIcon(this.getClass().getResource(""));
		JLabel imglabel=new JLabel();
		imglabel.setIcon(img);
		imglabel.setBounds(0,0,800,500);
		getContentPane().add(imglabel);
		
		JLabel balence=new JLabel();
		balence.setBounds(50,400,400,30);
		balence.setFont(new Font("Raleway",Font.BOLD,15));
		balence.setForeground(Color.DARK_GRAY);
		imglabel.add(balence);
		
		JLabel head=new JLabel("Bank Of ABC");
		head.setFont(new Font("Raleway",Font.BOLD,20));
		head.setForeground(Color.RED);
		head.setBounds(320,20,200,30);
		imglabel.add(head);
		
		JLabel head1=new JLabel("Mini Statement");
		head1.setFont(new Font("Raleway",Font.BOLD,15));
		head1.setForeground(Color.BLACK);
		head1.setBounds(330,50,200,30);
		imglabel.add(head1);
		
		
		JLabel card=new JLabel();
		card.setBounds(50,100,300,30);
		card.setFont(new Font("Raleway",Font.BOLD,15));
		card.setForeground(Color.DARK_GRAY);
		imglabel.add(card);
		
		 exit=new JButton("Exit");
		exit.setBounds(650,400,80,30);
		exit.setFont(new Font("Ralway",Font.BOLD,15));
		exit.setBackground(Color.MAGENTA);
		exit.addActionListener(this);
//		exit.setBorder(null);
		imglabel.add(exit);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 160, 700, 200);
		imglabel.add(scrollPane);
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma",Font.BOLD,10));
		table.setBackground(Color.WHITE);
//		table.setForeground(Color.RED);
		scrollPane.setViewportView(table);
		DefaultTableModel model=(DefaultTableModel) table.getModel(); 
		
//============================================ 		Table Statement		===========================================================================		
		
		try
		{
			Comn conn=new Comn();
			//ResultSet rs=conn.s.executeQuery("select * from longin where PinNumber='"+pinnumber+"'");
			String query="select * from bank where pin= '"+pinnumber+"' ";
			ResultSet rs=conn.s.executeQuery(query);
			ResultSetMetaData rdms=rs.getMetaData();
			
			
			int col=rdms.getColumnCount();
			String[] colName=new String[col];
			for(int i=0;i<col;i++)
			{
				colName[i]=rdms.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
			}
			
			String PIN,date,type,Amount;
			while(rs.next())
			{
				PIN=rs.getString(1);
				date=rs.getString(2);
				type=rs.getString(3);
				Amount=rs.getString(4);
						
				String [] row= {PIN,date,type,Amount};
				model.addRow(row);
			}
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
//============================================================  	Card Number  	=====================================================================
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
		
//========================================================	  Balence		==================================================================		
		
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
		
		
		setSize(800,500);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		
	}
	
	

	public static void main(String args [])
	{
		new MiniStatement("");
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==exit)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

}

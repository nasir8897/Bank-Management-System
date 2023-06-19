package Bank_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class MiniStatement1 extends JFrame 
{

	private JPanel contentPane;
	private JTextField Balence;
	private JTable table;
	private JScrollPane scrollPane;


	
	public MiniStatement1(String pinnumber) 
	{
		
		
		JLabel heading = new JLabel("State Bank Of India");
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		heading.setBounds(172, 10, 224, 30);
		contentPane.add(heading);
		
		JLabel ministatement = new JLabel("Mini Statement");
		ministatement.setFont(new Font("Tahoma", Font.BOLD, 17));
		ministatement.setBounds(216, 50, 148, 21);
		contentPane.add(ministatement);
		
		JLabel accnumber = new JLabel();
		accnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		accnumber.setBounds(36, 111, 533, 30);
		contentPane.add(accnumber);
				
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Balence = new JTextField();
		Balence.setFont(new Font("Tahoma", Font.BOLD, 15));
		Balence.setToolTipText("20");
//		Balence.setText("Account Balence:");
		Balence.setBounds(36, 465, 533, 30);
		contentPane.add(Balence);
		Balence.setColumns(10);
		
		
		
//====================================================================================================		
		try 
		
		{
			Comn conn=new Comn();
			String query="select * from bank";
			
			
			
			
			
			
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 131, 533, 290);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
//===========================================================================================================		
//		try
//		{
//			Comn conn=new Comn();
//			ResultSet rs=conn.s.executeQuery("select * from longin where PinNumber='"+pinnumber+"'");
//			
//			while(rs.next())
//			{
//				accnumber.setText("Card Number: "+rs.getString("CardNumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("CardNumber").substring(12));
//				
//			}
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		
		
	}
	
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MiniStatement1 frame = new MiniStatement1("");
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}

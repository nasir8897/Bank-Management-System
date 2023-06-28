
/*Data Base connection in 5 Steps There are
  1.Register the driver
  2.Create connectivity  
  3.Create Statement
  4.Execute Query
  5.Close Connection	*/


package Bank_Management;

import java.sql.*;

public class Comn
{
	//	2.Create Connection
	Connection c;
	//  3.Create Statment
	Statement s;
	public Comn()
	{
		try 
		{
		//	1.Regester the driveer	(It not use Becouse we have librarie{mysql-connector-java-8.0.28.jar} java is it self to pick where to pick classpath).
			//Class.forName(com.mysql.cj.jdbc.Driver);
			
		// connection ("URL","User Name","Pasword") it MySQL User name and Pasword,URL (By Default "jdbc:mysql://localhost:3360") IS same But Database Name is Mention 
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root","Nasir@8897");
		// 3.Create Statment
			s=c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
																																																																													
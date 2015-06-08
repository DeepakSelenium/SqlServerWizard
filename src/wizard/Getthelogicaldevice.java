package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Getthelogicaldevice extends Serverwizard{
	
	
	public static boolean GetDevice(String servername,String username,String password,String Database) throws SQLException
	{
		Connection conn = null;	
		String url ="jdbc:sqlserver://"+servername+";"+"databaseName"+"="+"master"+";"+"integratedSecurity=true";
		System.out.println("Printing url constructed "+url);
		System.out.println("Printing Database Name "+Database);
		System.out.println("Printing SQLSERVER Name "+servername);
		System.out.println("Printing SQLSERVER User Name "+username);
		System.out.println("Establishing connection with master database.....................");
		
		txtrConsoleOutput.append("Printing url constructed "+url+"\n");
		txtrConsoleOutput.append("Printing Database Name "+Database+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER Name "+servername+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER User Name "+username+"\n");
		txtrConsoleOutput.append("Establishing connection with master database..............."+"\n");
		
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connection established......................");
			txtrConsoleOutput.append("Connection established................"+"\n");
			System.out.println("Getting logical devices.....................");
			txtrConsoleOutput.append("Getting logical devices..............."+"\n");
			
			Statement stmt3=conn.createStatement();
			ResultSet rs3=stmt3.executeQuery("select * from sys.backup_devices;"+"select 0");
						
			while(rs3.next())
			{
				System.out.println("Device Logical Name"+" "+rs3.getString("name")+"    "+"Type"+" "+rs3.getString("type")+"    "+"Device Type"+" "+rs3.getString("type_desc")+"   "+"Device Physical Name"+" "+rs3.getString("physical_name"));
				txtrConsoleOutput.append("Device Logical Name"+" "+rs3.getString("name")+"    "+"Type"+" "+rs3.getString("type")+"    "+"Device Type"+" "+rs3.getString("type_desc")+"   "+"Device Physical Name"+" "+rs3.getString("physical_name")+"\n");
				
			}
			System.out.println("logical devices information displayed");
			txtrConsoleOutput.append("logical devices information displayed"+"\n");
			
			conn.close();
			return true;
			}	
			catch(Exception e)
			{
				System.out.println("Connection could not be established...................");
				txtrConsoleOutput.append("Connection could not be established............."+"\n");
				System.out.println("Failed to retrieve Logical devices  ..................");
				txtrConsoleOutput.append("Failed to retrieve Logical devices  ............"+"\n");
				System.out.println(e.fillInStackTrace());	
				txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
			return false;

			}


}

package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Setthelogicaldevice extends Serverwizard {
	
	public static boolean SetDevice(String servername,String username,String password,String Database,String devicename,String path ) throws SQLException
	{
		Connection conn = null;	
		String url ="jdbc:sqlserver://"+servername+";"+"databaseName"+"="+"master"+";"+"integratedSecurity=true";
		System.out.println("Printing url constructed "+url);
		System.out.println("Printing Database Name "+Database);
		System.out.println("Printing SQLSERVER Name "+servername);
		System.out.println("Printing SQLSERVER User Name "+username);
		System.out.println("Printing Logical Device Path "+path);
		System.out.println("Printing Logical Device Name "+devicename);
		System.out.println("Establishing connection with master database.....................");
		
		txtrConsoleOutput.append("Printing url constructed "+url+"\n");
		txtrConsoleOutput.append("Printing Database Name "+Database+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER Name "+servername+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER User Name "+username+"\n");
		txtrConsoleOutput.append("Printing Logical Device Path "+path+"\n");
		txtrConsoleOutput.append("Printing Logical Device Name "+devicename+"\n");
		txtrConsoleOutput.append("Establishing connection with master database....................."+"\n");
		
		
		
		
		
		
		
		
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
				
			System.out.println("Connection established......................");
			txtrConsoleOutput.append("Connection established................"+"\n");
			System.out.println("Defining a Logical Backup Device for a Disk File....................");
			txtrConsoleOutput.append("Defining a Logical Backup Device for a Disk File.............."+"\n");
			
			
			Statement stmt3=conn.createStatement();
			ResultSet rs3=stmt3.executeQuery("EXEC sp_addumpdevice 'disk',"+"'"+devicename+"'"+","+"'"+path+"'"+";"+"select 0");
			System.out.println("Logical Backup Device for a Disk File has been created at (PHYSICAL NAME) "+path+" withname (LOGICAL NAME) "+devicename);
			txtrConsoleOutput.append("Logical Backup Device for a Disk File has been created at (PHYSICAL NAME) "+path+" withname (LOGICAL NAME) "+devicename+"\n");
			conn.close();
			return true;
			}	
			catch(Exception e)
			{
				System.out.println("Connection could not be established..................");
				txtrConsoleOutput.append("Connection could not be established............"+"\n");
				System.out.println("Logical device could not be created..................");
				txtrConsoleOutput.append("Logical device could not be created............"+"\n");
				System.out.println(e.fillInStackTrace());
				txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
			return false;

			}

}

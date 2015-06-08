package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection extends Serverwizard {

	
	public static boolean DBConnection(String servername,String username,String password) throws SQLException
	{
		Connection conn = null;		
		String url ="jdbc:sqlserver://"+servername+";"+"databaseName=master"+";"+"integratedSecurity=true";
		System.out.println("Printing url constructed "+url);
		System.out.println("Printing SQLSERVER Name "+servername);
		System.out.println("Printing SQLSERVER User Name "+username);
		
		txtrConsoleOutput.append("Printing url constructed "+url+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER Name "+servername+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER User Name "+username+"\n");
				
		System.out.println("Establishing connection with master database..................................");
		txtrConsoleOutput.append("Establishing connection with master database............................"+"\n");
		try{
				
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn= DriverManager.getConnection(url,username,password);
				
			System.out.println("Connection established....................................................");
			txtrConsoleOutput.append("Connection established.............................................."+"\n");
			
			conn.close();
		return true;	
		}
			catch(Exception e)
			{
			System.out.println("Connection could not be established...................");
			txtrConsoleOutput.append("Connection could not be established............."+"\n");
			System.out.println(e.fillInStackTrace());	
			txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
		return false;
	}
	
}

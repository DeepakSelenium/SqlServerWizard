package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDatabaserecoverymodelinfo extends Serverwizard{
	
	public static boolean GetRecoveryModel(String servername,String username,String password,String Database ) throws SQLException
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
		txtrConsoleOutput.append("Establishing connection with master database....................."+"\n");
		
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
				
			System.out.println("Connection established.......................");
			txtrConsoleOutput.append("Connection established................."+"\n");
			System.out.println("Fetching recovery model information..........");
			txtrConsoleOutput.append("Fetching recovery model information...."+"\n");
			
			Statement stmt2=conn.createStatement();
			ResultSet rs2=stmt2.executeQuery("SELECT name, recovery_model_desc FROM sys.databases WHERE name="+"'"+Database+"'"+";"+"select 0");
			System.out.println("Database recovery model-----------------------");
			txtrConsoleOutput.append("Database recovery model-----------------"+"\n");
			while(rs2.next())
			{
				System.out.println("Database name"+" "+rs2.getString("name")+"    "+"Recovery model information"+" "+rs2.getString("recovery_model_desc"));
				txtrConsoleOutput.append("Database name"+" "+rs2.getString("name")+"    "+"Recovery model information"+" "+rs2.getString("recovery_model_desc")+"\n");
			}
			
			conn.close();
			return true;
			}	
			catch(Exception e)
			{
				System.out.println("Connection could not be established..................");
				txtrConsoleOutput.append("Connection could not be established............"+"\n");
				System.out.println("Could not show recovery model information............");
				txtrConsoleOutput.append("Could not show recovery model information......"+"\n");
				System.out.println(e.fillInStackTrace());	
				txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
			return false;

			}

}

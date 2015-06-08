package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetDatabaserecoverymodelinfo extends Serverwizard{
	
	public static boolean SetRecoveryModel(String servername,String username,String password,String Database ) throws SQLException
	{
		Connection conn = null;	
		String url ="jdbc:sqlserver://"+servername+";"+"databaseName"+"="+"master"+";"+"integratedSecurity=true";
		System.out.println("Printing url constructed "+url);
		System.out.println("Printing Database Name "+Database);
		System.out.println("Printing SQLSERVER Name "+servername);
		System.out.println("Printing SQLSERVER User Name "+username);
		System.out.println("Establishing connection with master database....");
		
		
		txtrConsoleOutput.append("Printing url constructed "+url+"\n");
		txtrConsoleOutput.append("Printing Database Name "+Database+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER Name "+servername+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER User Name "+username+"\n");
		txtrConsoleOutput.append("Establishing connection with master database.."+"\n");
		
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
				
			System.out.println("Connection established......................");
			txtrConsoleOutput.append("Connection established................"+"\n");
			System.out.println("Setting recovery model information..........");
			txtrConsoleOutput.append("Setting recovery model information...."+"\n");
			
			Statement stmt2=conn.createStatement();
			ResultSet returnvalue =stmt2.executeQuery("USE "+Database+";"+"Select 0");
			System.out.println("Select database value "+returnvalue);
			txtrConsoleOutput.append("Select database value "+returnvalue+"\n");
			System.out.println("Database selected...........................");
			txtrConsoleOutput.append("Database selected......................"+"\n");			
			
			Statement stmt3=conn.createStatement();
			int returnvalueafterset =stmt3.executeUpdate("ALTER DATABASE "+Database+" SET RECOVERY FULL ;");
			System.out.println("Return value after set "+returnvalueafterset);
			txtrConsoleOutput.append("Return value after set "+returnvalueafterset+"\n");
			System.out.println("Recovery model has been set to full for database "+Database);
			txtrConsoleOutput.append("Recovery model has been set to full for database "+Database+"\n");
			conn.close();
			return true;
			}	
			catch(Exception e)
			{
				System.out.println("Connection could not be established...................");
				txtrConsoleOutput.append("Connection could not be established............."+"\n");
				System.out.println("Could not set recovery model information..............");
				txtrConsoleOutput.append("Could not set recovery model information........"+"\n");
				System.out.println(e.fillInStackTrace());	
				txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
			return false;
			}

}
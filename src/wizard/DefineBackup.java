package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DefineBackup extends Serverwizard{
	
	public static boolean VerityBackup(String servername,String username,String password,String Database,String devicename ,String path) throws SQLException
	{
		Connection conn = null;
		String url ="jdbc:sqlserver://"+servername+";"+"databaseName"+"="+"master"+";"+"integratedSecurity=true";
		System.out.println("Printing url constructed "+url);
		System.out.println("Printing Database Name "+Database);
		System.out.println("Printing SQLSERVER Name "+servername);
		System.out.println("Printing SQLSERVER User Name "+username);
		System.out.println("Printing Logical Device Name "+devicename);
		System.out.println("Establishing connection with master database..........................");
		
		txtrConsoleOutput.append("Printing url constructed "+url+"\n");
		txtrConsoleOutput.append("Printing Database Name "+Database+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER Name "+servername+"\n");
		txtrConsoleOutput.append("Printing SQLSERVER User Name "+username+"\n");
		txtrConsoleOutput.append("Printing Logical Device Name "+devicename+"\n");
		txtrConsoleOutput.append("Establishing connection with master database....................."+"\n");
		
				
		try{
				
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
				
			System.out.println("Connection established............................");
			txtrConsoleOutput.append("Connection established......................"+"\n");
			System.out.println("Constructed database backup path............ "+path);
			txtrConsoleOutput.append("Constructed database backup path...... "+path+"\n");
			
		
		try{	
			
			Statement stmt4=conn.createStatement();
			System.out.println("Taking Database backup.......................");
			txtrConsoleOutput.append("Taking Database backup................."+"\n");
			System.out.println("Performing full backup of database "+Database);
			txtrConsoleOutput.append("Performing full backup of database "+Database+"\n");
			ResultSet rs4=stmt4.executeQuery("BACKUP DATABASE "+Database+" TO DISK "+" "+"="+" "+"'"+path+"'"+"WITH FORMAT,MEDIANAME"+"="+"'"+devicename+"'"+","+"NAME = 'Full Backup of Verity';"+"select 0");
			System.out.println("Backup created successfully");
			txtrConsoleOutput.append("Backup created successfully"+"\n");
			
			
			Statement stmt5=conn.createStatement();
			System.out.println("Taking Log backup.......................");
			txtrConsoleOutput.append("Taking Log backup................."+"\n");
			ResultSet rs5=stmt5.executeQuery("BACKUP LOG "+Database+" TO "+devicename+";"+"Select 0");
			System.out.println("Backup of log created successfully in Device "+devicename);
			txtrConsoleOutput.append("Backup of log created successfully in Device "+devicename+"\n");
			
			conn.close();
			return true;
			}catch(Exception e)
			{
				System.out.println("Backup operation failed..................");
				txtrConsoleOutput.append("Backup operation failed............"+"\n");
				System.out.println(e.fillInStackTrace());
				txtrConsoleOutput.append(e.fillInStackTrace().toString()+"\n");
			}
				
		}
			catch(Exception e)
			{
			System.out.println("Connection could not be established..................");
			txtrConsoleOutput.append("Connection could not be established............"+"\n");
			System.out.println(e.fillInStackTrace());	
			txtrConsoleOutput.append("Exception received"+e.fillInStackTrace().toString()+"\n");
			}
		/*finally
			{
			System.out.println("===============Closing connection with DB==============");
			conn.close();
			}*/
		return false;
	}
}

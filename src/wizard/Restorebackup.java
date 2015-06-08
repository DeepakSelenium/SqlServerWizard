package wizard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Restorebackup extends Serverwizard{
	
	public static boolean VerityRestore(String servername,String username,String password,String Database,String path) throws SQLException
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
				
			System.out.println("Connection established......................");
			txtrConsoleOutput.append("Connection established......................"+"\n");
			System.out.println("Constructed restore backup path...... "+path);
			txtrConsoleOutput.append("Constructed restore backup path...... "+path+"\n");
			
		
		try{	
			
			Statement stmt4=conn.createStatement();
			System.out.println("Restoring Database "+Database +" .......................");
			txtrConsoleOutput.append("Restoring Database "+Database +" ................."+"\n");
			System.out.println("Restoring full backup with REPLACE option for backedup log ");
			txtrConsoleOutput.append("Restoring Database "+Database +" ................."+"\n");
			ResultSet rs4=stmt4.executeQuery("RESTORE DATABASE "+Database+" FROM DISK"+"="+"'"+path+"'"+" WITH "+" REPLACE "+";"+"select 0");
			System.out.println("Restore operation completed successfully");
			txtrConsoleOutput.append("Restore operation completed successfully"+"\n");
			
			conn.close();
			return true;
			}catch(Exception e)
			{
				System.out.println("Restore operation failed..................");
				txtrConsoleOutput.append("Restore operation failed............"+"\n");
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

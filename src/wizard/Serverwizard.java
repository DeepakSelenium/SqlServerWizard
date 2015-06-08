package wizard;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.awt.Color;

public class Serverwizard {

	private JFrame frame;
	private JFrame frmManualTesting;
	private JTextField txtSqlServerWindows;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField_2;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JPasswordField passwordField;
	private JPanel panel_3;
	private JButton button;
	private JButton button_1;
	public static JTextArea txtrConsoleOutput =new JTextArea();
	//public static JTextArea txtrConsoleOutput =null;
	
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serverwizard window = new Serverwizard();
					window.frmManualTesting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Serverwizard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManualTesting = new JFrame();
		frmManualTesting.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frmManualTesting.setFont(new Font("Arial", Font.BOLD, 10));
		frmManualTesting.setTitle("DHANUSH");
		frmManualTesting.getContentPane().setBackground(SystemColor.activeCaption);
		frmManualTesting.setBounds(100, 100, 450, 300);
		frmManualTesting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManualTesting.getContentPane().setLayout(null);
		frmManualTesting.setResizable(false);
		frmManualTesting.setSize(900,700);
		
		JTextArea txtrWelcomeToSqlserver = new JTextArea();
		txtrWelcomeToSqlserver.setEditable(false);
		txtrWelcomeToSqlserver.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		txtrWelcomeToSqlserver.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtrWelcomeToSqlserver.setText("Welcome to SQL Server2012 backup wizard");
		txtrWelcomeToSqlserver.setBounds(284, 33, 287, 22);
		frmManualTesting.getContentPane().add(txtrWelcomeToSqlserver);
		
		txtSqlServerWindows = new JTextField();
		txtSqlServerWindows.setEditable(false);
		txtSqlServerWindows.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		txtSqlServerWindows.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtSqlServerWindows.setText("SQL Server Windows authentication mechanism");
		txtSqlServerWindows.setBounds(284, 88, 287, 20);
		frmManualTesting.getContentPane().add(txtSqlServerWindows);
		txtSqlServerWindows.setColumns(10);
		
		panel = new JPanel();
		panel.setToolTipText("The Server Name is that name through which you connect to your server using SQL Server Management studio");
		panel.setForeground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Server Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 166, 211, 43);
		frmManualTesting.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 10));
		textField.setForeground(SystemColor.textHighlightText);
		textField.setBackground(SystemColor.textHighlight);
		textField.setBounds(6, 16, 195, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setToolTipText("Database name is name of your database which exists with in SQL Server. Here it is Verity,because most of the time you have to use it.Otherwise you can specify any existing database which exists with in SQL Server.By default it will connect to master database.For specific operations except \"database connection\" and \"online database information\" please specify database name also");
		panel_1.setBorder(new TitledBorder(null, "Database Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(35, 268, 211, 43);
		frmManualTesting.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 10));
		textField_1.setForeground(SystemColor.textHighlightText);
		textField_1.setBackground(SystemColor.textHighlight);
		textField_1.setBounds(6, 16, 195, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setToolTipText("User name means user name of your windows machine when you are using Windows authentication mechanism for SQL Server");
		panel_2.setBorder(new TitledBorder(null, "User Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(35, 380, 211, 43);
		frmManualTesting.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.BOLD, 10));
		textField_2.setForeground(SystemColor.textHighlightText);
		textField_2.setBackground(SystemColor.textHighlight);
		textField_2.setBounds(6, 16, 195, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Database backup");
		btnNewButton.setToolTipText("This will take the backup of entered database in a file on disk with .bak extension.Make sure that you have proper backup logical device ready with you in disk.It will take the full backup of database alog with transaction log.");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();

             	try {
					Getthelogicaldevice.GetDevice(servername, username, password, databasename);
					JOptionPane.showMessageDialog(frame, "Please go and see available backup devices at console");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String devicename=JOptionPane.showInputDialog("Use disk backup device(LOGICAL NAME)").trim();
				final JFileChooser fc = new JFileChooser();
	            fc.showSaveDialog(frame);
                File selFile = fc.getSelectedFile();
             	String path =selFile.getAbsolutePath();

             	try {
					if(DefineBackup.VerityBackup(servername, username, password, databasename, devicename, path)){
						JOptionPane.showMessageDialog(frame, "Backup completed successfully");
					}else{
						JOptionPane.showMessageDialog(frame, "Backup operation failed");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton.setBounds(316, 522, 225, 23);
		frmManualTesting.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Database restore");
		btnNewButton_1.setToolTipText("It will restore the database using fullbackup performed on logical backup device and will restore the log with replace option.Note-before restoring please stop the services used by application and do not run application's GUI");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				JOptionPane.showMessageDialog(frame, "Please stop all services related to application");
				JOptionPane.showMessageDialog(frame, "Please close UI of application if running");
				JOptionPane.showMessageDialog(frame, "Please select backup file");
				
				final JFileChooser fc = new JFileChooser();
	            fc.showOpenDialog(frame);
                File selFile = fc.getSelectedFile();
             	String path =selFile.getAbsolutePath();
             	
				
				
				try {
					if(Restorebackup.VerityRestore(servername, username, password, databasename, path)){
						JOptionPane.showMessageDialog(frame, "Restore completed successfully");	
					}else{
						JOptionPane.showMessageDialog(frame, "Restore failed");	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton_1.setBounds(316, 590, 225, 23);
		frmManualTesting.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Database connection test");
		btnNewButton_2.setToolTipText("It will connect to master database using windows authentication mechanism");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				
				System.out.println(servername);
				System.out.println(databasename);
				System.out.println(username);
				System.out.println(password);
													
				try {
					if(Databaseconnection.DBConnection(servername, username, password)){
						JOptionPane.showMessageDialog(frame, "Connection established");
				}else{
					JOptionPane.showMessageDialog(frame, "Connection failed");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton_2.setBounds(35, 590, 211, 23);
		frmManualTesting.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("List of available online database");
		btnNewButton_3.setToolTipText("It will connect to master database and will display all online database with in SQL Server 2012.");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				
				
				try {
					if(AvailableDatabases.AvailableOnlineDatabase(servername, username, password)){
						JOptionPane.showMessageDialog(frame, "List operation completed successfully");
						
					}else{
						JOptionPane.showMessageDialog(frame, "List operation failed");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(316, 166, 225, 23);
		frmManualTesting.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Get recovery information");
		btnNewButton_4.setToolTipText("It will show you the recovery model information for entered database.");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				
				try {
					if(GetDatabaserecoverymodelinfo.GetRecoveryModel(servername, username, password, databasename)){
						JOptionPane.showMessageDialog(frame, "Recovery model information displayed");
					}else{
						JOptionPane.showMessageDialog(frame, "Recovery model information not retrieved");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(316, 236, 225, 23);
		frmManualTesting.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Set logical disk device");
		btnNewButton_5.setToolTipText("It will create the Logical backup device on Disk. For logical device please visit\r\nhttp://technet.microsoft.com/en-us/library/ms189109.aspx");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				String devicename=JOptionPane.showInputDialog("Enter disk backup device(LOGICAL NAME)").trim();
				final JFileChooser fc = new JFileChooser();
	            fc.showSaveDialog(frame);
                File selFile = fc.getSelectedFile();
             	String path =selFile.getAbsolutePath();
								
				try {
					if(Setthelogicaldevice.SetDevice(servername, username, password, databasename, devicename,path)){
						JOptionPane.showMessageDialog(frame, "Setting disk backup device operation completed");	
					}else{
						JOptionPane.showMessageDialog(frame, "Setting disk backup device operation failed");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(316, 376, 225, 23);
		frmManualTesting.getContentPane().add(btnNewButton_5);
		
		panel_3 = new JPanel();
		panel_3.setToolTipText("Password name means password of your windows machine when you are using Windows authentication mechanism for SQL Server");
		panel_3.setBorder(new TitledBorder(null, "Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(35, 480, 211, 43);
		frmManualTesting.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.BOLD, 10));
		passwordField.setForeground(SystemColor.textHighlightText);
		passwordField.setBackground(SystemColor.textHighlight);
		passwordField.setBounds(6, 16, 199, 20);
		panel_3.add(passwordField);
		
		/*JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\Images\\Synerzip.jpg"));
		lblNewLabel.setBounds(170, 643, 240, 22);
		frmManualTesting.getContentPane().add(lblNewLabel);*/
		
		button = new JButton("Get logical disk devices");
		button.setToolTipText("It will show you all logical backup devices on disk which generally gets displayed under Server objects-->Backup devices ");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				
				try {
					if(Getthelogicaldevice.GetDevice(servername, username, password, databasename)){
						JOptionPane.showMessageDialog(frame, "All logical disk devices displayed");
					}else{
						JOptionPane.showMessageDialog(frame, "All logical disk devices retrievel failed");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD, 10));
		button.setBounds(316, 443, 225, 23);
		frmManualTesting.getContentPane().add(button);
		
		button_1 = new JButton("Set recovery information");
		button_1.setToolTipText("It will set FULL as a recovery model for entered database. For recovery model please visit\r\nhttp://msdn.microsoft.com/en-us/library/ms189275.aspx");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String servername = textField.getText().trim();
				String databasename = textField_1.getText().trim();
				String username = textField_2.getText().trim();
				String password = passwordField.getPassword().toString();
				
				try {
					if(SetDatabaserecoverymodelinfo.SetRecoveryModel(servername, username, password, databasename)){
						JOptionPane.showMessageDialog(frame, "Recovery model has been set");
					}else{
						JOptionPane.showMessageDialog(frame, "Recovery model has not been set");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Verdana", Font.BOLD, 10));
		button_1.setBounds(316, 306, 225, 23);
		frmManualTesting.getContentPane().add(button_1);
		txtrConsoleOutput.setBackground(Color.BLACK);
		
		
		txtrConsoleOutput.setText("CONSOLE OUTPUT:"+"\n");
		txtrConsoleOutput.setForeground(Color.GREEN);
		txtrConsoleOutput.setEditable(false);
		txtrConsoleOutput.setLineWrap(false);
		txtrConsoleOutput.getDocument();
		txtrConsoleOutput.setFont(new Font("Verdana", Font.BOLD, 10));
		txtrConsoleOutput.setBounds(612, 166, 233, 447);
		frmManualTesting.getContentPane().add(txtrConsoleOutput);
		
		JScrollPane sp = new JScrollPane(txtrConsoleOutput);
		sp.setBounds(612, 166, 233, 447);
		frmManualTesting.getContentPane().add(sp);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		
		
		
		
		
		
			
	}
}

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import sun.security.provider.DSAPublicKeyImpl;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Display_transaction {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public static String psid_selected;
	public static String tsid_selected;
	public static String cnid_selected;
	public static String empid_selected;
	public static String charges;
	public static String fid_plane;
	public static String departure;
	public static String arrival;
	public static String name;
	public static String cnid_employee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display_transaction window = new Display_transaction();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Display_transaction() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 20, 20, 20, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		frame.getContentPane().setBackground(my_color);
		
		JLabel lblName = new JLabel("Name of Employee who issued boarding pass");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		frame.getContentPane().add(lblName, gbc_lblName);
		lblName.setForeground(label_color);
		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		gbc_textField.ipadx=10;
		gbc_textField.ipady=10;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		JLabel lblTsid = new JLabel("TsID");
		GridBagConstraints gbc_lblTsid = new GridBagConstraints();
		gbc_lblTsid.insets = new Insets(0, 0, 5, 5);
		gbc_lblTsid.gridx = 1;
		gbc_lblTsid.gridy = 2;
		frame.getContentPane().add(lblTsid, gbc_lblTsid);
		lblTsid.setForeground(label_color);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.NONE;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		gbc_textField_1.ipadx=10;
		gbc_textField_1.ipady=10;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCharges = new JLabel("Charges");
		GridBagConstraints gbc_lblCharges = new GridBagConstraints();
		gbc_lblCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharges.gridx = 1;
		gbc_lblCharges.gridy = 3;
		frame.getContentPane().add(lblCharges, gbc_lblCharges);
		lblCharges.setForeground(label_color);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.NONE;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		gbc_textField_2.ipadx=10;
		gbc_textField_2.ipady=10;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmpid = new JLabel("Employee ID");
		GridBagConstraints gbc_lblEmpid = new GridBagConstraints();
		gbc_lblEmpid.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpid.gridx = 1;
		gbc_lblEmpid.gridy = 4;
		frame.getContentPane().add(lblEmpid, gbc_lblEmpid);
		lblEmpid.setForeground(label_color);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.NONE;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 4;
		gbc_textField_3.ipadx=10;
		gbc_textField_3.ipady=10;
		frame.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		GridBagConstraints gbc_lblDeparture = new GridBagConstraints();
		gbc_lblDeparture.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeparture.gridx = 1;
		gbc_lblDeparture.gridy = 5;
		frame.getContentPane().add(lblDeparture, gbc_lblDeparture);
		lblDeparture.setForeground(label_color);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.NONE;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		gbc_textField_4.ipadx=10;
		gbc_textField_4.ipady=10;
		frame.getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 1;
		gbc_lblDestination.gridy = 6;
		frame.getContentPane().add(lblDestination, gbc_lblDestination);
		lblDestination.setForeground(label_color);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.NONE;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 6;
		gbc_textField_5.ipadx=10;
		gbc_textField_5.ipady=10;
		frame.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnGetResult = new JButton("Get Result");
		btnGetResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Display_transaction.psid_selected=View_transaction_details.psid_choosen;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select * from transactions where psid=?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1,View_transaction_details.psid_choosen);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Display_transaction.tsid_selected=rs.getString(1);
						Display_transaction.empid_selected=rs.getString(2);
						Display_transaction.psid_selected=rs.getString(3);
						Display_transaction.charges=rs.getString(4);
						
						
					}
					
				}catch(Exception e){
					System.out.println("Some issue in extracting empis,tsid");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select fid,cnid from passengers where psid=?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1,Display_transaction.psid_selected );
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Display_transaction.fid_plane=rs.getString(1);
						Display_transaction.cnid_selected=rs.getString(2);
					}
				}catch(Exception e){
					System.out.println();
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select departure,arrival from flight_schedule where fid=?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1, Display_transaction.fid_plane);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Display_transaction.departure=rs.getString(1);
						Display_transaction.arrival=rs.getString(2);
					}
					
				}catch(Exception e){
					System.out.println("some error in last");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					PreparedStatement ps=null;
					final String query="select cnid from employees where empid=?";
					ps=conn.prepareStatement(query);
					ps.setString(1, Display_transaction.empid_selected);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Display_transaction.cnid_employee=rs.getString(1);
					}
					
					
				}catch(Exception e){
					System.out.println("Some error in extarcting empid of employee");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					PreparedStatement ps=null;
					final String query="select name from contact_details where cnid=?";
					ps=conn.prepareStatement(query);
					ps.setString(1,Display_transaction.cnid_employee);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Display_transaction.name=rs.getString(1);
					}
					
					
				}catch(Exception e){
					System.out.println();
				}
				
				textField.setText(Display_transaction.name);
				textField_1.setText(Display_transaction.tsid_selected);
				textField_2.setText(Display_transaction.charges);
				textField_3.setText(Display_transaction.empid_selected);
				textField_4.setText(Display_transaction.departure);
				textField_5.setText(Display_transaction.arrival);
				
			}
		});
		
		
		GridBagConstraints gbc_btnGetResult = new GridBagConstraints();
		gbc_btnGetResult.gridx = 3;
		gbc_btnGetResult.gridy = 8;
		frame.getContentPane().add(btnGetResult, gbc_btnGetResult);
		
		JButton btngomain = new JButton("Go To Main Menu");
		GridBagConstraints gbc_btngomain = new GridBagConstraints();
		gbc_btngomain.gridx = 3;
		gbc_btnGetResult.gridy = 9;
		frame.getContentPane().add(btngomain, gbc_btngomain);
		btngomain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class obj=new GUI_Class();
				frame.setVisible(false);
			}
		});
		
		
	}

}

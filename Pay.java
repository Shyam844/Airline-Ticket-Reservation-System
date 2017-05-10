import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;


public class Pay {

	private JFrame frame;
	private JFrame complete_transaction;
	private JTextField textField;
	private JTextField textField_1;
	public static String FID_choosen;	//plane FID choosen
	public static String DID_choosen;	//discount id choosen
	public static int  netfare_FID_choosen;
	public static int amount_DID;
	public static int cid_of_person;
	public static int max_cnid;				//max cnid in table
	public static int net_display;			//string to display in net_display box
	public static int max_psid;				//max passenger id in the table
	public static int amount_to_pay;		//amount to pay
	public static int boarding_employees;	//no. of boarding employees
	public static int boarding_empid;		//employee issuing boarding pass
	public static int max_tsid;				// max transaction id in table
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay window = new Pay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pay() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}
	
	public void create_pop_up(){
		complete_transaction=new JFrame("Transaction Complete");
		Box box=Box.createVerticalBox();
		JLabel l1=new JLabel("Your transaction is complete and your details are recorded in databse");
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(l1);
		JButton main_menu_button=new JButton("Go to Main menu");
		main_menu_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		main_menu_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GUI_Class obj=new GUI_Class();
				complete_transaction.setVisible(false);
				frame.setVisible(false);
			}
		});
		box.add(main_menu_button);
		complete_transaction.add(box,BorderLayout.CENTER);
		complete_transaction.setSize(600, 150);
		complete_transaction.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblDiscountCoupan = new JLabel("Discount Coupon");
		GridBagConstraints gbc_lblDiscountCoupan = new GridBagConstraints();
		lblDiscountCoupan.setForeground(label_color);
		gbc_lblDiscountCoupan.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscountCoupan.gridx = 0;
		gbc_lblDiscountCoupan.gridy = 0;
		frame.getContentPane().add(lblDiscountCoupan, gbc_lblDiscountCoupan);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		gbc_textField.ipadx = 10;
		gbc_textField.ipady = 10;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblReducedCharges = new JLabel("Reduced Charges");
		GridBagConstraints gbc_lblReducedCharges = new GridBagConstraints();
		lblReducedCharges.setForeground(label_color);
		gbc_lblReducedCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblReducedCharges.gridx = 0;
		gbc_lblReducedCharges.gridy = 1;
		frame.getContentPane().add(lblReducedCharges, gbc_lblReducedCharges);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.NONE;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		gbc_textField_1.ipadx = 10;
		gbc_textField_1.ipady = 10;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		GridBagConstraints gbc_btnPay = new GridBagConstraints();
		gbc_btnPay.gridx = 1;
		gbc_btnPay.gridy = 5;
		frame.getContentPane().add(btnPay, gbc_btnPay);
		btnPay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select ctid from countries where country_name =?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1, Booking_Details.customer_country);
					ResultSet rs=ps.executeQuery();

					while(rs.next()){
						Pay.cid_of_person=rs.getInt(1);
					}
					
					
				}catch(Exception e){
					System.out.println("problem in pay key");
					
					
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select max(cnid) from contact_details where cnid<100";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Pay.max_cnid=rs.getInt(1);
					}
					
					
				}catch(Exception e){
					System.out.println("Cant do shit");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query ="insert into contact_details values (?,?,?,?,?,?)";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setInt(1,Pay.max_cnid+1);
					ps.setInt(2, Pay.cid_of_person);
					ps.setString(3,Booking_Details.customer_email );
					ps.setString(4, Booking_Details.customer_tel);
					ps.setString(5,Booking_Details.customer_street);
					ps.setString(6,Booking_Details.customer_name);
					System.out.println(ps);
					System.out.println("steve ");
					//ps.ex(query);
					ps.executeUpdate();
					System.out.println("malcom");
					
				}catch(Exception e){
					System.out.println("Dick Grayson");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select max(psid) from passengers";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Pay.max_psid=rs.getInt(1);
						
					}
				}catch(Exception e){
					System.out.println("Passenger acessing error");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root","aefpk3559r");
					final String query="insert into passengers values (?,?,?)";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setInt(1,Pay.max_psid+1);
					ps.setInt(2,Pay.max_cnid+1 );
					ps.setInt(3,Integer.parseInt(Select_Flight.FID_choosen));
					ps.executeUpdate();
					
				}catch(Exception e){
					System.out.println("Error in query");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root","aefpk3559r");
					final String query="select empid from employees where job_profile='boarding'";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					Pay.boarding_employees=0;
					while(rs.next()){
						Pay.boarding_employees+=1;
						Pay.boarding_empid=rs.getInt(1);
						
					}
					
					
				}catch(Exception e){
					System.out.println("Some eror in employee acess");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root","aefpk3559r");
					final String query ="select max(tsid) from transactions";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Pay.max_tsid=rs.getInt(1);
					}
					
				}catch(Exception e){
					System.out.println("Issue in extracting max tsid");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root","aefpk3559r");
					final String query="insert into transactions values (?,?,?,?)";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setInt(1, Pay.max_tsid+1);
					ps.setInt(2, Pay.boarding_empid);
					ps.setInt(3, Pay.max_psid+1);
					ps.setInt(4, Pay.amount_to_pay);
					System.out.println(ps);
					ps.executeUpdate();
					
				}catch(Exception e){
					System.out.println("last update in transaction");
				}
				
				
				create_pop_up();
				
			}
		});
		
		JButton btnView=new JButton("View");
		GridBagConstraints gbc_btnView=new GridBagConstraints();
		gbc_btnView.gridx=2;
		gbc_btnView.gridy=5;
		frame.getContentPane().add(btnView, gbc_btnView);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("hi");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select netfare from flight_schedule where fid=?";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ps.setString(1,Select_Flight.FID_choosen);
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Pay.amount_to_pay=rs.getInt(1);
			}
			
			
		}catch(Exception e){
			System.out.println("error in first");
		}
		
		btnView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println(Select_Flight.FID_choosen);
				DID_choosen=textField.getText();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("hi");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select netfare from flight_schedule where fid=?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1,Select_Flight.FID_choosen);
					System.out.println(ps);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()){
						//System.out.println("rock");
						//System.out.println(rs.getString(1));
						Pay.netfare_FID_choosen=rs.getInt(1);
						
						//System.out.println("me");
						//Pay.this.textField_1.setText(rs.getString(1));
					}
					
					
				}catch(Exception e){
					System.out.println("pay Class not found");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
					final String query="select amount from discount where did=?";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1,DID_choosen);
					System.out.println(ps);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Pay.amount_DID=rs.getInt(1);
						
					}
					System.out.println(Pay.netfare_FID_choosen);
					System.out.println(Pay.amount_DID);
					net_display=Pay.netfare_FID_choosen-Pay.amount_DID;
					Pay.amount_to_pay=net_display;
					
					Pay.this.textField_1.setText(Integer.toString(net_display));
				}catch(Exception e){
					System.out.println("Some error");
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root","aefpk3559r");
					final String query="select netfare from flight_schedule where netfare > (select max(netfare) from flight_schedule where arrival =?)";
					PreparedStatement ps=null;
					ps=conn.prepareStatement(query);
					ps.setString(1, Book_Menu.arrival);
					System.out.println(ps);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						System.out.println(rs.getString(1));
					}
					
				}catch(Exception e){
					System.out.println("Acessing this query");
				}
				
				
			}
		});
		
		
	}

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;

public class ViewFlight_Schedule {
	
	JTable table;
	JScrollPane pane;
	String col[]={"1","2","3,","4","5","6"};
	String output[];
	private JFrame frame;
	DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFlight_Schedule window = new ViewFlight_Schedule();
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
	public ViewFlight_Schedule() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Flight Schedule");
		Color my_color=new Color(102,255,178);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		set_table();
		
		JRadioButton rdbtnViewPassengersDetails = new JRadioButton("View Passengers Details");
		GridBagConstraints gbc_rdbtnViewPassengersDetails = new GridBagConstraints();
		gbc_rdbtnViewPassengersDetails.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnViewPassengersDetails.gridx = 0;
		gbc_rdbtnViewPassengersDetails.gridy = 8;
		//frame.getContentPane().add(rdbtnViewPassengersDetails, gbc_rdbtnViewPassengersDetails);
		
		JButton btnOk = new JButton("View Passenger Detail");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Passenger_details obj=new View_Passenger_details();
				frame.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 7;
		gbc_btnOk.ipadx=5;
		gbc_btnOk.ipady=5;
		
		frame.getContentPane().add(btnOk, gbc_btnOk);
		
		JButton back=new JButton("Back");
		GridBagConstraints gbc_back=new GridBagConstraints();
		gbc_back.gridx=0;
		gbc_back.gridy=8;
		gbc_back.ipadx=5;
		gbc_back.ipady=5;
		frame.getContentPane().add(back, gbc_back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class new_obj=new GUI_Class();
				
				frame.setVisible(false);
				
			}
		});
		
	}
	
	public void set_table(){
		model=new DefaultTableModel(col,4);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(800,800));
		table.setMinimumSize(new Dimension(800,800));
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("j");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			//System.out.println('l');
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from flight_schedule");
			output=new String[20];
			int i=0;
			model=new DefaultTableModel(col,20);
			table=new JTable(model);
			table.setPreferredSize(new Dimension(800,500));
			table.setMinimumSize(new Dimension(800,500));
			pane=new JScrollPane(table);
			//System.out.println("he");
			table.setValueAt("FID", 0, 0);
			table.setValueAt("ACID", 0, 1);
			table.setValueAt("NetFare", 0, 2);
			table.setValueAt("Flight_Date", 0, 3);
			table.setValueAt("Departure", 0, 4);
			table.setValueAt("Arrival",0, 5);
			table.setBackground(Color.yellow);
			while(rs.next()){
				System.out.println(rs.getString(2));
				table.setValueAt(rs.getString(1), i+1,0);
				table.setValueAt(rs.getString(2), i+1, 1);
				table.setValueAt(rs.getString(3), i+1, 2);
				table.setValueAt(rs.getString(4),i+1, 3);
				table.setValueAt(rs.getString(5), i+1, 4);
				table.setValueAt(rs.getString(6), i+1, 5);
				i++;
				
			}
			//frame.add(pane);
			frame.add(table);
			table.setVisible(true);
			//table.setBounds(40, 40, 1200, 1200);
			//table.setSize(500,400);
			
			
		}catch(Exception e){
			System.out.println("Class Not Found");
		}
	}
	

}

import javax.swing.JFrame;
import javax.swing.JTable;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;

public class Select_Flight {

	JFrame frame;
	private JTextField textField;
	public JTable table;
	DefaultTableModel model;
	String output[];
	JScrollPane pane;
	public static String FID_choosen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Flight window = new Select_Flight();
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
	public Select_Flight() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}
	
	public void set_flight_table(){
		String[] col={"FID","ACID","FLIGHT_DATE","DEPARTURE","ARRIVAL","DEPARTURE"};
		model=new DefaultTableModel(col,10);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(600,500));
		table.setMinimumSize(new Dimension(600,500));
		//table.add(pane);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("j");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			//System.out.println('l');
			//Statement st=conn.createStatement();
			//Book_Menu temp_obj=new Book_Menu();
			//System.out.println(Book_Menu.arrival);
			//System.out.println(Book_Menu.departure);
			//ResultSet rs=st.executeQuery("select * from flight_schedule where arrival="+Book_Menu.arrival+" and departure="+Book_Menu.departure);
			//System.out.println("select * from flight_schedule where arrival="+Book_Menu.arrival+" and departure="+Book_Menu.departure);
			final String sql_query="select * from flight_schedule where arrival=? and departure=?";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(sql_query);
			ps.setString(1,Book_Menu.arrival);
			ps.setString(2,Book_Menu.departure);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps);
			//output=new String[20];
			int i=0;
			//model=new DefaultTableModel(col,4);
			//table=new JTable(model);
			//pane=new JScrollPane(table);
			//table.setPreferredSize(new Dimension(800,800));
			//table.setMinimumSize(new Dimension(800,800));
			//table.add(pane);
			System.out.println("he");
			table.setValueAt("FID", 0, 0);
			table.setValueAt("ACID", 0, 1);
			table.setValueAt("NetFare", 0, 2);
			table.setValueAt("Flight_Date", 0, 3);
			table.setValueAt("Departure", 0, 4);
			table.setValueAt("Arrival",0, 5);
			table.setBackground(Color.yellow);
			
			while(rs.next()){
				System.out.println("coming here"); 
				System.out.println(rs.getString(1));
				table.setValueAt(rs.getString(1), i+1,0);
				table.setValueAt(rs.getString(2), i+1, 1);
				table.setValueAt(rs.getString(3), i+1, 2);
				table.setValueAt(rs.getString(4), i+1, 3);
				table.setValueAt(rs.getString(5), i+1, 4);
				table.setValueAt(rs.getString(6), i+1, 5);
				i++;
				
			}
			
			//frame.add(pane);
			frame.add(table);
			table.setVisible(true);
			//table.setBounds(40, 40, 1200, 1200);
			//table.setSize(1200,1200);
			//table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			
		}catch(Exception e){
			System.out.println("Class Not Found");
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Select Flights");
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{183, 75, 0};
		gridBagLayout.rowHeights = new int[]{76, 0, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		JLabel lblEnterYourChoice = new JLabel("Enter Your Choice(Enter FID)");
		GridBagConstraints gbc_lblEnterYourChoice = new GridBagConstraints();
		lblEnterYourChoice.setForeground(label_color);
		gbc_lblEnterYourChoice.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterYourChoice.anchor = GridBagConstraints.WEST;
		gbc_lblEnterYourChoice.gridx = 0;
		gbc_lblEnterYourChoice.gridy = 10;
		frame.getContentPane().add(lblEnterYourChoice, gbc_lblEnterYourChoice);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 10;
		gbc_textField.ipadx = 10;
		gbc_textField.ipady = 10;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select_Flight.FID_choosen=textField.getText();
				System.out.println("fid choosen by me"+Select_Flight.FID_choosen);
				Pay pay_obj = new Pay();
				frame.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		btnOk.setForeground(Color.black);
		gbc_btnOk.fill = GridBagConstraints.NONE;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 12;
		gbc_btnOk.ipadx = 10;
		gbc_btnOk.ipady = 10;
		frame.getContentPane().add(btnOk, gbc_btnOk);
		set_flight_table();
	}
}

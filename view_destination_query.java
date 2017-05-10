
import javax.swing.JFrame;
import javax.swing.JTable;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Connection;

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
import java.awt.*;


public class view_destination_query {
	
	private JFrame frame;
	private JTextField textField;
	public JTable table;
	DefaultTableModel model;
	String output[];
	JScrollPane pane;
	
	public view_destination_query() {
		initialise();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_destination_query window=new view_destination_query();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void initialise(){
		frame = new JFrame("Table");
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
		
		String col[]={"name","email","tel","street"};
		model=new DefaultTableModel(col,30);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(600,500));
		table.setMinimumSize(new Dimension(600,500));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select name,email,tel,street from passengers natural join contact_details natural join flight_schedule where arrival=?";
			
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ps.setString(1, destination_query.arrival_choosen);
			System.out.println(ps);
			System.out.println(destination_query.arrival_choosen);
			
			ResultSet rs=ps.executeQuery();
			table.setValueAt("name", 0, 0);
			table.setValueAt("email", 0, 1);
			table.setValueAt("tel", 0, 2);
			table.setValueAt("street", 0, 3);
			int i=1;
			while(rs.next()){
				table.setValueAt(rs.getString(1), i, 0);
				table.setValueAt(rs.getString(2), i, 1);
				table.setValueAt(rs.getString(3), i, 2);
				table.setValueAt(rs.getString(4), i, 3);
				i++;
			}
			
			frame.add(table);
			table.setVisible(true);
			table.setBackground(Color.yellow);
			
		}catch(Exception e){
			System.out.println("Some error");
		}
		
		JButton btmain = new JButton("Go to Main Menu");
		GridBagConstraints gbc_btok = new GridBagConstraints();
		gbc_btok.gridx = 1;
		gbc_btok.gridy = 3;
		frame.getContentPane().add(btmain, gbc_btok); 
		
		btmain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class obj=new GUI_Class();
				frame.setVisible(false);
			}
		});
	}
	
	
}

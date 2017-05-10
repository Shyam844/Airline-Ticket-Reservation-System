import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import com.mysql.jdbc.Connection;

import sun.invoke.util.BytecodeName;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.event.*;



public class view_mfd_query {
	
	private JFrame frame;
	private JTable table;
	private JScrollPane pane;
	DefaultTableModel model;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_mfd_query window=new view_mfd_query();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public view_mfd_query() {
		initialise();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		
	}
	
	public void initialise(){
		frame = new JFrame("View MFD query");
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
		frame.getContentPane().setBackground(my_color);
		String col[]={"mfby","no_of_aircrafts"};
		model=new DefaultTableModel(col,30);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(600,500));
		table.setMinimumSize(new Dimension(600,500));
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select mfdby,count(*) as no_of_aircrafts from aircraft natural join flight_schedule where arrival=? group by mfdby";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ps.setString(1, mfd_query.airport_choosen);
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			table.setValueAt("mfdby", 0, 0);
			table.setValueAt("no_of_aircrafts", 0, 1);
			int i=1;
			while(rs.next()){
				table.setValueAt(rs.getString(1), i, 0);
				table.setValueAt(rs.getString(2), i, 1);
				i++;
			}
			table.setBackground(Color.YELLOW);
			table.setVisible(true);
			frame.add(table);
			
		}catch(Exception e){
			System.out.println("get over it");
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

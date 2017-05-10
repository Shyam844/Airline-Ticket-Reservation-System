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
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.event.*;


public class View_Passenger_details {

	private JFrame frame;
	private JTable table;
	private JScrollPane pane;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Passenger_details window = new View_Passenger_details();
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
	public View_Passenger_details() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//JRadioButton rdbtnViewByDay = new JRadioButton("View By Day");
		//GridBagConstraints gbc_rdbtnViewByDay = new GridBagConstraints();
		//gbc_rdbtnViewByDay.insets = new Insets(0, 0, 5, 5);
		//rdbtnViewByDay.setForeground(label_color);
		//gbc_rdbtnViewByDay.gridx = 0;
		//gbc_rdbtnViewByDay.gridy = 0;
		//frame.getContentPane().add(rdbtnViewByDay, gbc_rdbtnViewByDay);
		
		//JButton btnOk = new JButton("OK");
		//GridBagConstraints gbc_btnOk = new GridBagConstraints();
		//gbc_btnOk.gridx = 4;
		//gbc_btnOk.gridy = 6;
		//frame.getContentPane().add(btnOk, gbc_btnOk);
		
		String[] col={"cnid","psid","fid","ctid","email","tel","street","name"};
		model=new DefaultTableModel(col,60);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(1000,700));
		table.setMinimumSize(new Dimension(1000,700));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select * from passengers natural join contact_details";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps);
			table.setValueAt("cnid", 0, 0);
			table.setValueAt("psid", 0, 1);
			table.setValueAt("fid",0, 2);
			table.setValueAt("ctid", 0, 3);
			table.setValueAt("email", 0, 4);
			table.setValueAt("tel", 0, 5);
			table.setValueAt("street", 0, 6);
			table.setValueAt("name", 0, 7);
			table.setBackground(Color.yellow);
			//System.out.println("hello");
			
			int i=1;
			while(rs.next()){
				//System.out.println("hi");
				//System.out.println(rs.getInt(1));
				table.setValueAt(rs.getInt(1), i, 0);
				table.setValueAt(rs.getInt(2), i, 1);
				table.setValueAt(rs.getInt(3), i, 2);
				table.setValueAt(rs.getInt(4), i, 3);
				table.setValueAt(rs.getString(5), i, 4);
				table.setValueAt(rs.getString(6), i, 5);
				table.setValueAt(rs.getString(7), i, 6);
				table.setValueAt(rs.getString(8), i, 7);
				//table.setValueAt(rs.getString(9), i, 8);
				i+=1;
			}
			
			frame.add(table);
			table.setVisible(true);
			
		}catch(Exception e){
			System.out.println("Some error in printing table");
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query ="select cnid from contact_details where cnid not in (select cnid from employees)";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
		}catch(Exception e){
			System.out.println("Some error");
		}
		
		JButton btnview = new JButton("View Employee detail");
		GridBagConstraints gbc_btnview = new GridBagConstraints();
		btnview.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				ViewEmployee_detail obj=new ViewEmployee_detail();
				frame.setVisible(false);
			}
		});
		
		gbc_btnview.gridx = 0;
		gbc_btnview.gridy = 8;
		frame.getContentPane().add(btnview, gbc_btnview);
		
		JButton btnmain_menu=new JButton("Main Menu");
		btnmain_menu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class obj=new GUI_Class();
				frame.setVisible(false);
			}
		});
		
		GridBagConstraints gbc_btn_main = new GridBagConstraints();
		gbc_btn_main.gridx=0;
		gbc_btn_main.gridy=7;
		frame.getContentPane().add(btnmain_menu,gbc_btn_main);
		
	}

	

}

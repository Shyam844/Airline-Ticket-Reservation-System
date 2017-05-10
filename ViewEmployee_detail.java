import java.awt.EventQueue;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.jdbc.Connection;

import sun.invoke.util.BytecodeName;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.table.*;


public class ViewEmployee_detail {
	private JFrame frame;
	public JTable table;
	DefaultTableModel model;
	String output[];
	JScrollPane pane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee_detail window = new ViewEmployee_detail();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewEmployee_detail(){
		initialise();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}
	
	public void initialise(){
		frame=new JFrame("View Employee detail");
		Color my_color=new Color(102,255,178);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 1000, 1000);
		//frame.getContentPane().setLayout(gridBagLayout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		String[] col={"cnid","empid","job_profile","ctid","email","tel","street","name"};
		model=new DefaultTableModel(col,4);
		table=new JTable(model);
		pane=new JScrollPane(table);
		System.out.println("k");
		table.setPreferredSize(new Dimension(1000,300));
		System.out.println("mario");
		table.setMinimumSize(new Dimension(1000,300));
		System.out.println("lol");
		table.setBackground(Color.yellow);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select * from employees natural join contact_details";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps);
			int i=1;
			table.setValueAt("cnid", 0, 0);
			table.setValueAt("empid", 0, 1);
			table.setValueAt("job_profile", 0, 2);
			table.setValueAt("ctid", 0, 3);
			table.setValueAt("email", 0, 4);
			table.setValueAt("tel", 0, 5);
			table.setValueAt("street",0,6);
			table.setValueAt("name", 0, 7);
			
			while(rs.next()){
				table.setValueAt(rs.getInt(1), i, 0);
				table.setValueAt(rs.getInt(2), i, 1);
				table.setValueAt(rs.getString(3), i, 2);
				table.setValueAt(rs.getInt(4), i, 3);
				table.setValueAt(rs.getString(5), i, 4);
				table.setValueAt(rs.getString(6), i, 5);
				table.setValueAt(rs.getString(7),i,6);
				table.setValueAt(rs.getString(8),i,7);
				i++;
			}
			
			frame.add(table);
			table.setVisible(true);
			
			
		}catch(Exception e){
			System.out.println("Some error in printing employee detail");
		}
		
		JButton btnmain_menu = new JButton("Go to Main Menu");
		GridBagConstraints gbc_btn_main = new GridBagConstraints();
		btnmain_menu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class obj=new GUI_Class();
				frame.setVisible(false);
			}
		});
		gbc_btn_main.insets = new Insets(0, 0, 5, 0);
		gbc_btn_main.gridx = 0;
		gbc_btn_main.gridy = 7;
		frame.getContentPane().add(btnmain_menu, gbc_btn_main);
		
	}
	
	
}

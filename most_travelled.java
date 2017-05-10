import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class most_travelled {
	private JFrame frame;
	private JTable table;
	private JScrollPane pane;
	DefaultTableModel model;
	
	public most_travelled() {
		initailise();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					most_travelled window=new most_travelled();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void initailise(){
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
		frame.getContentPane().setBackground(my_color);
		
		//String[] col={"cnid","psid","fid","ctid","email","tel","street","name"};
		
		String col[]={"arrival"};
		model=new DefaultTableModel(col,10);
		table=new JTable(model);
		pane=new JScrollPane(table);
		table.setPreferredSize(new Dimension(500,600));
		table.setMinimumSize(new Dimension(500,600));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?autoReconnect=true&useSSL=false", "root", "aefpk3559r");
			final String query="select arrival from (select arrival, count(arrival) as dc from flight_schedule group by arrival ) as t where dc = (select max(counter) from (select arrival, count(arrival) as counter from flight_schedule group by arrival) as tab )";
			PreparedStatement ps=null;
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			table.setValueAt("arrival", 0, 0);
			int i=1;
			while(rs.next()){
				table.setValueAt(rs.getString(1), i, 0);
				i++;
			}
			table.setBackground(Color.yellow);
			frame.add(table);
			table.setVisible(true);
			
		}catch(Exception e){
			System.out.println("Something wrong");
		}
		
		JButton btmain = new JButton("Go to Main Menu");
		GridBagConstraints gbc_btok = new GridBagConstraints();
		gbc_btok.gridx = 1;
		gbc_btok.gridy = 5;
		frame.getContentPane().add(btmain, gbc_btok); 
		
		btmain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				GUI_Class obj=new GUI_Class();
				frame.setVisible(false);
			}
		});
		
	}
}

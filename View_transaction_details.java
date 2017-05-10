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
import java.awt.*;

public class View_transaction_details {

	public JFrame frame;
	public JLabel label;
	public JTextField text_field;
	public static String psid_choosen;
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Select_Flight window = new Select_Flight();
					View_transaction_details window=new View_transaction_details();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public View_transaction_details(){
		initialise();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		
	}
	
	public void initialise(){
		frame=new JFrame();
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		label=new JLabel("Enter PSID");
		label.setForeground(label_color);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.ipadx = 10;
		gbc_lblNewLabel.ipady = 10;
		frame.getContentPane().add(label, gbc_lblNewLabel);
		
		text_field=new JTextField();
		GridBagConstraints gbc_text_field=new GridBagConstraints();
		gbc_text_field.insets=new Insets(0, 0, 5, 5);
		gbc_text_field.gridx=1;
		gbc_text_field.gridy=0;
		gbc_text_field.ipadx=40;
		gbc_text_field.ipady=7;
		frame.getContentPane().add(text_field,gbc_text_field);
		
		JButton btn_ok=new JButton("OK");
		GridBagConstraints gbc_btn_ok=new GridBagConstraints();
		gbc_btn_ok.insets=new Insets(0, 0, 5, 5);
		gbc_btn_ok.gridx=0;
		gbc_btn_ok.gridy=1;
		gbc_btn_ok.ipadx=10;
		gbc_btn_ok.ipady=10;
		frame.getContentPane().add(btn_ok, gbc_btn_ok);
		btn_ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				View_transaction_details.psid_choosen=text_field.getText();
				Display_transaction obj=new Display_transaction();
				frame.setVisible(false);
			}
		});
		
		
		
		
	}

}

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Booking_Details {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnProceed;
	private JButton btnReset;
	private JLabel lblDf;
	public static String customer_name;
	public static String customer_country;
	public static String customer_email;
	public static String customer_tel;
	public static String customer_street;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking_Details window = new Booking_Details();
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
	public Booking_Details() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Book Details");
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{40, 40, 40, 39, 40, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		//ImageIcon image=new ImageIcon("/Users/Sunny/Desktop/airplane.png");
		//JPanel panel=new JPanel();
		//JLabel imagelbl=new JLabel(image);
		//panel.add(imagelbl);
		//panel.setBounds(0, 800, 200, 200);
		System.out.println("here");
		//panel.setVisible(true);
		//frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Name");
		Border border_1=BorderFactory.createLineBorder(Color.BLACK,1);
		//lblNewLabel.setBorder(border_1);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		lblNewLabel.setForeground(label_color);
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.ipadx = 10;
		gbc_lblNewLabel.ipady = 10;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
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
		
		JLabel lblCountry = new JLabel("Country");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		Border border_2=BorderFactory.createLineBorder(Color.BLACK,1);
		//lblCountry.setBorder(border_2);
		lblCountry.setForeground(label_color);
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 1;
		frame.getContentPane().add(lblCountry, gbc_lblCountry);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		Border border_3=BorderFactory.createLineBorder(Color.BLACK,1);
		//lblNewLabel_1.setBorder(border_3);
		lblNewLabel_1.setForeground(label_color);
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.NONE;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		gbc_textField_2.ipadx = 10;
		gbc_textField_2.ipady = 10;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tel no.");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		Border border_4=BorderFactory.createLineBorder(Color.BLACK,1);
		//lblNewLabel_2.setBorder(border_4);
		lblNewLabel_2.setForeground(label_color);
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.NONE;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 3;
		gbc_textField_3.ipadx = 10;
		gbc_textField_3.ipady = 10;
		frame.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setForeground(label_color);
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		Border border_5=BorderFactory.createLineBorder(Color.BLACK,1);
		//lblStreet.setBorder(border_5);
		gbc_lblStreet.insets = new Insets(0, 0, 5, 0);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 4;
		frame.getContentPane().add(lblStreet, gbc_lblStreet);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.NONE;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		gbc_textField_4.ipadx = 10;
		gbc_textField_4.ipady = 10;
		frame.getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Select_Flight fli_obj = new Select_Flight();
				Booking_Details.this.customer_name=textField.getText();
				Booking_Details.this.customer_country=textField_1.getText();
				Booking_Details.this.customer_email=textField_2.getText();
				Booking_Details.this.customer_tel=textField_3.getText();
				Booking_Details.this.customer_street=textField_4.getText();
				frame.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_btnProceed = new GridBagConstraints();
		gbc_btnProceed.insets = new Insets(0, 0, 5, 0);
		gbc_btnProceed.gridx = 2;
		gbc_btnProceed.gridy = 5;
		gbc_btnProceed.ipadx=10;
		gbc_btnProceed.ipady=10;
		frame.getContentPane().add(btnProceed, gbc_btnProceed);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.gridx = 2;
		gbc_btnReset.gridy = 6;
		gbc_btnReset.ipadx=10;
		gbc_btnReset.ipady=10;
		frame.getContentPane().add(btnReset, gbc_btnReset);
		
		lblDf=new JLabel("");
		GridBagConstraints gbc_lblDf = new GridBagConstraints();
		  Image imglbl=new ImageIcon(this.getClass().getResource("a4.jpg")).getImage();
		  lblDf.setBounds(0,800,600,600);
		  lblDf.setIcon(new ImageIcon(imglbl));
		  //lblDf.setBounds(200,200,500,800);
		  gbc_lblDf.gridx = 2;
		  gbc_lblDf.gridy = 7;
		  gbc_lblDf.ipadx=2;
		  gbc_lblDf.ipady=2;
		  frame.getContentPane().add(lblDf, gbc_lblDf);
		
	}

}

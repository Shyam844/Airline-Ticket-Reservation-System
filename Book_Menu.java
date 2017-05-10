import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.text.*;

public class Book_Menu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public static String arrival;
	public static String departure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Menu window = new Book_Menu();
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
	public Book_Menu() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
		//run();
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
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblDepartureFrom = new JLabel("Departure  from");
		GridBagConstraints gbc_lblDepartureFrom = new GridBagConstraints();
		gbc_lblDepartureFrom.insets = new Insets(0, 0, 5, 0);
		lblDepartureFrom.setForeground(label_color);
		gbc_lblDepartureFrom.gridx = 0;
		gbc_lblDepartureFrom.gridy = 0;
		frame.getContentPane().add(lblDepartureFrom, gbc_lblDepartureFrom);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		gbc_textField.ipadx=10;
		gbc_textField.ipady=10;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblArrivalAt = new JLabel("Arrival at");
		GridBagConstraints gbc_lblArrivalAt = new GridBagConstraints();
		lblArrivalAt.setForeground(label_color);
		gbc_lblArrivalAt.insets = new Insets(0, 0, 5, 0);
		gbc_lblArrivalAt.gridx = 0;
		gbc_lblArrivalAt.gridy = 2;
		frame.getContentPane().add(lblArrivalAt, gbc_lblArrivalAt);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.NONE;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		gbc_textField_1.ipadx =10;
		gbc_textField_1.ipady =10;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   Book_Menu.this.arrival=textField_1.getText();
				   Book_Menu.this.departure=textField.getText();
				   new Booking_Details();
				   

			    frame.setVisible(false);
			   }
			  });
		//System.out.println(arrival);
		//System.out.println(departure);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 6;
		frame.getContentPane().add(btnOk, gbc_btnOk);
	}

}

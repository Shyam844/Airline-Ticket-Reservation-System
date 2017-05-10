import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.scenario.effect.DropShadow;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUI_Class {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=211,9
	 */
	private final JLabel GUI = new JLabel("New label");
	private final JButton btnNewButton = new JButton("OK");
	//JRadioButton rdnview_transaction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Class window = new GUI_Class();
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
	public GUI_Class() {
		initialize();
		//main();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Airline Ticket Rervation System");
		Color my_color=new Color(102,255,178);
		frame.getContentPane().setBackground(my_color);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{65, 65, 65, 58, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		DropShadow shadow=new DropShadow();
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Aircraft Ticket Reservation System");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		Border border=BorderFactory.createLineBorder(Color.BLACK,5);
		lblNewJgoodiesTitle.setBorder(border);
		Color label_color=new Color(255,102,255);
		lblNewJgoodiesTitle.setBackground(Color.yellow);
		lblNewJgoodiesTitle.setForeground(label_color);
		GridBagConstraints gbc_lblNewJgoodiesTitle = new GridBagConstraints();
		gbc_lblNewJgoodiesTitle.fill = GridBagConstraints.BOTH;
		gbc_lblNewJgoodiesTitle.insets = new Insets(0, 180, 5, 0);
		gbc_lblNewJgoodiesTitle.gridx = 0;
		gbc_lblNewJgoodiesTitle.gridy = 0;
		frame.getContentPane().add(lblNewJgoodiesTitle, gbc_lblNewJgoodiesTitle);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("View Flight-Schedule");
		Border border_1=BorderFactory.createLineBorder(Color.BLACK,5);
		rdbtnNewRadioButton.setBorder(border_1);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		
		
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setForeground(label_color);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 20, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnBookTicket = new JRadioButton("Book ticket");
		rdbtnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		rdbtnBookTicket.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		rdbtnBookTicket.setBackground(Color.WHITE);
		rdbtnBookTicket.setForeground(label_color);
		GridBagConstraints gbc_rdbtnBookTicket = new GridBagConstraints();
		gbc_rdbtnBookTicket.fill = GridBagConstraints.BOTH;
		gbc_rdbtnBookTicket.insets = new Insets(0, 0, 20, 0);
		
		gbc_rdbtnBookTicket.gridx = 0;
		gbc_rdbtnBookTicket.gridy = 2;
		frame.getContentPane().add(rdbtnBookTicket, gbc_rdbtnBookTicket);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnBookTicket);
		group.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdnview_transaction=new JRadioButton("View Transaction Details");
		rdnview_transaction.setBackground(Color.white);
		rdnview_transaction.setForeground(label_color);
		GridBagConstraints gbc_rdntrans =new GridBagConstraints();
		gbc_rdntrans.fill=GridBagConstraints.BOTH;
		gbc_rdntrans.insets=new Insets(0, 0 , 0, 50);
		gbc_rdntrans.gridx=1;
		gbc_rdntrans.gridy=1;
		frame.getContentPane().add(rdnview_transaction,gbc_rdntrans );
		group.add(rdnview_transaction);
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.NONE;
		gbc_btnNewButton.insets=new Insets(0, 100, 0, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		gbc_btnNewButton.ipadx=20;
		gbc_btnNewButton.ipady=20;
		
		JRadioButton rdnair_queries=new JRadioButton("View aircraft details");
		rdnair_queries.setBackground(Color.white);
		rdnair_queries.setForeground(label_color);
		GridBagConstraints gbc_rdn_air=new GridBagConstraints();
		gbc_rdn_air.fill=GridBagConstraints.BOTH;
		gbc_rdn_air.insets=new Insets(0,0,0,50);
		gbc_rdn_air.gridx=1;
		gbc_rdn_air.gridy=2;
		frame.getContentPane().add(rdnair_queries, gbc_rdn_air);
		group.add(rdnair_queries);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBookTicket.isSelected()){
					//System.out.println(":c here");
					Book_Menu book_obj = new Book_Menu();
					frame.setVisible(false);
					
				}
				else if(rdbtnNewRadioButton.isSelected()){
					ViewFlight_Schedule view_obj=new ViewFlight_Schedule();
					frame.setVisible(false);
					
				}
				else if(rdnview_transaction.isSelected()){
					View_transaction_details obj=new View_transaction_details();
					frame.setVisible(false);
				}
				else if(rdnair_queries.isSelected()){
					aircraft_queries obj=new aircraft_queries();
					frame.setVisible(false);
				}
				
			}
		});
		
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		
		
		
		
		
		
	}
}

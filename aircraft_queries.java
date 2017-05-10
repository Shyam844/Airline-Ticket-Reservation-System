
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
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

import javax.swing.JLabel;

public class aircraft_queries {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aircraft_queries window = new aircraft_queries();
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
	public aircraft_queries() {
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
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		frame.getContentPane().setBackground(my_color);
		
		JLabel lblNewLabel = new JLabel("Select any one of the queries");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setForeground(label_color);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton rdbtnQuery_1 = new JRadioButton("View aircrafts coming in an airport");
		GridBagConstraints gbc_rdbtnQuery_1 = new GridBagConstraints();
		gbc_rdbtnQuery_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnQuery_1.gridx = 0;
		gbc_rdbtnQuery_1.gridy = 2;
		frame.getContentPane().add(rdbtnQuery_1, gbc_rdbtnQuery_1);
		rdbtnQuery_1.setForeground(label_color);
		group.add(rdbtnQuery_1);
		
		JRadioButton rdbtnQuery_2 = new JRadioButton("View passengers coming a destination");
		GridBagConstraints gbc_rdbtnQuery_2 = new GridBagConstraints();
		gbc_rdbtnQuery_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnQuery_2.gridx = 0;
		gbc_rdbtnQuery_2.gridy = 4;
		frame.getContentPane().add(rdbtnQuery_2, gbc_rdbtnQuery_2);
		rdbtnQuery_2.setForeground(label_color);
		group.add(rdbtnQuery_2);
		
		JRadioButton rdbtnQuery_3 = new JRadioButton("View Most travelled destination");
		GridBagConstraints gbc_rdbtnQuery = new GridBagConstraints();
		gbc_rdbtnQuery.gridx = 0;
		gbc_rdbtnQuery.gridy = 6;
		frame.getContentPane().add(rdbtnQuery_3, gbc_rdbtnQuery);
		rdbtnQuery_3.setForeground(label_color);
		group.add(rdbtnQuery_3);
		
		JButton btnok = new JButton("OK");
		GridBagConstraints gbc_btok = new GridBagConstraints();
		gbc_btok.gridx = 0;
		gbc_btok.gridy = 7;
		frame.getContentPane().add(btnok, gbc_btok); 
		
		btnok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(rdbtnQuery_3.isSelected()){
					most_travelled obj=new most_travelled();
					frame.setVisible(false);
				}
				else if(rdbtnQuery_1.isSelected()){
					mfd_query obj=new mfd_query();
					frame.setVisible(false);
				}
				else if(rdbtnQuery_2.isSelected()){
					destination_query obj=new destination_query();
					frame.setVisible(false);
					
				}
			}
		});
		
		
	}

}

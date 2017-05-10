
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;


public class mfd_query {

	private JFrame frame;
	private JTextField textField;
	public static String airport_choosen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mfd_query window = new mfd_query();
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
	public mfd_query() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		Color my_color=new Color(102,255,178);
		Color label_color=new Color(255,102,255);
		frame.getContentPane().setBackground(my_color);
		
		JLabel lblNewLabel = new JLabel("Please enter airport");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 1;
		lblNewLabel.setForeground(label_color);
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.NONE;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 3;
		gbc_textField.ipadx=10;
		gbc_textField.ipady=10;
		
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btok = new JButton("Ok");
		GridBagConstraints gbc_btok = new GridBagConstraints();
		gbc_btok.gridx = 6;
		gbc_btok.gridy = 4;
		frame.getContentPane().add(btok, gbc_btok);
		btok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				mfd_query.airport_choosen=textField.getText();
				view_mfd_query obj=new view_mfd_query();
				frame.setVisible(false);
			}
		});
	}

}

package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField cardNoField;
	private JPasswordField passwordField;
	private JButton signInButton;
	private JButton signUpButton;
	private JButton clearButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("ATM Machine Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setForeground(new Color(255, 245, 238));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ATM Simulation");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 32));
		lblNewLabel.setBounds(195, 21, 362, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CARD NO:");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		lblNewLabel_1.setBounds(95, 126, 154, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PIN:");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		lblNewLabel_2.setBounds(95, 190, 107, 36);
		contentPane.add(lblNewLabel_2);
		
		cardNoField = new JTextField();
		cardNoField.setForeground(new Color(0, 0, 0));
		cardNoField.setBounds(269, 116, 248, 30);
		contentPane.add(cardNoField);
		cardNoField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(269, 192, 248, 30);
		contentPane.add(passwordField);
		
		 signInButton = new JButton("SIGN IN");
		signInButton.setBackground(new Color(0, 0, 0));
		signInButton.setForeground(UIManager.getColor("Button.highlight"));
		signInButton.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		signInButton.setBounds(270, 271, 115, 36);
		contentPane.add(signInButton);
		
		 signUpButton = new JButton("SIGN UP");
		signUpButton.setBackground(new Color(0, 0, 0));
		signUpButton.setForeground(UIManager.getColor("Button.highlight"));
		signUpButton.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		signUpButton.setBounds(409, 271, 108, 36);
		contentPane.add(signUpButton);
		
		 clearButton = new JButton("CLEAR");
		clearButton.setForeground(UIManager.getColor("Button.highlight"));
		clearButton.setBackground(new Color(0, 0, 0));
		clearButton.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 16));
		clearButton.setBounds(269, 330, 250, 30);
		contentPane.add(clearButton);
		
		signInButton.addActionListener(this);
		signUpButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		//setSize(800,600);
        setLocation(500,90);
        setVisible(true);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		try {
			Conn c1=new Conn();
			String a=cardNoField.getText();
			String b=passwordField.getText();
			String q="select * from login where cardno = '"+a+"' and pin = '"+b+"'";
			ResultSet rs=c1.s.executeQuery(q);
			if(ae.getSource()==signInButton) {
				if(rs.next()) {
					new Transactions().setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
					cardNoField.setText("");
					passwordField.setText("");
				}
			}
			else if(ae.getSource()==signUpButton) {
				new Signup().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==clearButton) {
				cardNoField.setText("");
				passwordField.setText("");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("error: "+e);
		}
	}
	
}

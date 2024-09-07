package atm;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField fatherNameField;
	private JTextField emailField;
	private JTable table;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField pincodeField;
	private JTextField stateField;
    
	Random ran=new Random();
	long first4=(ran.nextLong()%9000L)+1000L;
	long first=Math.abs(first4);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("SignUp Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLICATION FORM NO."+first);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		lblNewLabel.setBounds(178, 38, 577, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Page 1: Personal Details");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblNewLabel_1.setBounds(276, 84, 251, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_2.setBounds(40, 132, 88, 27);
		contentPane.add(lblNewLabel_2);
		
		nameField = new JTextField();
		nameField.setBounds(301, 137, 429, 27);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Father's Name:");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_3.setBounds(40, 178, 132, 20);
		contentPane.add(lblNewLabel_3);
		
		fatherNameField = new JTextField();
		fatherNameField.setBounds(301, 180, 429, 27);
		contentPane.add(fatherNameField);
		fatherNameField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth:");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_4.setBounds(40, 222, 132, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_5.setBounds(301, 227, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		String date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox dayDropDown = new JComboBox(date);
		dayDropDown.setBounds(332, 223, 56, 22);
		contentPane.add(dayDropDown);
		
		JLabel lblNewLabel_6 = new JLabel("Month");
		lblNewLabel_6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_6.setBounds(406, 226, 56, 14);
		contentPane.add(lblNewLabel_6);
		
		String months[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		JComboBox monthDropDown = new JComboBox(months);
		monthDropDown.setBounds(456, 223, 146, 22);
		contentPane.add(monthDropDown);
		
		JLabel lblNewLabel_7 = new JLabel("Year");
		lblNewLabel_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_7.setBounds(611, 226, 39, 14);
		contentPane.add(lblNewLabel_7);
		
		String year[]= {"1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2011","2012","2015","2016","2018","2019","2020"};
		JComboBox yearDropDown = new JComboBox(year);
		yearDropDown.setBounds(642, 223, 88, 22);
		contentPane.add(yearDropDown);
		
		JLabel lblNewLabel_8 = new JLabel("Gender:");
		lblNewLabel_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_8.setBounds(40, 267, 88, 14);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton maleButton = new JRadioButton("Male");
		maleButton.setBackground(new Color(240, 248, 255));
		maleButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		maleButton.setBounds(301, 265, 111, 23);
		contentPane.add(maleButton);
		
		JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setBackground(new Color(240, 248, 255));
		femaleButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		femaleButton.setBounds(456, 265, 111, 23);
		contentPane.add(femaleButton);
		
		JLabel lblNewLabel_9 = new JLabel("Email Address:");
		lblNewLabel_9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_9.setBounds(40, 303, 137, 20);
		contentPane.add(lblNewLabel_9);
		
		emailField = new JTextField();
		emailField.setBounds(301, 305, 429, 27);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Marital Status:");
		lblNewLabel_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_10.setBounds(40, 346, 146, 20);
		contentPane.add(lblNewLabel_10);
		
		table = new JTable();
		table.setBounds(113, 547, 1, 1);
		contentPane.add(table);
		
		JRadioButton marriedButton = new JRadioButton("Married");
		marriedButton.setBackground(new Color(240, 248, 255));
		marriedButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		marriedButton.setBounds(301, 347, 111, 23);
		contentPane.add(marriedButton);
		
		JRadioButton unmarriedButton = new JRadioButton("Unmarried");
		unmarriedButton.setBackground(new Color(240, 248, 255));
		unmarriedButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		unmarriedButton.setBounds(456, 347, 111, 23);
		contentPane.add(unmarriedButton);
		
		JRadioButton otherGenderButton = new JRadioButton("Other");
		otherGenderButton.setBackground(new Color(240, 248, 255));
		otherGenderButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		otherGenderButton.setBounds(642, 264, 88, 23);
		contentPane.add(otherGenderButton);
		
		JLabel lblNewLabel_11 = new JLabel("Address:");
		lblNewLabel_11.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_11.setBounds(40, 389, 111, 27);
		contentPane.add(lblNewLabel_11);
		
		addressField = new JTextField();
		addressField.setBounds(301, 394, 429, 27);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("City:");
		lblNewLabel_12.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_12.setBounds(40, 439, 74, 20);
		contentPane.add(lblNewLabel_12);
		
		cityField = new JTextField();
		cityField.setBounds(301, 441, 429, 27);
		contentPane.add(cityField);
		cityField.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Pincode:");
		lblNewLabel_13.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_13.setBounds(40, 488, 96, 20);
		contentPane.add(lblNewLabel_13);
		
		pincodeField = new JTextField();
		pincodeField.setBounds(301, 487, 429, 27);
		contentPane.add(pincodeField);
		pincodeField.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("State:");
		lblNewLabel_14.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_14.setBounds(40, 534, 65, 14);
		contentPane.add(lblNewLabel_14);
		
		stateField = new JTextField();
		stateField.setBounds(301, 528, 429, 27);
		contentPane.add(stateField);
		stateField.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a=nameField.getText();
				String b=fatherNameField.getText();
				
				String ac=(String)dayDropDown.getSelectedItem();
				String bc=(String)monthDropDown.getSelectedItem();
				String cc=(String)yearDropDown.getSelectedItem();
				
				String d=null;
				if(maleButton.isSelected()) {
					d="Male";
				}
				else if(femaleButton.isSelected()) {
					d="Female";
				}else if(otherGenderButton.isSelected()) {
					 d="Other";
				 }
				 String e=emailField.getText();
				 String f=null;
				 if(marriedButton.isSelected()) {
					 f="Married";
				 }else if(unmarriedButton.isSelected()) {
					 f="Unmarried";
				 }
				 
				 String g=addressField.getText();
				 String h=cityField.getText();
				 String i=pincodeField.getText();
				 String j=stateField.getText();
				 
				 try {
					 if(nameField.getText().equals("")||fatherNameField.getText().equals("")||addressField.getText().equals("")||cityField.getText().equals("")||pincodeField.getText().equals("")||stateField.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "Fill all the required fields");
					 }
					 else {
					 Conn c1=new Conn();
					 String q1="insert into signup0 values('"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+first+"')";
					 
					 c1.s.executeUpdate(q1);
					 JOptionPane.showMessageDialog(null, "Your form number is :"+first+"\nUse this number for futher actions");
					 new Signup2().setVisible(true);
					 setVisible(false);
					 }
				 }
				 catch(Exception ex) {
				 ex.printStackTrace();}
			}
		});
		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(Color.BLACK);
		nextButton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		nextButton.setBounds(642, 572, 89, 23);
		contentPane.add(nextButton);
	}
}

package atm;

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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Signup2 extends JFrame {

	private JPanel contentPane;
	private JTextField formNoField;
	private JTextField panNoField;
	private JTextField aadharNoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup2 frame = new Signup2();
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
	public Signup2() {
		setTitle("SignUp Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Form No.");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(631, 11, 71, 31);
		contentPane.add(lblNewLabel);
		
		formNoField = new JTextField();
		formNoField.setBounds(700, 11, 71, 31);
		contentPane.add(formNoField);
		formNoField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Page 2: Additional Details");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(164, 41, 425, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Religion:");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_2.setBounds(51, 107, 94, 25);
		contentPane.add(lblNewLabel_2);
		
		String religion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		JComboBox religionComboBox = new JComboBox(religion);
		religionComboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		religionComboBox.setBackground(new Color(255, 255, 255));
		religionComboBox.setBounds(262, 110, 414, 31);
		contentPane.add(religionComboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Category:");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_3.setBounds(51, 153, 104, 25);
		contentPane.add(lblNewLabel_3);
		
		String category[]= {"General","OBC","SC","ST","Other"};
		JComboBox categoryComboBox = new JComboBox(category);
		categoryComboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		categoryComboBox.setBackground(new Color(255, 255, 255));
		categoryComboBox.setBounds(262, 156, 414, 31);
		contentPane.add(categoryComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Income:");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_4.setBounds(51, 199, 94, 25);
		contentPane.add(lblNewLabel_4);
		
		String income[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Above 10,00,000"};
		JComboBox incomeComboBox = new JComboBox(income);
		incomeComboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		incomeComboBox.setBackground(new Color(255, 255, 255));
		incomeComboBox.setBounds(262, 202, 414, 31);
		contentPane.add(incomeComboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Educational");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_5.setBounds(51, 248, 118, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Qualification:");
		lblNewLabel_6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_6.setBounds(51, 273, 118, 20);
		contentPane.add(lblNewLabel_6);
		
		String education[]= {"Non-Graduate","Graduate","Post-Graduate","Docrate","Other"};
		JComboBox eduQualificationComboBox = new JComboBox(education);
		eduQualificationComboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		eduQualificationComboBox.setBackground(new Color(255, 255, 255));
		eduQualificationComboBox.setBounds(262, 248, 414, 31);
		contentPane.add(eduQualificationComboBox);
		
		JLabel lblNewLabel_7 = new JLabel("Occupation:");
		lblNewLabel_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_7.setBounds(51, 321, 133, 25);
		contentPane.add(lblNewLabel_7);
		
		String occupation[]= {"Self-Employed","Bussiness","Student","Other"};
		JComboBox occupationComboBox = new JComboBox(occupation);
		occupationComboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		occupationComboBox.setBackground(new Color(255, 255, 255));
		occupationComboBox.setBounds(262, 315, 414, 31);
		contentPane.add(occupationComboBox);
		
		JLabel lblNewLabel_8 = new JLabel("PAN Number:");
		lblNewLabel_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_8.setBounds(51, 371, 154, 20);
		contentPane.add(lblNewLabel_8);
		
		panNoField = new JTextField();
		panNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		panNoField.setBounds(262, 368, 414, 31);
		contentPane.add(panNoField);
		panNoField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Aadhar Number:");
		lblNewLabel_9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_9.setBounds(51, 414, 154, 25);
		contentPane.add(lblNewLabel_9);
		
		aadharNoField = new JTextField();
		aadharNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		aadharNoField.setBounds(262, 418, 414, 31);
		contentPane.add(aadharNoField);
		aadharNoField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Senior Citizen:");
		lblNewLabel_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_10.setBounds(51, 458, 150, 25);
		contentPane.add(lblNewLabel_10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setBackground(new Color(240, 248, 255));
		rdbtnNewRadioButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(262, 461, 94, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBackground(new Color(240, 248, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(390, 461, 94, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("Existing Account:");
		lblNewLabel_11.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel_11.setBounds(51, 504, 154, 20);
		contentPane.add(lblNewLabel_11);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2.setBackground(new Color(240, 248, 255));
		rdbtnNewRadioButton_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnNewRadioButton_2.setBounds(262, 504, 94, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("No");
		rdbtnNewRadioButton_3.setBackground(new Color(240, 248, 255));
		rdbtnNewRadioButton_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnNewRadioButton_3.setBounds(390, 505, 86, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a=(String)religionComboBox.getSelectedItem();
				String b=(String)categoryComboBox.getSelectedItem();
				String c=(String)incomeComboBox.getSelectedItem();
				String d=(String)eduQualificationComboBox.getSelectedItem();
				String e=(String)occupationComboBox.getSelectedItem();
				
				String f=panNoField.getText();
				String g=aadharNoField.getText();
				
				String h="";
				if(rdbtnNewRadioButton.isSelected()) {
					h="Yes";
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					h="No";
				}
				
				String i="";
				if(rdbtnNewRadioButton_2.isSelected()) {
					i="Yes";
				}else if(rdbtnNewRadioButton_3.isSelected()) {
					i="No";
				}
				
				String j=formNoField.getText();
				try {
					if(formNoField.getText().equals("")||panNoField.getText().equals("")||aadharNoField.getText().equals("")||rdbtnNewRadioButton.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all the required fields");
					}
					else {
						Conn c1=new Conn();
						String q1="insert into signup22 values('"+j+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"')";
						c1.s.executeUpdate(q1);
						
						new Signup3().setVisible(true);
						setVisible(false);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(Color.BLACK);
		nextButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		nextButton.setBounds(592, 533, 89, 31);
		contentPane.add(nextButton);
	}
}

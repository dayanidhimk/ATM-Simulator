package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amountField,pinNoField;
    JButton depositButton,backButton,exitButton;
    JLabel l1,l2,l3;
    
    Deposit(){
    	getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
    	setBackground(new Color(240, 248, 255));
        
        setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DEPOSIT");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (5*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DEPOSIT");
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setBounds(144, 73, 562, 60);
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setBounds(277, 144, 300, 60);
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        
        l3 = new JLabel("Enter Pin");
        l3.setBounds(580, 9, 80, 30);
        l3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        amountField = new JTextField();
        amountField.setBounds(221, 215, 333, 50);
        amountField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        pinNoField = new JTextField();
        pinNoField.setBounds(660, 10, 80, 30);
        pinNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(244, 317, 125, 50);
        depositButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        depositButton.setBackground(new Color(0, 0, 0));
        depositButton.setForeground(Color.WHITE);
    
        backButton = new JButton("BACK");
        backButton.setBounds(417, 317, 125, 50);
        backButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        
        exitButton = new JButton("EXIT");
        exitButton.setBounds(297, 434, 200, 50);
        exitButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        getContentPane().setLayout(null);
        getContentPane().add(l3);
        getContentPane().add(pinNoField);
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(amountField);
        getContentPane().add(depositButton);
        getContentPane().add(backButton);
        getContentPane().add(exitButton);
        
        
        depositButton.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        getContentPane().setBackground(new Color(240, 248, 255));
        
        setSize(800,600);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String a = amountField.getText();
            String b = pinNoField.getText();
            if(ae.getSource()==depositButton){
            	 
                if(amountField.getText().equals("")||pinNoField.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please fill all the required fields");
                
                }else{
                    
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"' ORDER BY id DESC LIMIT 1");
                    double d = Double.parseDouble(a);
                    double balance = 0;
                    if(rs.next())
                    	balance = rs.getDouble("balance");
                    else {
                    	JOptionPane.showMessageDialog(null, "Invalid Pin!!\n\nExiting for Security purposes...");
                    	System.exit(0);
                    }
                    balance+=d;
                    
                    String q1= "insert into bank (pin,credit,balance) values('"+b+"','"+d+"','"+balance+"')";
                    c1.s.executeUpdate(q1);
                    
                   
                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                }
                
            }else if(ae.getSource()==backButton){
                new Transactions().setVisible(true);
                setVisible(false);
            }else if(ae.getSource()==exitButton){
                System.exit(0);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit().setVisible(true);
    }

    
}
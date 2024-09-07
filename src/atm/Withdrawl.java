package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amountField,pinNoField;
    JButton withdrawButton,backButton,exitButton;
    JLabel l1,l2,l3,l4;
    
    Withdrawl(){
    	getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("WITHDRAWAL");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"WITHDRAWAL");
        
        
        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        
        l4 = new JLabel("Enter Pin");
        l4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        amountField = new JTextField();
        amountField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        pinNoField = new JTextField();
        pinNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        withdrawButton.setBackground(Color.BLACK);
        withdrawButton.setForeground(Color.WHITE);
    
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        
        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        
        
        getContentPane().setLayout(null);
        
        l4.setBounds(590,10,80,30);
        getContentPane().add(l4);
        
        pinNoField.setBounds(665,10,75,30);
        getContentPane().add(pinNoField);
        
        l1.setBounds(90,100,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(270,160,800,60);
        getContentPane().add(l2);
        
        l3.setBounds(120,260,800,60);
        getContentPane().add(l3);
        
        amountField.setBounds(210,340,360,50);
        getContentPane().add(amountField);
        
        withdrawButton.setBounds(220,400,160,50);
        getContentPane().add(withdrawButton);
        
        backButton.setBounds(400,400,160,50);
        getContentPane().add(backButton);
        
        exitButton.setBounds(300,477,200,50);
        getContentPane().add(exitButton);
        
        
        withdrawButton.addActionListener(this);
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
            
            if((ae.getSource()==withdrawButton) && (b.equals("")))
                JOptionPane.showMessageDialog(null, "Please enter the Pin number!");
            
            else
            {
            
            if(ae.getSource()==withdrawButton){
                if(amountField.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                
                }else{
                    
                    Conn c1 = new Conn();
                    
                    
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"' ORDER BY id DESC LIMIT 1");
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                        double d = Double.parseDouble(a);
                        
                        if(balance<d)
                        	JOptionPane.showMessageDialog(null, "Insufficient funds!");
                        else
                        {
                        	balance-=d;
                        	String q1= "insert into bank (pin, debit, balance) values('"+pin+"','"+d+"','"+balance+"')";
                        	c1.s.executeUpdate(q1);
                        	JOptionPane.showMessageDialog(null, "Rs. "+a+" Debited Successfully");
                        }
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Invalid Pin!!\n\nExiting for Security purposes...");
                    	System.exit(0);
                    }
                    new Transactions().setVisible(true);
                    setVisible(false);
                }
            }
            }
            if(ae.getSource()==backButton){
                
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
        new Withdrawl().setVisible(true);
    }
}
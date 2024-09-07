package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class FastCash extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField pinNoField;
    
    FastCash(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("FAST CASH");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"FAST CASH");
    
        
        
        
        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 38));
        
        l2 = new JLabel("Enter PIN");
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
        
        pinNoField = new JTextField();
        pinNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
    
       
        b1 = new JButton("Rs 100");
        b1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("Rs 500");
        b2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Rs 1000");
        b3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Rs 2000");
        b4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("Rs 5000");
        b5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("BACK");
        b7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        
        getContentPane().setLayout(null);
        
        l2.setBounds(613,10,60,40);
        getContentPane().add(l2);
        
        pinNoField.setBounds(683,10,87,40);
        getContentPane().add(pinNoField);
        
        l1.setBounds(99,87,700,40);
        getContentPane().add(l1);
        
        b1.setBounds(40,170,300,60);
        getContentPane().add(b1);
        
        b2.setBounds(440,170,300,60);
        getContentPane().add(b2);
        
        b3.setBounds(40,280,300,60);
        getContentPane().add(b3);
        
        b4.setBounds(440,280,300,60);
        getContentPane().add(b4);
        
        b5.setBounds(40,390,300,60);
        getContentPane().add(b5);
        
        b6.setBounds(440,390,300,60);
        getContentPane().add(b6);
        
        b7.setBounds(244,490,300,60);
        getContentPane().add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        
        getContentPane().setBackground(new Color(240, 248, 255));
        
        setSize(800,600);
        setLocation(500,90);
        setVisible(true);
        
        
        
    }
    public void debit(String a, double n) throws SQLException
    {
    	Conn c1 = new Conn();
        
        ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ORDER BY id DESC LIMIT 1");
        double balance =0;
        
        if(rs.next()){
            String pin = rs.getString("pin");
            
            balance = rs.getDouble("balance");
            if(balance<n)
            	JOptionPane.showMessageDialog(null, "Insufficient funds!");
            else
            {
            	balance-=n;
            	String q1= "insert into bank (pin, debit, balance) values('"+pin+"',"+n+",'"+balance+"')";
        
            	c1.s.executeUpdate(q1);
            
            	JOptionPane.showMessageDialog(null, "Rs. "+n+" Debited Successfully");
            }
            new Transactions().setVisible(true);
            setVisible(false);
        }
        else {
        	JOptionPane.showMessageDialog(null, "Invalid Pin!!\n\nExiting for Security purposes...");
        	System.exit(0);
        }
    }
    
    public void actionPerformed(ActionEvent ae){
    	try
    	{        
           
            String a = pinNoField.getText();
            
            if(((ae.getSource()==b1) || (ae.getSource()==b2) || (ae.getSource()==b3) || (ae.getSource()==b4) || (ae.getSource()==b5) || (ae.getSource()==b6)) && (a.equals("")))
                JOptionPane.showMessageDialog(null, "Please enter the Pin number!");
            
            
            if(ae.getSource()==b1)
                    debit(a,100);
                
            else if(ae.getSource()==b2)
            		debit(a,500);
                    
            else if(ae.getSource()==b3)
                	debit(a,1000);
                    
            else if(ae.getSource()==b4)
            		debit(a,2000);
                    
            else if(ae.getSource()==b5)
                	debit(a,5000);
                    
            else if(ae.getSource()==b6)
                    debit(a,10000);
                
            else if(ae.getSource()==b7)
                System.exit(0);
                
        }
    	catch(Exception e)
    	{
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    public static void main(String[] args){
        new FastCash().setVisible(true);
    }
}
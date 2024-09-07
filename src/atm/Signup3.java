package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JTextField formNoField;
    
    
    
    
    Signup3(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        int y = fm.stringWidth(" ");
        int z = getWidth()/2 - (x/2);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
        
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(240, 248, 255));
        c1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(240, 248, 255));
        c2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(240, 248, 255));
        c3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(240, 248, 255));
        c4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(240, 248, 255));
        c5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(240, 248, 255));
        c6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(240, 248, 255));
        c7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        r1.setBackground(new Color(240, 248, 255));
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        r2.setBackground(new Color(240, 248, 255));
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        r3.setBackground(new Color(240, 248, 255));
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        r4.setBackground(new Color(240, 248, 255));
        
        formNoField = new JTextField();
        formNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        
        
        
        getContentPane().setLayout(null);
        
        l11.setBounds(650,7,100,30);
        getContentPane().add(l11);
        
        formNoField.setBounds(770,10,40,30);
        getContentPane().add(formNoField);
        
        l1.setBounds(280,30,400,40);
        getContentPane().add(l1); 
        
        l2.setBounds(100,80,200,30);
        getContentPane().add(l2);
        
        r1.setBounds(100,110,170,30);
        getContentPane().add(r1);
        
        r2.setBounds(350,110,300,30);
        getContentPane().add(r2);
        
        r3.setBounds(100,140,250,30);
        getContentPane().add(r3);
        
        r4.setBounds(350,140,250,30);
        getContentPane().add(r4);
        
        l3.setBounds(100,180,200,30);
        getContentPane().add(l3);
        
        l4.setBounds(350,180,250,30);
        getContentPane().add(l4);
        
        l5.setBounds(100,210,200,20);
        getContentPane().add(l5);
        
        l6.setBounds(350,210,500,20);
        getContentPane().add(l6);
        
        l7.setBounds(100,250,200,30);
        getContentPane().add(l7);
        
        l8.setBounds(350,250,200,30);
        getContentPane().add(l8);
        
        l9.setBounds(100,280,200,20);
        getContentPane().add(l9);
        
        l10.setBounds(100,320,200,30);
        getContentPane().add(l10);
        
        c1.setBounds(100,350,200,30);
        getContentPane().add(c1);
        
        c2.setBounds(350,350,200,30);
        getContentPane().add(c2);
        
        c3.setBounds(100,400,200,30);
        getContentPane().add(c3);
        
        c4.setBounds(350,400,200,30);
        getContentPane().add(c4);
        
        c5.setBounds(100,450,200,30);
        getContentPane().add(c5);
        
        c6.setBounds(350,450,200,30);
        getContentPane().add(c6);
        
        c7.setBounds(100,510,600,20);
        getContentPane().add(c7);
        
        b1.setBounds(300,550,150,30);
        getContentPane().add(b1);
        
        b2.setBounds(500,550,150,30);
        getContentPane().add(b2);
        formNoField.setBounds(730,7,100,30);
        
        getContentPane().setBackground(new Color(240, 248, 255));
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        String a = null;
        if(r1.isSelected()){ 
            a = "Saving Account";
        }
        else if(r2.isSelected()){ 
            a = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            a = "Current Account";
        }else if(r4.isSelected()){ 
            a = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        long first8 = Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        long first4 = Math.abs(first3);
        
        String s1 = "No",s2 = "No",s3 = "No",s4 = "No",s5 = "No",s6 = "No";
        int flag=0;
        if(c1.isSelected()){ 
            s1 = "Yes"; flag=1;
        }
        if(c2.isSelected()){ 
        	s2 = "Yes"; flag=1;
        }
        if(c3.isSelected()){ 
        	s3 = "Yes"; flag=1;
        }
        if(c4.isSelected()){ 
        	s4 = "Yes"; flag=1;
        }
        if(c5.isSelected()){ 
        	s5 = "Yes"; flag=1;
        }
        if(c6.isSelected()){ 
        	s6 = "Yes"; flag=1;
        }
        
        String c = formNoField.getText();
        
        
        try{
            
            if(ae.getSource()==b1){
                
                if(flag==0||a.equals("")||formNoField.equals("")){
                
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                
                }else{
                
                    
                    Conn c1 = new Conn();
                    JOptionPane.showMessageDialog(null, first8);
                    String q1 = "insert into signup3 values('"+c+"','"+a+"','"+first8+"','"+first4+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";  
                    String q2 = "insert into login values('"+first8+"','"+first4+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + first8 + "\n Pin:"+ first4);
                    
                    new Deposit().setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Signup3().setVisible(true);
    }
    
}


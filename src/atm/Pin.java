package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2,t3;
    JButton saveButton,backButton;                               
    JLabel l1,l2,l3,l4;
    
    Pin(){
    	getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
        
        setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("PIN CHANGE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"PIN CHANGE");
        
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        
        l2 = new JLabel("Current PIN:");
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        l3 = new JLabel("New PIN:");
        l3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        l4 = new JLabel("Re-Enter New PIN:");
        l4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        t3 = new JPasswordField();
        t3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
        
        saveButton = new JButton("SAVE");
        saveButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
    
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        
        saveButton.addActionListener(this);
        backButton.addActionListener(this);
        
        
        getContentPane().setLayout(null);
        
        l1.setBounds(201,89,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(100,212,150,40);
        getContentPane().add(l2);
        
        l3.setBounds(100,278,150,40);
        getContentPane().add(l3);
        
        l4.setBounds(100,348,200,40);
        getContentPane().add(l4);
        
        t1.setBounds(310,213,360,40);
        getContentPane().add(t1);
        
        t2.setBounds(310,279,360,40);
        getContentPane().add(t2);
        
        t3.setBounds(310,349,360,40);
        getContentPane().add(t3);
        
        saveButton.setBounds(201,460,179,50);
        getContentPane().add(saveButton);
        
        backButton.setBounds(400,460,172,50);
        getContentPane().add(backButton);
        
        
        
        
        getContentPane().setBackground(new Color(240, 248, 255));
        
        setSize(800,600);
        setLocation(500,90);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = String.valueOf(t1.getPassword());
            String b = String.valueOf(t2.getPassword());
            String c = String.valueOf(t3.getPassword());
            
            
            
            if(ae.getSource()==saveButton){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please Enter Current PIN");
                
                }
                if(t2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t3.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                if(t2.getText().equals(t3.getText())){
                    
                    Conn c1 = new Conn();
                    String q1 = "update bank set pin = '"+b+"' where pin = '"+a+"' ";
                    String q2 = "update login set pin = '"+b+"' where pin = '"+a+"' ";
                    String q3 = "update signup3 set pin = '"+b+"' where pin = '"+a+"' ";
                    
					/*
					 * if(q1.next())) { JOptionPane.showMessageDialog(null,
					 * "Invalid Pin!!\n\nExiting for Security purposes..."); System.exit(0); }
					 */
                    
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
                }
                    
                    
                    
                    
                
            }else if(ae.getSource()==backButton){
                
                new Transactions().setVisible(true);
                setVisible(false);
                
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    }

    
        
    
    public static void main(String[] args){
        new Pin().setVisible(true);
    }
}
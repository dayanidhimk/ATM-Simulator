package atm;

import javax.swing.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame implements ActionListener{
	JTextField pinNoField;
	JLabel l1,l2;
	JButton backButton, viewButton;
	JTable table;
	DefaultTableModel model;
    
	public MiniStatement() {
		getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		
		setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Mini Statement");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"Mini Statement");
        
    	//setBackground(new Color(240, 248, 255));
        
		/*
		 * setFont(new Font("Tempus Sans ITC", Font.BOLD, 22)); Font f = getFont();
		 * FontMetrics fm = getFontMetrics(f); int x = fm.stringWidth("Mini Statement");
		 * int y = fm.stringWidth(" "); int z = getWidth() - (5*x); int w = z/y;
		 * setTitle("Mini Statement");
		 */
		
        
        l1 = new JLabel("Mini Statement");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(109, 68, 576, 60);
        l1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        
		l2 = new JLabel("Enter Pin");
        l2.setBounds(580, 9, 80, 30);
        l2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        pinNoField = new JTextField();
        pinNoField.setBounds(660, 10, 80, 30);
        pinNoField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
        
        backButton = new JButton("BACK");
        backButton.setBounds(485, 470, 200, 50);
        backButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
		
		viewButton = new JButton("VIEW");
		viewButton.setForeground(Color.WHITE);
		viewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		viewButton.setBackground(Color.BLACK);
		viewButton.setBounds(109, 470, 200, 50);
		
		
		model = new DefaultTableModel(); 
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(300, 100));
		table.setFillsViewportHeight(true);
		model.addColumn("Credit");
		model.addColumn("Debit"); 
		model.addColumn("Balance");
		
		JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 700, 300); // Adjust the bounds as needed
		 
		
		getContentPane().add(viewButton);
		getContentPane().setLayout(null);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(pinNoField);
		getContentPane().add(backButton);
		getContentPane().add(scrollPane);
        getContentPane().setBackground(new Color(240, 248, 255));
		
		viewButton.addActionListener(this);
		backButton.addActionListener(this);
		
		setSize(800,600);
        setLocation(500,90);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		 
		try 
		{
			String pinNo=pinNoField.getText();
			if(ae.getSource() == viewButton)
			{	
				if(pinNoField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter the Pin number!");
				else
				{
										
					//DefaultTableModel model = (DefaultTableModel) table.getModel(); // Get the model from the table
                    model.setRowCount(0); // Clear previous data
                    
				    Conn c1 = new Conn();
                	
                	ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinNo+"' ORDER BY id ASC");
                	
                	if(!rs.next()){
                    	JOptionPane.showMessageDialog(null, "Invalid Pin!!\n\nExiting for Security purposes...");
                    	System.exit(0);
                    }
                	while(rs.next())
                	{
                		String cred=String.valueOf(rs.getDouble("credit"));
                		String deb=String.valueOf(rs.getDouble("debit"));
                		String bal=String.valueOf(rs.getDouble("balance"));
                	
                		//String tbData[]= {cred, deb, bal};
                		
                		
                		//JOptionPane.showMessageDialog(null, "Mini Balance Details "+cred+" \n\n\n "+deb+" \n\n\n "+bal+"");
	                	
                		model.addRow(new Object[]{cred, deb, bal});//Adding row in Table
                	}
				}
			}
			else if(ae.getSource() == backButton)
			{
				new Transactions().setVisible(true);
                setVisible(false);
			}
		}catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
    }
		
	}
	
	public static void main(String args[])
	{
		new MiniStatement().setVisible(true);
	}
}


/**
 *
 * @author Zubair Ahmed
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener{
    JLabel l1,l2,l4,l5;
    JTextField t1;
    Choice c1,c2;
    JButton b1,b2;
    JPanel p;
     String meter1 ;
    DeleteCustomer(){
        
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        
        l1 = new JLabel("Delete Customer");
        l1.setBounds(30, 10, 400, 30);
        
        l2 = new JLabel("Meter No");
        l2.setBounds(60, 70, 100, 30);
        
        JLabel l6 = new JLabel("Name");
        l6.setBounds(60, 150, 100, 30);
        
        JLabel l7 = new JLabel("Address");
        l7.setBounds(60, 220, 100, 30);
     
        c1 = new Choice();
        c1.setBounds(200, 70, 180, 20);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("meter"));
            }
        }catch(Exception e){}
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 150, 180, 20);
        p.add(l11);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 225, 180, 20);
        p.add(l12);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                l11.setText(rs.getString("name"));
                l12.setText(rs.getString("address"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l11.setText(rs.getString("name"));
                        l12.setText(rs.getString("address"));
                        c.c.close();
                        rs.close();
                    }
                }catch(Exception e){}
            }
        });
        
   
        
       
        
        b1 = new JButton("Delete");
        b1.setBounds(50, 350, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(230, 350, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        l1.setFont(new Font("Senserif",Font.PLAIN,26));
        l1.setHorizontalAlignment(JLabel.CENTER);

        p.add(l1);
        p.add(l2);
        p.add(l6);
        p.add(l7);
        p.add(c1);
     
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        add(p,"Center");

        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(750,500);
        setLocation(550,220);
    }
    
    public void delete(String meter){

            try{
                
                  Conn c=new Conn();
                  String sql="delete from customer where meter= ?";
                  PreparedStatement statement;
                  statement = c.c.prepareStatement(sql);
                
                  statement.setString(1 , meter);
                  statement.executeUpdate();

                  JOptionPane.showMessageDialog(null, "Customer Deleted Successfully");
                  this.setVisible(false);
            } catch(Exception e){
            System.out.println(e+meter1);
            }

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
              meter1 = c1.getSelectedItem();
         delete(meter1);
           
        }else if(ae.getSource()== b2){
            this.setVisible(false);
        }        
    }
    

    /*public static void main(String[] args){
        new DeleteCustomer().setVisible(true);
    }*/
    
    
    
    
    
    
}

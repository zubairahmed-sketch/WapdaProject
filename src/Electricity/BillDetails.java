
/**
 *
 * @author Zubair Ahmed
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BillDetails extends JFrame{
 
    JTable t1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        setSize(700,650);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t1 = new JTable(y,x);
        try{
             Conn c  = new Conn();
             String ucost  = "select cost_per_unit from tax ";
            ResultSet rs2  = c.s.executeQuery(ucost);
                   while(rs2.next())
                       ucost = rs2.getString("cost_per_unit");
        }
        catch(Exception e){
                e.printStackTrace();
        }
        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill where meter = " + meter;
            String ucost  = "select cost_per_unit from tax ";

            ResultSet rs  = c.s.executeQuery(s1);
             while(rs.next()){

                y[i][j++]=rs.getString("meter");
                y[i][j++]=rs.getString("month");
                y[i][j++]=rs.getString("units");
                y[i][j++]=rs.getString("total_bill");
                y[i][j++]=rs.getString("status");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
    }
    
   /* public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }*/
    
}
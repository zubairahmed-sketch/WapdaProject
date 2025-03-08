package Electricity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
    public class Conn {
    Connection c;
    public Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            s = c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }

}


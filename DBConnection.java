/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NSD COMPUTER04
 */
public class DBConnection {

    /**
     * @param args the command line arguments
     */

        // TODO code application logic here
        
    private  static Connection con=null;
        
        static
        {
        try
        {
          Class.forName("oracle.jdbc.driver.OracleDriver");
        // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","MYPROJECT","rampal");
           
  
      //  JOptionPane.showMessageDialog(null," connected successfully to the database","success",JOptionPane.INFORMATION_MESSAGE);
           
        }
        
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null," error loading driver"," error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }   
        catch (SQLException ex) {
             
                JOptionPane.showMessageDialog(null," error in db");
                ex.printStackTrace();
            }
        }
       
                
       
       
        public static Connection getConnection()
        {
         
        return con;
        }
            public static Connection getClose()
        {
        try{
            con.close();
            
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null," connection is not close");
         ex.printStackTrace();
        }
           return con;
        }
}

    



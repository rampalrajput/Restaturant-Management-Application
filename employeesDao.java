/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantfood.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static oracle.net.aso.C11.p;
import planetfood.db.DBConnection;
import planetfood.pojo.Cashier;
import planetfood.pojo.User;
import planetfood.pojo.employees;

/**
 *
 * @author NSD COMPUTER04
 */
public class employeesDao {
    
    /**
     *
     * @return
     */
    public static boolean updateemployees(employees e) throws SQLException
    {
                  {
        
        Connection con =DBConnection.getConnection();
        
           PreparedStatement ps = con.prepareStatement("update employees set job='Cashier 'where empid=? ");
        
      
             ps.setString(1,e.getEmpId());
     
       
       int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
    }
                     public static boolean updateemployeesjob(employees e) throws SQLException
    {
                  {
        
        Connection con =DBConnection.getConnection();
        
           PreparedStatement ps = con.prepareStatement("update employees set job= ? where empid=? ");
        
      
             ps.setString(1,e.getJob());
              ps.setString(2,e.getEmpId());
       
       int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
    
    
}
                        public static ArrayList <User> getempid(User u) throws SQLException
    {
        
        Connection con = DBConnection.getConnection();
        
           ArrayList<User>data=  new ArrayList<>();
        
           Statement st =con.createStatement();
           
               PreparedStatement ps = con.prepareStatement("select empid  from users where userid=?");
        
      
             ps.setString(1,u.getUserId());
           ResultSet rs =ps.executeQuery();
         
           while(rs.next())
           {
            
              
            u.setEmpid(rs.getString("empId"));
           
              
           data.add(u);
              
           }
           return  data ;
    }
}

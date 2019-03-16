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
import java.util.HashMap;
import planetfood.db.DBConnection;
import planetfood.pojo.Cashier;
import planetfood.pojo.User;
import planetfood.pojo.employees;


/**
 *
 * @author NSD COMPUTER04
 */
public class CashierDao {

    public static ArrayList <User> getemp() throws SQLException
    {
        
        Connection con = DBConnection.getConnection();
        
           ArrayList<User>data=  new ArrayList<>();
        
           Statement st =con.createStatement();
           
           ResultSet rs =st.executeQuery("select empid ,ename from employees where job='cashier' ");
         
           while(rs.next())
           {
              User obj = new User();
              
            obj.setEmpid(rs.getString("empId"));
            obj.setUsername(rs.getString("ename"));
              
           data.add(obj);
              
           }
           return  data ;
    }
                 public static boolean registerCashier(User p) throws SQLException
    {
        
        Connection con =DBConnection.getConnection();
        
        PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?)");
        
        
        ps.setString(1,p.getUserId());
         ps.setString(2,p.getUsername());
       ps.setString(3,p.getPassword());
         ps.setString(4,p.getEmpid());
         ps.setString(5, p.getUserType());
       
       int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
              public static boolean removeCashier(User e) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("delete from Users where userid=? and Usertype='Cashier' ");
            
                   ps.setString(1,e.getUserId());
                
          int x= ps.executeUpdate();
      
          
          if(x==0)
          return false;
          else
              return true;
}
                 public static ArrayList <Cashier>SearchCashier(Cashier e) throws SQLException
                
        {
                ArrayList<Cashier> obj= new ArrayList<>();
                
                
                 Connection con = DBConnection.getConnection();  
              //   Statement st =con.createStatement();
                
                      PreparedStatement ps = con.prepareStatement("select  empid from Cashier where userid=?");
                 ps.setString(1,e.getUserid());
                 ResultSet rs = ps.executeQuery();
                 
                 
        while(rs.next())
        {
          
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setEmpid(rs.getString("empid"));
       
         
             obj.add(e);
        }
        return obj;
        
}
           public static ArrayList <Cashier>empCashier() throws SQLException
                
        {
                ArrayList<Cashier> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
              //   Statement st =con.createStatement();
                 
                      PreparedStatement ps = con.prepareStatement("select empid  from Cashier  Users where job ='Cashier' ");
                 
                 ResultSet rs = ps.executeQuery();
                 
        while(rs.next())
        {
           Cashier e =new Cashier();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
      e.setEmpid(rs.getString("empid"));
         
             obj.add(e);
        }
        return obj;
        
}
                public static HashMap <String,User>getdetaliscashier(User u) throws SQLException
                
        {
              
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                   HashMap<String,User> userList = new HashMap<String ,User>();
               
            PreparedStatement ps =con.prepareStatement("select username ,empid from users where userid=?");
                 
                ps.setString(1,u.getUserId());
                ResultSet rs =ps.executeQuery();
                 
        while(rs.next())
        {     u.setUsername(rs.getString("username"));
         u.setEmpid(rs.getString("empid"));
       
        
         
         userList.put(u.getUserId(),u);
            
        }
        return userList;
        
}
}


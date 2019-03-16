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
import javax.swing.JOptionPane;
import planetfood.db.DBConnection;
import planetfood.pojo.User;
import planetfood.pojo.employees;

/**
 *
 * @author NSD COMPUTER04
 */
public class UserDao {
    
    /**
     *
     * @param user
     * @return
     */
    public static String ValidateUser(User user)   throws SQLException
    {
    
         Connection con = DBConnection.getConnection();
   // String qry =" select username from Users where userid = ?and password =? and usertype = ? ";
    
 //  PreparedStatement ps = con.prepareStatement(qry);
       PreparedStatement ps =con.prepareStatement("select username from users where userid = ? and password =? and usertype =?");
     
         ps.setString(1,user.getUserId());
         ps.setString(2,user.getPassword());
         ps.setString(3,user.getUserType());
         
         ResultSet  rs =ps.executeQuery();
         
        
               String username = null;
        while(rs.next())
         {
            
       //     JOptionPane.showMessageDialog(null, "start loop");
             username  =  rs.getString(1);
         
         }
         return username;
         }
        public static boolean addemployee(employees user) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
          //  System.out.println(con);
           
            //Statement st =con.createStatement();
            
              // PreparedStatement ps  ;
              // int x=st.executeUpdate("insert into emp values(?,?,?)");
      // PreparedStatement ps  =st.executeUpdate("insert into emp values(?,?,?)");
        PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?)");
          ps.setString(1, user.getEmpId());
          ps.setString(2, user.getEmpname());
          ps.setString(3, user.getJob());
           ps.setInt(4,user.getSal());
             
           int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
    
}
              public static boolean removeemployee( employees user) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("delete from employees where empid=?");
            
                   ps.setString(1,user.getEmpId());
                
                 int x= ps.executeUpdate();
      
          
          if(x==0)
          return false;
          else
              return true;
}
     public static boolean updateemployee(employees e) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("update employees set ename=?,job=?,Sal=? where empId=?");
            
              
               ps.setString(1, e.getEmpname());
                 ps.setString(2, e.getJob());
                  ps.setDouble(3, e.getSal());
                  ps.setString(4,e.getEmpId());
                
          int x= ps.executeUpdate();
      
          
          if(x==0)
          return false;
          else
              return true;
}
         
           public static ArrayList <employees>getviewAllEmployee() throws SQLException
                
        {
                ArrayList<employees> empList = new ArrayList<employees>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select * from employees");
                 
        while(rs.next())
        {
        employees e =new employees();
        e.setEmpId(rs.getString("empId"));
        e.setEmpname(rs.getString("ename"));
        e.setJob(rs.getString("job"));
         e.setSal((int) rs.getDouble("sal"));
         
         empList.add(e);
            
        }
        return empList;
        
}

               public static String getempId() throws SQLException
    {
        
          Connection con =DBConnection.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from employees");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          return "E"+id;
    }
            public static ArrayList <employees>getviewAllemp() throws SQLException
                
        {
                ArrayList<employees> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select empid from employees");
                 
        while(rs.next())
        {
           employees e =new employees();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setEmpId(rs.getString("empid"));
         
             obj.add(e);
        }
        return obj;
        
}
                  public static HashMap <String,employees>getdetalisemp(employees e) throws SQLException
                
        {
                HashMap<String,employees> empList = new HashMap<String ,employees>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
               
            PreparedStatement ps =con.prepareStatement("select ename ,job,sal from employees where empid=?");
                 
                ps.setString(1,e.getEmpId());
                ResultSet rs =ps.executeQuery();
                 
        while(rs.next())
        {     e.setEmpname(rs.getString("ename"));
         e.setSal(rs.getInt("Sal"));
        e.setJob(rs.getString("job"));
        
         
         empList.put(e.getEmpId(),e);
            
        }
        return empList;
        
}
                           public static String getempname(employees e) throws SQLException
                
        {
                ArrayList<employees> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                       PreparedStatement ps =con.prepareStatement("select ename from employees where empid=?");
                       
                       ps.setString(1,e.getEmpId());
                 ResultSet rs = ps.executeQuery();
                 
                  
            String str=null;
                  
        while(rs.next())
        {
          
       str= rs.getString("ename") ;
        }
        return str;
        
}
 

}
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
import planetfood.pojo.Categories;
import planetfood.pojo.product;

/**
 *
 * @author NSD COMPUTER04
 */
public class CategoryDao {
    
    public static HashMap<String,String> getAllCategoryId() throws Exception
    {
    Connection con =DBConnection.getConnection();
    
    Statement  st =con.createStatement();
    
    ResultSet rs = st.executeQuery("Select * from Categories");
    
    HashMap <String,String> categories=new HashMap<>();
    
    while (rs.next())
    {
        String catName=rs.getString(1);
        String catid=rs.getString(2);
        
         categories.put(catid,catName);
    }
     
    return categories;
}
       public static String catid(Categories e) throws SQLException
    {
          Connection con =DBConnection.getConnection();
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
            PreparedStatement ps =con.prepareStatement("select cat_Id from categories where cat_name= ?");
             
                  ps.setString(1,e.getCatname());
                   
                 ResultSet rs = ps.executeQuery();
               
                String Catid=null;
                
                     while(rs.next())
                {
                      
                   Catid=rs.getString(1);
                }      
                  
                return Catid;
                
    }
        public static String getNewId() throws SQLException
    {
        
          Connection con =DBConnection.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from categories");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          return "C"+id;
    }
           
    public static boolean addcategory(Categories obj) throws SQLException
    {
        
        Connection con =DBConnection.getConnection();
        
        PreparedStatement ps = con.prepareStatement("insert into categories values(?,?)");
        
        
        ps.setString(1,obj.getCatId());
         ps.setString(2,obj.getCatname());
      
       int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
         public static ArrayList <Categories>getviewAllcatId() throws SQLException
                
        {
                ArrayList<Categories> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select cat_id from Categories");
                 
        while(rs.next())
        {
           Categories e =new Categories();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setCatId(rs.getString("cat_Id"));
         
             obj.add(e);
        }
        return obj;
        
}
       
                     public static boolean updatecategory(Categories e) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("update categories set cat_name =? where cat_id=? ");
            
              
               ps.setString(1, e.getCatname());
                 ps.setString(2, e.getCatId());
            
             int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
                     
                          public static ArrayList <Categories>getviewAllcategories() throws SQLException
                
        {
                ArrayList<Categories> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select *  from Categories");
                 
        while(rs.next())
        {
           Categories e =new Categories();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setCatId(rs.getString("cat_Id"));
          e.setCatname(rs.getString("cat_name"));
         
             obj.add(e);
        }
        return obj;
        
}
                            public static HashMap<String,Categories> getsingleCategoryId(Categories e) throws Exception
    {
    Connection con =DBConnection.getConnection();
     HashMap <String,Categories> categories=new HashMap<>();
      Statement  st =con.createStatement();
        PreparedStatement ps = con.prepareStatement("Select Cat_name from Categories where cat_id=?");
   
    
    ps.setString(1, e.getCatId());
     ResultSet rs = ps.executeQuery();
   
    
    while (rs.next())
    {
     
  e.setCatname(rs.getString("Cat_name"));
        
         categories.put(e.getCatId(), e);
    }
     
    return categories;
}
}

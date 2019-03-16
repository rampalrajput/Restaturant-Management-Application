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
public class ProductDao {
    
    
    public static String getNewId() throws SQLException
    {
        
          Connection con =DBConnection.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from products");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          return "P"+id;
    }
 
 
    
    public static boolean addproduct(product p) throws SQLException
    {
        
        Connection con =DBConnection.getConnection();
        
        PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?,?)");
        
        
        ps.setString(1,p.getProdId());
         ps.setString(2,p.getCatId());
         ps.setString(3,p.getProdName());
        ps.setDouble(4,p.getProprice());
         ps.setString(5,p.getIsActive());
       int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
    
       public static HashMap<String,String> removeproduct() throws Exception
    {
    Connection con =DBConnection.getConnection();
    
    Statement  st =con.createStatement();
    
    ResultSet rs = st.executeQuery("Select  Prod_id ,Cat_Id from products");
    
    HashMap <String,String> products=new HashMap<>();
    
    while (rs.next())
    {
      String prod_id=rs.getString(1);
        String Cat_id=rs.getString(2);
        
         products.put(prod_id, Cat_id);
    }
     
    return products;
}
        
          public static ArrayList <product>getviewAllprodId() throws SQLException
                
        {
                ArrayList<product> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select prod_id from products");
                 
        while(rs.next())
        {
            product e =new product();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setProdId(rs.getString("prod_Id"));
         
             obj.add(e);
        }
        return obj;
        
}
                   public static boolean removeproduct(product p) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("update  products set Active='N' where CAT_ID=? and prod_Id=?");
            
                 
                   ps.setString(1,p.getCatId());
                   ps.setString(2,p.getProdId());
                
              int x= ps.executeUpdate();
      
          
          if(x==0)
          return false;
          else
              return true;
}
                     public static boolean updateproduct(product e) throws SQLException
        {
           Connection con = DBConnection.getConnection();  
            
             PreparedStatement ps = con.prepareStatement("update products set Prod_name =?,prod_price=?,Active=? where Prod_Id=?  and Cat_Id= ? ");
            
              
               ps.setString(1, e.getProdName());
                 ps.setDouble(2, e.getProprice());
                 ps.setString(3, e.getIsActive());
                  ps.setString(4,e.getProdId());
                  ps.setString(5, e.getCatId());
                
             int x= ps.executeUpdate();
      
          
          if(x>0)
          return true;
          else
              return false;
}
         public static ArrayList <product>getviewAllproducts() throws SQLException
                
        {
                ArrayList<product> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select *  from products");
                 
        while(rs.next())
        {
           product e =new product();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setProdId(rs.getString("Prod_Id"));
          e.setCatId(rs.getString("cat_Id"));
          e.setProdName(rs.getString("Prod_name"));
          e.setProprice(rs.getDouble("Prod_price"));
          e.setIsActive(rs.getString("Active"));
         
             obj.add(e);
        }
        return obj;
}
          public static ArrayList <product>getproductsid() throws SQLException
                
        {
                ArrayList<product> obj= new ArrayList<>();
                
                 Connection con = DBConnection.getConnection();  
                 Statement st =con.createStatement();
                 
                 ResultSet rs = st.executeQuery("select *  from products");
                 
        while(rs.next())
        {
           product e =new product();
     
        
   //    e.setProdId(rs.getString("prod_id"));
       
          e.setProdId(rs.getString("Prod_Id"));
          e.setCatId(rs.getString("cat_Id"));
          e.setProdName(rs.getString("Prod_name"));
          e.setProprice(rs.getDouble("Prod_price"));
          e.setIsActive(rs.getString("Active"));
         
             obj.add(e);
        }
        return obj;
        }
      public static HashMap <String,product>getviewsingleproducts(String catid) throws SQLException
                
        {
            
                    Connection con = DBConnection.getConnection();  
                    
                HashMap<String,product>prodList =new HashMap<String,product>();
                String qry ="select cat_id,Prod_id,prod_name,prod_price from products where cat_Id =?";
         
              
           
            PreparedStatement ps = con.prepareStatement(qry);
                 
             ps.setString(1,catid);
             
             ResultSet rs =ps.executeQuery();
             
              product e =new product();
     
        
   //    e.setProdId(rs.getString("prod_id"));
   while(rs.next())
   {
       //JOptionPane.showMessageDialog(null,"withen in loop");
       e.setCatId(rs.getString("cat_id"));
          e.setProdId(rs.getString("Prod_Id"));
     e.setProdName(rs.getString("Prod_name"));
      e.setProprice(rs.getDouble("Prod_price"));
  
     
         
             prodList.put(e.getProdId(), e);
        }
        return prodList;
}
          public static HashMap<String,product> getProductsByCategory(String catId)throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       
       
      String qry="Select * from Products where cat_id=?";
      
       PreparedStatement ps=conn.prepareStatement(qry);
       
       HashMap<String,product> productList=new HashMap<String,product>();
       ps.setString(1, catId);
       
       ResultSet rs=ps.executeQuery();
       
       while(rs.next()){
            product p=new product();
       
            p.setProdId(rs.getString("prod_id"));
            p.setCatId("CAT_ID");
            p.setProdName(rs.getString("prod_name"));
            p.setProprice(rs.getDouble("prod_price"));
            p.setIsActive(rs.getString("active"));
            productList.put(p.getProdId(), p);
          }
       return productList;
           
    }
    public static ArrayList<product> getProductsCategory(String catId)throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       
       
      String qry="Select * from Products where cat_id=?";
      
       PreparedStatement ps=conn.prepareStatement(qry);
       
       ArrayList<product> productList=new ArrayList<>();
       ps.setString(1, catId);
       
       ResultSet rs=ps.executeQuery();
       
       while(rs.next()){
            product p=new product();
       
            p.setProdId(rs.getString("prod_id"));
            p.setCatId(rs.getString("cat_id"));
            p.setProdName(rs.getString("prod_name"));
            p.setProprice(rs.getDouble("prod_price"));
            p.setIsActive(rs.getString("active"));
         
            productList.add(p);
          }
       return productList;
           
    }
}
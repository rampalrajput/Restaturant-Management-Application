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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import planetfood.db.DBConnection;
import planetfood.pojo.OrderDetalis;
import planetfood.pojo.Orders;
import planetfood.pojo.UserProfile;

/**
 *
 * @author NSD COMPUTER04
 */
public class OrderDao {
    
    
    public static ArrayList<Orders>getOrdersDate(Date StartDate,Date endDate ) throws SQLException
    {
        
     Connection con =DBConnection.getConnection();
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
    PreparedStatement ps =con.prepareStatement("select * from orders where ord_date between ? and ?");
    
    long ms1=StartDate.getTime();
    long ms2 =endDate.getTime();
    
    java.sql.Date d1 =new java.sql.Date(ms1);
      java.sql.Date d2 =new java.sql.Date(ms2);
    
      ps.setDate(1, d1);
      ps.setDate(2, d2);
      
      ArrayList<Orders>orderList =new ArrayList<>();
      
      ResultSet rs =ps.executeQuery();
      
      while(rs.next())
      {
          
          Orders obj = new Orders();
          
          obj.setOrdid(rs.getString("ord_id"));
          
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
          
          java.sql.Date d= rs.getDate("ord_Date");
          
          String datestr = date.format(d);
          
           obj.setOrdDate(datestr);
          obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserid(rs.getString("user_id"));
           
           orderList.add(obj);
           
          
          
          
      }
      
           return orderList;  
    }
      public static ArrayList<Orders>getOrders() throws SQLException
    {
        
     Connection con =DBConnection.getConnection();
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
    PreparedStatement ps =con.prepareStatement("select * from orders ");
    
   
      
      ArrayList<Orders>orderList =new ArrayList<>();
      
      ResultSet rs =ps.executeQuery();
      
      while(rs.next())
      {
          
          Orders obj = new Orders();
          
          obj.setOrdid(rs.getString("ord_id"));
          
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
          
          java.sql.Date d= rs.getDate("ord_Date");
          
          String datestr = date.format(d);
          
           obj.setOrdDate(datestr);
          obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserid(rs.getString("user_id"));
           
           orderList.add(obj);
           
          
          
          
      }
      
           return orderList;  
    }
    public static String getneworderid() throws SQLException
    {
        
             Connection con =DBConnection.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from Orders");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          return "ODI-"+id;
    }
   
    public static boolean addorder(Orders order,ArrayList<OrderDetalis>OrderList) throws Exception
    {
           Connection con =DBConnection.getConnection();
           
           
                 
  
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
    PreparedStatement ps =con.prepareStatement("insert into Orders values(?,?,?,?,?,?,?,?)");
    
   ps.setString(1,order.getOrdid());
 
   //String datestr =order.getOrdDate();
   SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
   
  java.util.Date d1   =  date.parse(order.getOrdDate());
  
  java.sql.Date d2 = new java.sql.Date(d1.getTime());
  
  ps.setDate(2, d2);
  ps.setDouble(3,order.getGst());
  ps.setDouble(4,order.getGstAmount());
  ps.setDouble(5, order.getDiscount());
  ps.setDouble(6,order.getGrandTotal());
  ps.setString(7, order.getUserid());
  ps.setDouble(8,order.getOrdAmount());
  
  int x =ps.executeUpdate();
  
     PreparedStatement ps2 =con.prepareStatement("insert into Order_ detalis values(?,?,?,?)");
  
                
     int count =0,y;
     for(OrderDetalis detail : OrderList)
     {
  ps2.setString(1, detail.getOrdid());
  ps2.setString(2, detail.getProdid());
  ps2.setDouble(3,detail.getQuantity());
  ps2.setDouble(4,detail.getCost());
  
  y=ps.executeUpdate();
     
 if(y>0)
 
     count=count+y;
       
     }
    if(x>0 && count==OrderList.size())
        return true;
    else
        return false;
        
        
    
}
       public static boolean addorder(Orders order) throws Exception
    {
           Connection con =DBConnection.getConnection();
           
           
                 
  
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
    PreparedStatement ps =con.prepareStatement("insert into Orders values(?,?,?,?,?,?,?,?)");
    
   ps.setString(1,order.getOrdid());
 
   //String datestr =order.getOrdDate();
   SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
   
  java.util.Date d1   =  date.parse(order.getOrdDate());
  
  long ms = d1.getTime();
  
  java.sql.Date d2 = new java.sql.Date(ms);
  
  ps.setDate(2, d2);
  ps.setDouble(3,order.getGst());
  ps.setDouble(4,order.getGstAmount());
  ps.setDouble(5, order.getDiscount());
  ps.setDouble(6,order.getGrandTotal());
  ps.setString(7, order.getUserid());
  ps.setDouble(8,order.getOrdAmount());
  
  int x =ps.executeUpdate();
  
    
    if(x>0 )
        return true;
    else
        return false;
        
        
    
}
          
    public static ArrayList<Orders>getcashierOrdersDate(Date StartDate,Date endDate ) throws SQLException
    {
        
     Connection con =DBConnection.getConnection();
         //    Statement st = con.createStatement("select cat_Id from categories where cat_name= ?");
    PreparedStatement ps =con.prepareStatement("select  * from orders where ord_date between ? and ?  ");
    
    long ms1=StartDate.getTime();
    long ms2 =endDate.getTime();
    
    java.sql.Date d1 =new java.sql.Date(ms1);
      java.sql.Date d2 =new java.sql.Date(ms2);
    
      ps.setDate(1, d1);
      ps.setDate(2, d2);
      
      ArrayList<Orders>orderList =new ArrayList<>();
      
      ResultSet rs =ps.executeQuery();
      String userid= UserProfile.getUserid();
      
      while(rs.next())
      {
          if(rs.getString("user_id").equalsIgnoreCase(userid))
          {
          Orders obj = new Orders();
          
          obj.setOrdid(rs.getString("ord_id"));
          
          SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
          
          java.sql.Date d= rs.getDate("ord_Date");
          
          String datestr = date.format(d);
          
           obj.setOrdDate(datestr);
          obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserid(rs.getString("user_id"));
           
           orderList.add(obj);
           
          
          }
          
      }
      
           return orderList;  
    }
}


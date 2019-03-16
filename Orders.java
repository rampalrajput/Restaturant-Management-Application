/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.pojo;

import java.util.Date;

/**
 *
 * @author NSD COMPUTER04
 */
public class Orders {
 private String  Ordid;
  private  String OrdDate;
    private  double gst;
      private  double gstAmount;
        private  double discount;
          private  double ordAmount;
            private  double grandTotal;
   private String  Userid;

    public String getOrdid() {
        return Ordid;
    }

    public void setOrdid(String Ordid) {
        this.Ordid = Ordid;
    }

    public String getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(String OrdDate) {
        this.OrdDate = OrdDate;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

}

package ibfday23.app.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    private int id;
    private DateTime orderDate;
    private int custId;
    private double price;
    private double costPrice;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public DateTime getOrderDate() {return orderDate;}
    public void setOrderDate(DateTime dateTime) {this.orderDate = dateTime;}
    
    public int getCustId() {return custId;}
    public void setCustId(int custId) {this.custId = custId;}
    
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    
    public double getCostPrice() {return costPrice;}
    public void setCostPrice(double costPrice) {this.costPrice = costPrice;}

    public Order() {
    }

    public Order(int id, DateTime orderDate, int custId, double price, double costPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.custId = custId;
        this.price = price;
        this.costPrice = costPrice;
    }

    public static Order create(SqlRowSet rs){
        Order order = new Order();
        order.setId(rs.getInt("order_id"));
        order.setOrderDate(getDateTime(rs.getString("order_date")));
        order.setCustId(rs.getInt("customer_id"));
        order.setPrice(rs.getDouble("discounted_price"));
        order.setCostPrice(rs.getDouble("cost_price"));
        return order;
    }

    public static DateTime getDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dateTime = formatter.parseDateTime(date);
        return dateTime;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", custId=" + custId + ", price=" + price
                + ", costPrice=" + costPrice + "]";
    }

    
}

package ibfday23.app.repository;

public class DBQuery {
    public static final String DISPLAY_ORDER_TABLE="""
                                            select o.id as order_id, DATE_FORMAT(o.order_date, "%d/%m/%Y") as order_date, o.customer_id,
                                            sum(od.quantity * od.unit_price) as total_price,
                                            sum(od.quantity * od.unit_price * od.discount) as discount,
                                            sum(od.quantity * od.unit_price) - sum(od.quantity * od.unit_price * od.discount) as discounted_price,
                                            sum(od.quantity * p.standard_cost) as cost_price
                                            from Orders o
                                            left join Order_details od on o.id = od.order_id
                                            left join products p on od.product_id = p.id 
                                            where o.id = ?
                                            """;
}

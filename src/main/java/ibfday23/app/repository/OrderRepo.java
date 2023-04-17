package ibfday23.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibfday23.app.model.Order;
import static ibfday23.app.repository.DBQuery.*;

@Repository
public class OrderRepo {
    @Autowired
    JdbcTemplate template;

    public Order orderIdDetails(int id){
        List<Order> result = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(DISPLAY_ORDER_TABLE, id);
        while(rs.next())
            result.add(Order.create(rs));
        return result.get(0);

    }
}

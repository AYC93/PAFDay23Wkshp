package ibfday23.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibfday23.app.model.Order;
import ibfday23.app.repository.OrderRepo;
import ibfday23.app.service.FieldError;

@Controller
@RequestMapping
public class OrderController {
  
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    FieldError fieldError;

    // @GetMapping
    // public String inputOrderID(){
    //     return "index";
    // }

    @GetMapping("/order/total")
    public String thInputToPath(@RequestParam String id){
        System.out.println("call into this function");
        return "redirect:/order/total/" + id;
    }

    @GetMapping(path="/order/total/{id}")
    public String getOrderId(Model m, @ModelAttribute Order order, @PathVariable String id){
        try {
            order = orderRepo.orderIdDetails(Integer.parseInt(id));
        
            m.addAttribute("order", order);
            
            System.out.println(order.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
            m.addAttribute("error", true);
        }
       
        return "index";
    }

    // order.setId(rs.getInt("order_id"));
    // order.setOrderDate(DateTimeFormat
    //             .forPattern("dd/MM/yyyy")
    //             .parseDateTime(rs
    //             .getString("order_date")));
    // order.setCustId(rs.getInt("customer_id"));
    // order.setPrice(rs.getDouble("discounted_price"));
    // order.setCostPrice(rs.getDouble("cost_price"));
}

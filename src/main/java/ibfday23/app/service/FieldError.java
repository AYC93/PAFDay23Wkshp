package ibfday23.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ibfday23.app.model.Order;
import ibfday23.app.repository.OrderRepo;

@Service
public class FieldError {
    @Autowired
    private OrderRepo orderRepo;
    
    public void validateIdInput(Order o, int id, BindingResult br){
        Order order = orderRepo.orderIdDetails(id);

        if((o.getId() != (order.getId()))){
            br.rejectValue("id", "invalid.id", "Please input valid Id");
        }
    }
}
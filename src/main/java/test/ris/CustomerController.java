package test.ris;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static Gson GSON = new Gson();

    @Autowired
    private CustomerServiceValid customerServiceValid;
//    @Autowired
//    private CustomerServiceInvalid customerServiceInvalid;

    @GetMapping()
    public String getAllCustomers() {
        return GSON.toJson(customerServiceValid.getAllCustomers());
    }

    @GetMapping("/{lastname}")
    public String getForLastName(@PathVariable(name = "lastname")final String lastName) {
        return GSON.toJson(customerServiceValid.findByLastName(lastName));
    }
}

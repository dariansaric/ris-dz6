package test.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceInvalid {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceInvalid(CustomerRepository customerRepository) {
        this.customerRepository = Objects.requireNonNull(customerRepository);
    }

//    private static boolean validateStringParameter(String param) {
//        try {
//            Objects.requireNonNull(param);
//            if (!param.matches("[\\w-]+")) {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//
//        return true;
//    }

    List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

}

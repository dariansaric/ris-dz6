package test.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return customerRepository.findByLastName(lastName)
                .stream().map(this::convertToObject).collect(Collectors.toList());
    }

    private Customer convertToObject(CustomerEntity e) {
        return new Customer(e.getId(), e.getFirstName(), e.getLastName());
    }

    private CustomerEntity convertToEntity(Customer c) {
        CustomerEntity e = customerRepository.findById(c.getId()).orElse(null);
        if (e == null) {
            return null;
        }

        e.setFirstName(c.getFirstName());
        e.setLastName(c.getLastName());

        return e;
    }

}

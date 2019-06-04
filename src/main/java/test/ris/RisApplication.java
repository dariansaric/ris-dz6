package test.ris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RisApplication {
    //todo: napraviti lošu uslugu
    //todo: napisati definicije testova
    //todo: proširiti customer da ima smislene validacije
    //todo: napraviti uslugu za dodavanje customer i čitanje po ID

    private static final Logger log = LoggerFactory.getLogger(RisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RisApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new CustomerEntity("Jack", "Bauer"));
            repository.save(new CustomerEntity("Chloe", "O'Brian"));
            repository.save(new CustomerEntity("Kim", "Bauer"));
            repository.save(new CustomerEntity("David", "Palmer"));
            repository.save(new CustomerEntity("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (CustomerEntity customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
package test.ris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.ris.data.FizickaOsobaEntity;
import test.ris.data.FizickaOsobaRepository;
import test.ris.data.PruzateljUslugaEntity;
import test.ris.data.PruzateljUslugaRepository;

import java.sql.Date;


@SpringBootApplication
public class RisApplication {
    //todo: napraviti lošu uslugu
    //todo: napisati definicije testova

    private static final Logger log = LoggerFactory.getLogger(RisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RisApplication.class);
    }

    @Bean
    public CommandLineRunner demo(PruzateljUslugaRepository r1, FizickaOsobaRepository r2) {
        return (args) -> {
            // save a couple of customers
            r1.save(new PruzateljUslugaEntity("00001", "Ilica 1"));
            r1.save(new PruzateljUslugaEntity("00002", "Ilica 2"));
            r2.save(new FizickaOsobaEntity(r1.findById("00001").get().getOib(),
                    "Ivo",
                    "Ivić",
                    Date.valueOf("1990-1-1")));

//            repository.save(new CustomerEntity("Jack", "Bauer", testResults));
//            repository.save(new CustomerEntity("Chloe", "O'Brian", testResults));
//            repository.save(new CustomerEntity("Kim", "Bauer", testResults));
//            repository.save(new CustomerEntity("David", "Palmer", testResults));
//            repository.save(new CustomerEntity("Michelle", "Dessler", testResults));

            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (CustomerEntity customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            repository.findById(1L)
//                    .ifPresent(customer -> {
//                        log.info("Customer found with findById(1L):");
//                        log.info("--------------------------------");
//                        log.info(customer.toString());
//                        log.info("");
//                    });
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
        };
    }

}

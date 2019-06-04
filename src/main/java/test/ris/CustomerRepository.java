package test.ris;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);
}
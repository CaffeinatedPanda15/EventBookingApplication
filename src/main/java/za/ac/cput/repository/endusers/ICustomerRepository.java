package za.ac.cput.repository.endusers;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.endusers.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

}

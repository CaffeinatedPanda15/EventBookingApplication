
package za.ac.cput.repository.endusers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.endusers.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}

//there is no need to write any implementations such as create,update etc beacuse spring boot generates it at runtime
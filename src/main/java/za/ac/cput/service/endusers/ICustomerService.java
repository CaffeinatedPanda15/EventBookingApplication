package za.ac.cput.service.endusers;

import za.ac.cput.domain.endusers.Customer;
import java.util.List;

public interface ICustomerService {
    
    Customer create(Customer customer);

    Customer login(String email, String password);

    Customer read(String customerId);
    Customer update(Customer customer);
    boolean delete(String customerId);
    List<Customer> getAll();
}


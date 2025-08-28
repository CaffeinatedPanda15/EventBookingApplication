package za.ac.cput.service;

import za.ac.cput.domain.endusers.Customer;
import java.util.List;

public interface ICustomerService {
    
    Customer create(Customer customer);
    Customer read(String customerId);
    Customer update(Customer customer);
    boolean delete(String customerId);
    List<Customer> getAll();
}

//this tells us what operations the class must provide for us
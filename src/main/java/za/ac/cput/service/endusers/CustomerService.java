package za.ac.cput.service.endusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.repository.endusers.ICustomerRepository;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository repository;

    @Autowired
    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        return repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (repository.existsById(customer.getUserName())) {
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        if (repository.existsById(customerId)) {
            repository.deleteById(customerId);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }


    @Override
    public Customer login(String email, String password) {
        Customer customer = repository.findByEmailAddress(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}//end of class


package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.repository.endusers.ICustomerRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> result = repository.findById(customerId);
        return result.orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
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
}


// we got our service annotation, dependency injection(ICustomerRepository) and crud operations
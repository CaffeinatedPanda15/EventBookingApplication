package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.service.ICustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService service;

    @Autowired
    public CustomerController(ICustomerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable("id") String customerId) {
        return service.read(customerId);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String customerId) {
        return service.delete(customerId);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return service.getAll();
    }
}


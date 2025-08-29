package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;
import za.ac.cput.factory.endusers.CustomerFactory;
import za.ac.cput.repository.endusers.ICustomerRepository;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerServiceTest {


    @Autowired
    private ICustomerService service;

    private Customer c1;



    @BeforeEach
    void setUp() {
        c1 = CustomerFactory.createCustomer("john_doe", "John Doe", "johnDOw@gmail.com",
                "password123", UserType.CUSTOMER, "123 Main St", "555-1234");

    }


    @Test
    void create() {
        Customer newCustomer = service.create(c1);
        assertNotNull(c1);
        System.out.println(c1.toString());
    }

    @Test
    void read() {
        Customer read = service.read(c1.getUserName());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Customer updatednew = new Customer.Builder().copy(c1).setFullname("Jane Doe").build();
        Customer updated = service.update(updatednew);
        assertNotNull(updated);
        System.out.println(updated);
    }

}
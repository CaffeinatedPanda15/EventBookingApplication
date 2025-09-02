package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;
import za.ac.cput.factory.endusers.CustomerFactory;
import za.ac.cput.service.endusers.ICustomerService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class CustomerServiceTest {


    @Autowired
    private javax.sql.DataSource dataSource;


    @Autowired
    private ICustomerService service;

    private Customer c1;

    @Test
    void testConnection() throws Exception {
        assertNotNull(dataSource.getConnection());
        System.out.println("SQLite connection works!");
    }

    @BeforeEach
    void setUp() {

        c1 = CustomerFactory.createCustomer(
                "john_doe",
                "John Doe",
                "johnDOw@gmail.com",
                "password123",
                UserType.CUSTOMER,
                "123 Main St",
                "555-1234"
        );


        service.create(c1);
    }

    @Test
    void create() {
        Customer newCustomer = CustomerFactory.createCustomer(
                "jane_doe",
                "Jane Doe",
                "jane@gmail.com",
                "securepass",
                UserType.CUSTOMER,
                "456 Main St",
                "555-5678"
        );

        Customer saved = service.create(newCustomer);

        assertNotNull(saved);
        assertEquals("jane_doe", saved.getUserName());
        assertEquals("Jane Doe", saved.getFullname());
        System.out.println(saved);
    }

    @Test
    void read() {
        Customer read = service.read(c1.getUserName());
        assertNotNull(read);
        assertEquals("john_doe", read.getUserName());
        assertEquals("John Doe", read.getFullname());
        System.out.println(read);
    }

    @Test
    void update() {
        Customer updatedNew = new Customer.Builder()
                .copy(c1)
                .setFullname("Jane Doe")
                .build();

        Customer updated = service.update(updatedNew);

        assertNotNull(updated);
        assertEquals("Jane Doe", updated.getFullname());
        System.out.println(updated);
    }
}

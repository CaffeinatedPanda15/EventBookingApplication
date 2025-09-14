package za.ac.cput.factory.endusers;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {


    Customer c1 = CustomerFactory.createCustomer("john_doe", "John Doe", "johnDOw@gmail.com",
            "password123", UserType.CUSTOMER, "123 Main St", "555-1234");

    @Test
    void testCreateCustomer() {
        assertNotNull(c1);
        System.out.println(c1.toString());




    }

}
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;
import za.ac.cput.factory.endusers.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    private static Customer a1 = AdminFactory.createAdmin("admin123", "Admin User", "5555@gmail.com",
            "adminspassword", UserType.valueOf("ADMIN"), "555 Admin Street", "123456789");

    @Test
    void createAdmin() {
        assertNotNull(a1);
        System.out.println(a1.toString());
    }


}
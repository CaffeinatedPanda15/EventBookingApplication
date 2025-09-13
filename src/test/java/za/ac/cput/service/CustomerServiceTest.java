package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.factory.endusers.AdminFactory;
import za.ac.cput.service.endusers.IAdminService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    private javax.sql.DataSource dataSource;

    @Autowired
    private IAdminService service;

    private Admin a1;

    private final String SYSTEM_ADMIN = "system"; // used as creator in tests

    @BeforeEach
    void setUp() {
        a1 = AdminFactory.createAdmin(
                "admin01",
                "System Admin",
                "admin01@example.com",
                "password123"
        );

        service.create(a1, SYSTEM_ADMIN);
    }

    @Test
    void testConnection() throws Exception {
        assertNotNull(dataSource.getConnection());
        System.out.println("Database connection works!");
    }

    @Test
    void create() {
        Admin newAdmin = AdminFactory.createAdmin(
                "admin02",
                "Admin Two",
                "admin02@example.com",
                "securepass"
        );

        Admin saved = service.create(newAdmin, SYSTEM_ADMIN);

        assertNotNull(saved);
        assertEquals("admin02", saved.getUserName());
        assertEquals("Admin Two", saved.getFullName());
        assertEquals(SYSTEM_ADMIN, saved.getCreatedBy());       // verify creator
        assertNotNull(saved.getCreatedDate());                  // verify createdDate
        System.out.println(saved);
    }

    @Test
    void read() {
        Admin read = service.read(a1.getUserName());
        assertNotNull(read);
        assertEquals("admin01", read.getUserName());
        assertEquals("System Admin", read.getFullName());
        assertEquals(SYSTEM_ADMIN, read.getCreatedBy());
        System.out.println(read);
    }

    @Test
    void update() {
        Admin updatedAdmin = new Admin.Builder()
                .copy(a1)
                .setFullName("Updated Admin Name")
                .build();

        Admin updated = service.update(updatedAdmin);

        assertNotNull(updated);
        assertEquals("Updated Admin Name", updated.getFullName());
        assertEquals(SYSTEM_ADMIN, updated.getCreatedBy());  // createdBy remains unchanged
        System.out.println(updated);
    }

    @Test
    void login() {
        Admin loggedIn = service.login("admin01@example.com", "password123");
        assertNotNull(loggedIn);
        assertNotNull(loggedIn.getLastLogin()); // ensure lastLogin is updated
        System.out.println(loggedIn);
    }
}

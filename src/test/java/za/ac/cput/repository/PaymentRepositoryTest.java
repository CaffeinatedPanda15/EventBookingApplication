//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.eventfactories.PaymentFactory;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentRepositoryTest {

    @Autowired
    private IPaymentRepository repository;

    private Payment payment;

    @BeforeEach
    void setUp() {
        repository.deleteAll(); // clear table before each test

        payment = PaymentFactory.createPayment(
                1,
                500.00,
                new Date(),
                "Credit Card",
                Payment.Status.Successful
        );
    }

    @Test
    void create() {
        Payment created = repository.save(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentID(), created.getPaymentID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.save(payment);
        Payment read = repository.findById(payment.getPaymentID()).orElse(null);
        assertNotNull(read);
        assertEquals(payment.getPaymentID(), read.getPaymentID());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.save(payment);
        Payment updatedPayment = new Payment.Builder()
                .copy(payment)
                .withAmount(750.00)
                .withStatus(Payment.Status.Pending)
                .build();

        Payment updated = repository.save(updatedPayment);
        assertNotNull(updated);
        assertEquals(750.00, updated.getAmount());
        assertEquals(Payment.Status.Pending, updated.getStatus());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        repository.save(payment);
        repository.deleteById(payment.getPaymentID());
        boolean exists = repository.existsById(payment.getPaymentID());
        assertFalse(exists);
        System.out.println("Deleted payment with ID: " + payment.getPaymentID());
    }

    @Test
    void getAll() {
        repository.save(payment);
        List<Payment> payments = repository.findAll();
        assertFalse(payments.isEmpty());
        assertEquals(1, payments.size());
        System.out.println("All payments: " + payments);
    }
}


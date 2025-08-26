//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    private PaymentRepository repository;
    private Payment payment;

    @BeforeEach
    void setUp() {
        repository = PaymentRepository.getRepository();
        // Clear repository before each test
        repository.getAll().clear();

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
        Payment created = repository.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentID(), created.getPaymentID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.create(payment);
        Payment read = repository.read(payment.getPaymentID());
        assertNotNull(read);
        assertEquals(payment.getPaymentID(), read.getPaymentID());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(payment);
        Payment updatedPayment = new Payment.Builder()
                .copy(payment)
                .withAmount(750.00)
                .withStatus(Payment.Status.Pending)
                .build();

        Payment updated = repository.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(750.00, updated.getAmount());
        assertEquals(Payment.Status.Pending, updated.getStatus());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        repository.create(payment);
        boolean deleted = repository.delete(payment.getPaymentID());
        assertTrue(deleted);
        assertNull(repository.read(payment.getPaymentID()));
        System.out.println("Deleted payment with ID: " + payment.getPaymentID());
    }

    @Test
    void getAll() {
        repository.create(payment);
        List<Payment> payments = repository.getAll();
        assertFalse(payments.isEmpty());
        assertEquals(1, payments.size());
        System.out.println("All payments: " + payments);
    }
}

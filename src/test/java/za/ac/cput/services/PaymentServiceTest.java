//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13
/*
package za.ac.cput.services;

import za.ac.cput.factory.eventfactories.PaymentFactory;
import za.ac.cput.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService service;
    private Payment payment;

    @BeforeEach
    void setUp() {
        service = PaymentService.getService();
        payment = PaymentFactory.createPayment(
                1,
                1000.00,
                new Date(),
                "Credit Card",
                Payment.Status.Successful
        );
    }

    @Test
    void create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentID(), created.getPaymentID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        service.create(payment);
        Payment read = service.read(payment.getPaymentID());
        assertNotNull(read);
        assertEquals(payment.getPaymentID(), read.getPaymentID());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        service.create(payment);
        Payment updatedPayment = new Payment.Builder()
                .copy(payment)
                .withAmount(1200.00)
                .withStatus(Payment.Status.Pending)
                .build();
        Payment updated = service.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(1200.00, updated.getAmount());
        assertEquals(Payment.Status.Pending, updated.getStatus());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        service.create(payment);
        boolean deleted = service.delete(payment.getPaymentID());
        assertTrue(deleted);
        System.out.println("Deleted payment with ID: " + payment.getPaymentID());
    }

    @Test
    void getAll() {
        service.create(payment);
        List<Payment> payments = service.getAll();
        assertFalse(payments.isEmpty());
        System.out.println("All payments: " + payments);
    }
}
*/
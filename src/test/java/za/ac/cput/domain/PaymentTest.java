package za.ac.cput.domain;


import org.junit.jupiter.api.Test;
import za.ac.cput.factory.eventfactories.PaymentFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PaymentTest {

    private static Payment p1 = PaymentFactory.createPayment(
        1,
        1000.00,
        new Date(),
        "Credit Card",
        Payment.Status.Successful
    );

    @Test
    void createPayment() {
        assertNotNull(p1);
        System.out.println(p1.toString());
    }
}

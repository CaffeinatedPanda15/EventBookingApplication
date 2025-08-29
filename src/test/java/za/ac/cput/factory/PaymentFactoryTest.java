//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.eventfactories.PaymentFactory;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment() {
        Payment payment = PaymentFactory.createPayment(
                1,
                500.00,
                new Date(),
                "Credit Card",
                Payment.Status.Successful
        );

        assertNotNull(payment);
        System.out.println(payment.toString());
    }

    @Test
    void createPaymentInvalidData() {
        // Invalid amount should return null
        Payment payment = PaymentFactory.createPayment(
                1,
                -100,
                new Date(),
                "Cash",
                Payment.Status.Failed
        );
        assertNull(payment);
    }

    @Test
    void createPaymentNullMethod() {
        // Null payment method should return null
        Payment payment = PaymentFactory.createPayment(
                2,
                100,
                new Date(),
                null,
                Payment.Status.Pending
        );
        assertNull(payment);
    }
}


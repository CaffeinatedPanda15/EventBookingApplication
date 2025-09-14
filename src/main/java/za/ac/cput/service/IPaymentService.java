//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import java.util.List;
import java.util.Optional;

public interface IPaymentService {
    Payment create(Payment payment);
    Optional<Payment> read(int paymentID);
    Payment update(Payment payment);
    Payment delete(int paymentID);
    List<Payment> getAll();
}

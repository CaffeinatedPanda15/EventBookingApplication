//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.List;

public interface IPaymentRepository {
    Payment create(Payment payment);
    Payment read(int paymentID);
    Payment update(Payment payment);
    boolean delete(int paymentID);
    List<Payment> getAll();
}

// Muhammad Siddeeq Rabin
// STUDENT :221084096
// Group kN13
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByStatus(Payment.Status status);
}


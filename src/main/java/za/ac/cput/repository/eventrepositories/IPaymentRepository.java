//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, String> {



}

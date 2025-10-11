package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.eventdomains.Catering;

public interface ICateringRepository extends JpaRepository<Catering, Integer> {
}

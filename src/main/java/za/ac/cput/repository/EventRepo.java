package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.eventdomains.Event;

public interface EventRepo extends JpaRepository <Event, Long> {
}

package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.eventdomains.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, String> {
}

package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.eventdomains.Venue;

@Repository
public interface IVenueRepository extends JpaRepository<Venue, Integer> {
}

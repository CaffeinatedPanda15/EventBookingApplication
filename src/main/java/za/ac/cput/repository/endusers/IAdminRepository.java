
package za.ac.cput.repository.endusers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.endusers.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, String> {
    Admin findByEmailAddress(String emailAddress);
}


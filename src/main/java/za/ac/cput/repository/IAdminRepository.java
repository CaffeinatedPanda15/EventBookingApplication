package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Admin;

public interface IAdminRepository extends JpaRepository<Admin, String> {
    Admin create(Admin admin);

    Admin read(String adminId);

    Admin update(Admin admin);

    boolean delete(String adminId);

    Admin getAdminByEmail(String email);

    Admin getAdminByPhoneNumber(String phoneNumber);

    Admin getAdminByUsername(String username);
}

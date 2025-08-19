package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;

public interface IAdminRepository extends JpaRepository<Customer, String> {
    Customer create(Customer admin);

    Customer read(String adminId);

    Customer update(Customer admin);

    boolean delete(String adminId);

    Customer getAdminByEmail(String email);

    Customer getAdminByPhoneNumber(String phoneNumber);

    Customer getAdminByUsername(String username);
}

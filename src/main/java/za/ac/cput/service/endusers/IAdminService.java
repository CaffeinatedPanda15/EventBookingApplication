package za.ac.cput.service.endusers;

import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.domain.endusers.Customer;

import java.util.Optional;

public interface IAdminService {
    Customer create(Customer admin);

    Admin create(Admin admin);

    Optional<Admin> read(String adminId);
    Customer update(Customer admin);

    Admin update(Admin admin);

    boolean delete(String adminId);
    Admin getAdminByEmail(String email);
    Admin getAdminByPhoneNumber(String phoneNumber);
    Admin getAdminByUsername(String username);
}

package za.ac.cput.service;

import za.ac.cput.domain.Customer;

public interface IAdminService {
    Customer create(Customer admin);
    Customer read(String adminId);
    Customer update(Customer admin);
    boolean delete(String adminId);
    Customer getAdminByEmail(String email);
    Customer getAdminByPhoneNumber(String phoneNumber);
    Customer getAdminByUsername(String username);
}

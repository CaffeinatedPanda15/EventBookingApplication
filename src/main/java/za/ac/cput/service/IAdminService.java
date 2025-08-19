package za.ac.cput.service;

import za.ac.cput.domain.Admin;

public interface IAdminService {
    Admin create(Admin admin);
    Admin read(String adminId);
    Admin update(Admin admin);
    boolean delete(String adminId);
    Admin getAdminByEmail(String email);
    Admin getAdminByPhoneNumber(String phoneNumber);
    Admin getAdminByUsername(String username);
}

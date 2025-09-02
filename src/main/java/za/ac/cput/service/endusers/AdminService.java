package za.ac.cput.service.endusers;


import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.repository.endusers.IAdminRepository;

import java.util.Optional;

public class AdminService implements IAdminService {


    private static AdminService service = null;
    private IAdminRepository repository = null;

    public static AdminService getService(){
        if (service == null) {
            service = new AdminService();
        }
        return service;
    }

    @Override
    public Customer create(Customer admin) {
        return null;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Optional<Admin> read(String adminId) {
        return repository.findById(adminId);
    }

    @Override
    public Customer update(Customer admin) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return repository.getById(String.valueOf(admin));
    }

    @Override
    public boolean delete(String adminId) {
        return false;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return null;
    }

    @Override
    public Admin getAdminByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return null;
    }


}


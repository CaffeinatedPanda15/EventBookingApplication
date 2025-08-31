package za.ac.cput.service.endusers;


import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.repository.endusers.IAdminRepository;

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
        return repository.create(admin);
    }

    @Override
    public Admin read(String adminId) {
        return repository.read(adminId);
    }

    @Override
    public Customer update(Customer admin) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return repository.update(admin);
    }

    @Override
    public boolean delete(String adminId) {
        return repository.delete(adminId);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return repository.getAdminByEmail(email);
    }

    @Override
    public Admin getAdminByPhoneNumber(String phoneNumber) {
        return repository.getAdminByPhoneNumber(phoneNumber);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return repository.getAdminByUsername(username);
    }
}

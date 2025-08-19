package za.ac.cput.service;


import za.ac.cput.domain.Customer;
import za.ac.cput.repository.IAdminRepository;

public class AdminService implements IAdminService{


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
        return repository.create(admin);
    }

    @Override
    public Customer read(String adminId) {
        return repository.read(adminId);
    }

    @Override
    public Customer update(Customer admin) {
        return repository.update(admin);
    }

    @Override
    public boolean delete(String adminId) {
        return repository.delete(adminId);
    }

    @Override
    public Customer getAdminByEmail(String email) {
        return repository.getAdminByEmail(email);
    }

    @Override
    public Customer getAdminByPhoneNumber(String phoneNumber) {
        return repository.getAdminByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer getAdminByUsername(String username) {
        return repository.getAdminByUsername(username);
    }
}

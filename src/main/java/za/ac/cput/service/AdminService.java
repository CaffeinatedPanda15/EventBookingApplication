package za.ac.cput.service;


import za.ac.cput.domain.Admin;
import za.ac.cput.repository.IAdminRepository;

public class AdminService implements IAdminService{


    private static AdminService service = null;
    private IAdminRepository repository = null;


    @Override
    public Admin create(Admin admin) {
        return repository.create(admin);
    }

    @Override
    public Admin read(String adminId) {
        return repository.read(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        return repository.update(admin);
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

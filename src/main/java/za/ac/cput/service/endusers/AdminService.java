package za.ac.cput.service.endusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.repository.endusers.IAdminRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;

    @Autowired
    public AdminService(IAdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin create(Admin admin, String currentAdminUsername) {
        Admin adminToSave = new Admin.Builder()
                .copy(admin)
                .setCreatedBy(currentAdminUsername)
                .setCreatedDate(LocalDateTime.now())
                .build();
        return repository.save(adminToSave);
    }

    @Override
    public Admin read(String userName) {
        return repository.findById(userName).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        if (repository.existsById(admin.getUserName())) {
            return repository.save(admin);
        }
        return null;
    }

    @Override
    public boolean delete(String userName) {
        if (repository.existsById(userName)) {
            repository.deleteById(userName);
            return true;
        }
        return false;
    }

    @Override
    public List<Admin> getAll() {
        return repository.findAll();
    }


    @Override
    public Admin login(String email, String password) {
        Admin admin = repository.findByEmailAddress(email);
        if (admin != null && admin.getPassword().equals(password)) {
            Admin updatedAdmin = new Admin.Builder()
                    .copy(admin)
                    .setLastLogin(LocalDateTime.now())
                    .build();
            repository.save(updatedAdmin);
            return updatedAdmin;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}//end of class


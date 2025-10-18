package za.ac.cput.service.endusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.repository.endusers.IAdminRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AdminService(IAdminRepository repository, PasswordEncoder passwordencoder) {
        this.repository = repository;
        this.passwordEncoder = passwordencoder;
    }

    @Override
    public Admin create(Admin admin, String currentAdminUsername) {
        Admin adminToSave = new Admin.Builder()
                .copy(admin)
                .setPassword(passwordEncoder.encode(admin.getPassword()))
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
            Admin updatedAdmin = new Admin.Builder()
                    .copy(admin)
                    .setPassword(passwordEncoder.encode(admin.getPassword()))
                    .build();
            return repository.save(updatedAdmin);
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
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
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


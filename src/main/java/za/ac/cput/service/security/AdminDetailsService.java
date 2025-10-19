package za.ac.cput.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.repository.endusers.IAdminRepository;

@Service
public class AdminDetailsService implements UserDetailsService {

    private final IAdminRepository adminRepository;

    @Autowired
    public AdminDetailsService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmailAddress(email);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found with email: " + email);
        }
        return org.springframework.security.core.userdetails.User.withUsername(
                 admin.getEmailAddress())
                .password(admin.getPassword())
                .roles("ADMIN")
                .build();
    }
}

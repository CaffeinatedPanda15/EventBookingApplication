package za.ac.cput.service.endusers;


import za.ac.cput.domain.endusers.Admin;

import java.util.List;

public interface IAdminService {
    
    Admin create(Admin admin, String currentAdminUsername);

    Admin login(String email, String password);

    Admin read(String userName);
    Admin update(Admin admin);
    boolean delete(String userName);
    List<Admin> getAll();
}


package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.service.endusers.IAdminService;


import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IAdminService service;

    @Autowired
    public AdminController(IAdminService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin, @RequestParam(name = "currentAdminUsername", defaultValue = "system") String currentAdminUsername) {
        return service.create(admin, currentAdminUsername);
    }

    @GetMapping("/read/{id}")
    public Admin read(@PathVariable("id") String userName) {
        return service.read(userName);
    }

    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String customerId) {
        return service.delete(customerId);
    }

    @GetMapping("/getAll")
    public List<Admin> getAll() {
        return service.getAll();
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return service.login(admin.getEmailAddress(), admin.getPassword());
    }
}//end of class


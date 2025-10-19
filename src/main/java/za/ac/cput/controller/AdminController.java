package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.endusers.Admin;
import za.ac.cput.repository.endusers.IAdminRepository;
import za.ac.cput.service.endusers.IAdminService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IAdminService service;
    private final IAdminRepository adminRepository;

    @Autowired
    public AdminController(IAdminService service, IAdminRepository repository) {
        this.adminRepository = repository;
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

    @GetMapping
    public ResponseEntity<Map<String, String>> login(@AuthenticationPrincipal UserDetails user) {
        Admin admin = adminRepository.findByEmailAddress(user.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("adminName", admin.getUserName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<Map<String, String>> getProfile(@AuthenticationPrincipal UserDetails user) {
        Admin admin = adminRepository.findByEmailAddress(user.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("fullName", admin.getFullName());
        response.put("email", admin.getEmailAddress());
        return ResponseEntity.ok(response);
    }


}//end of class


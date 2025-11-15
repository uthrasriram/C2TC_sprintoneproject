package com.tnsif.placement_management_system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.placement_management_system.entity.Admin;
import com.tnsif.placement_management_system.service.AdminService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity<List<Admin>> getAll() {
        List<Admin> list = service.getAllAdmins();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id) {
        Admin admin = service.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }

    @PostMapping
    public ResponseEntity<Admin> create(@RequestBody Admin admin) {
        Admin created = service.addAdmin(admin);
        URI location = URI.create(String.format("/api/admins/%d", created.getAdminId()));
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@PathVariable Integer id, @RequestBody Admin admin) {
        Admin updated = service.updateAdmin(id, admin);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Admin existing = service.getAdminById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}

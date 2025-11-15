package com.tnsif.placement_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.placement_management_system.entity.Admin;
import com.tnsif.placement_management_system.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    @Override
    public List<Admin> getAllAdmins() {
        return repo.findAll();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return repo.save(admin);
    }

    @Override
    public Admin updateAdmin(Integer id, Admin admin) {
        Optional<Admin> opt = repo.findById(id);
        if (opt.isPresent()) {
            Admin existing = opt.get();
            existing.setAdminName(admin.getAdminName());
            existing.setEmail(admin.getEmail());
            existing.setPassword(admin.getPassword());
            existing.setPhone(admin.getPhone());
            existing.setRole(admin.getRole());
            existing.setStatus(admin.getStatus());
            return repo.save(existing);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAdmin(Integer id) {
        repo.deleteById(id);
    }
}

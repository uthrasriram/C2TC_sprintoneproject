package com.tnsif.placement_management_system.service;

import java.util.List;
import com.tnsif.placement_management_system.entity.Admin;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin getAdminById(Integer id);
    Admin addAdmin(Admin admin);
    Admin updateAdmin(Integer id, Admin admin);
    void deleteAdmin(Integer id);
}

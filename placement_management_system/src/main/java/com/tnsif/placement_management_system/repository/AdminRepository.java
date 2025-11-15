package com.tnsif.placement_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.placement_management_system.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // add custom queries if needed
}

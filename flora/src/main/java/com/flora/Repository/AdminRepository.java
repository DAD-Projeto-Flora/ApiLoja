package com.flora.Repository;

import com.flora.Model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
}

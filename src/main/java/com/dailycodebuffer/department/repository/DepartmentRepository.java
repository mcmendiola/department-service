package com.dailycodebuffer.department.repository;


import com.dailycodebuffer.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DepartmentRepository extends JpaRepository<Department, Long> {


    Department findDepartmentById(Long id);
}

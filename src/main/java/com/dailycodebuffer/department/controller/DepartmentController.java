package com.dailycodebuffer.department.controller;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }


    @PostMapping("/add")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        log.info("saveDepartment");
        Department newdepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(newdepartment, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long id){
        log.info("FindDepartment");
        Department department = departmentService.findByDepartmentId(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

}

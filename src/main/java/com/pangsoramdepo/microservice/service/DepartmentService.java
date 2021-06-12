package com.pangsoramdepo.microservice.service;

import com.pangsoramdepo.microservice.entity.Department;
import com.pangsoramdepo.microservice.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        return this.departmentRepository.findByDepartmentId(departmentId);
    }
}

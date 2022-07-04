package com.dailycodebuffer.Springboottutorial.service;

import com.dailycodebuffer.Springboottutorial.entity.Department;
import com.dailycodebuffer.Springboottutorial.error.DepartmentNotFoundException;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}

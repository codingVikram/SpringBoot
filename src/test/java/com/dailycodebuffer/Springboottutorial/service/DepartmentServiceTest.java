package com.dailycodebuffer.Springboottutorial.service;

import com.dailycodebuffer.Springboottutorial.entity.Department;
import com.dailycodebuffer.Springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("DevOps")
                .departmentAddress("Malvern/Farnborough")
                .departmentCode("PT3")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("DevOps")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "DevOps";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}

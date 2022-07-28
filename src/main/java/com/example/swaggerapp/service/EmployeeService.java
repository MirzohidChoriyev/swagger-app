package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Employee;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ApiResponse save(Employee employeeDto) {
        Employee employee = new Employee();
        employee.setFullname(employeeDto.getFullname());
        employee.setSalary(employeeDto.getSalary());
        employee.setPhone_number(employeeDto.getPhone_number());
        employeeRepository.save(employee);
        return new ApiResponse("save employee", true, employee);
    }

    public Boolean checkPhone_number(String phone_number){
        if(employeeRepository.existsByPhone_numberQuery(phone_number) == null){
            return false;
        }
        return true;
    }

    public ApiResponse getAll() {
        List<Employee> employees = employeeRepository.findAllQuery();
        return new ApiResponse("employees", true, employees);
    }
}


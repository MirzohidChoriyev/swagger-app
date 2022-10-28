package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Salary;
import com.example.swaggerapp.entity.Status;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.SalaryRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(Salary salaryDto){
        Salary salary = new Salary();
        salary.setName(salaryDto.getName());
        salary.setPercent(salaryDto.getPercent());
        salary.setMonth_name(salaryDto.getMonth_name());
        salary.setStatus(Status.valueOf("A"));
        salary.setValue(salaryDto.getValue());
        salary.setUser_id(salaryDto.getUser_id());

        salaryRepository.save(salary);
        return new ApiResponse("Save salary", true, 1, salary);
    }

    public ApiResponse getSalary(Integer user_id) {
        List<Salary> salaries = salaryRepository.getBySalaryUserId(user_id);
        return new ApiResponse("Get salary", true, 1, salaries);
    }
}

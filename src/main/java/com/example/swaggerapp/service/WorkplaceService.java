package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Workplaces;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceService {
    @Autowired
    WorkplaceRepository workplaceRepository;

    public ApiResponse save(Workplaces workplacesDto) {
        Workplaces workplaces = new Workplaces();
        workplaces.setWorker_number(workplacesDto.getWorker_number());
        workplaces.setWork_name(workplacesDto.getWork_name());
        workplaces.setSalary_range1(workplacesDto.getSalary_range1());
        workplaces.setSalary_range2(workplacesDto.getSalary_range2());
        workplaceRepository.save(workplaces);
        return new ApiResponse("Save Workplaces", true, workplaces);
    }
}

package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query(value = "select * from employee e where e.id = :id", nativeQuery = true)
//    Employee findByIdQuery(Integer id);
//
//    @Query(value = "select * from employee", nativeQuery = true)
//    List<Employee> findAllQuery();

    @Query("select e from Employee e")
    List<Employee> findAllQuery();

    //@Query("select e from Employee e where e.phone_number = :phone_number")
    //Employee existsByPhone_numberQuery(String phone_number);

    @Query(value = "select * from employee e where e.phone_number = :phone_number", nativeQuery = true)
    Employee existsByPhone_numberQuery(String phone_number);
}

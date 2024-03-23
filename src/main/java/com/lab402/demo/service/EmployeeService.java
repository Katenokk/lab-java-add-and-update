package com.lab402.demo.service;


import com.lab402.demo.model.Employee;
import com.lab402.demo.model.Status;
import com.lab402.demo.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllDoctors(){
        return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);

    }

    public Optional<Employee> findDoctorById(Integer employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> findDoctorsByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> findDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public void updateStatus(Integer id, Status status) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    public void updateDepartment(Integer id, String department) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        employee.setEmployeeId(employeeOptional.get().getEmployeeId());
        employeeRepository.save(employee);

    }

    public void updateEmployee(Integer id, Status status, String department) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        if (status != null) {
            employee.setStatus(status);
        }

        if (department != null) {
            employee.setDepartment(department);
        }

        employeeRepository.save(employee);
    }

}

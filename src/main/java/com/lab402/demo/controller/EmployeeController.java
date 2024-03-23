package com.lab402.demo.controller;

import com.lab402.demo.model.*;
import com.lab402.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllDoctors() {
        return employeeService.findAllDoctors();
    }

    //se puede poner void y sin el return
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewDoctor(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee deleted sucessfully");
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findDoctorById(@PathVariable(name="id") Integer employeeId) {
        return employeeService.findDoctorById(employeeId);
    }

    @GetMapping("/employees/status")
    public List<Employee> finDoctorsByStatus(@RequestParam Status status) {
        return employeeService.findDoctorsByStatus(status);
    }

    @GetMapping("/employees/departments")
    public List<Employee> finDoctorsByDepartments(@RequestParam String department) {
        return employeeService.findDoctorsByDepartment(department);
    }

    //cambiar status a employee
//    @PatchMapping("/employees/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void partialUpdateStatus(@PathVariable("id") Integer id, @RequestBody EmployeeStatusOnlyDTO partialProduct) {
//        employeeService.updateStatus(id, partialProduct.getStatus());
//    }

    //cambiar department a employee
//    @PatchMapping("/employees/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void partialUpdateDepartment(@PathVariable("id") Integer id, @RequestBody EmployeeDepartmentOnlyDTO partialProduct) {
//        employeeService.updateDepartment(id, partialProduct.getDepartment());
//    }

    //asi solo ejecuta uno cada vez, el primero
//    @PatchMapping("/employees/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void partialUpdate(@PathVariable("id") Integer id, @RequestBody EmployeePartialUpdateDTO partialUpdateDTO) {
//        if (partialUpdateDTO.getStatus() != null) {
//            employeeService.updateStatus(id, partialUpdateDTO.getStatus());
//        } else if (partialUpdateDTO.getDepartment() != null) {
//            employeeService.updateDepartment(id, partialUpdateDTO.getDepartment());
//        } else {
//            throw new IllegalArgumentException("Neither status nor department provided for update");
//        }
//    }

    //otra prueba

    @PatchMapping("/employees/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdate(@PathVariable("id") Integer id, @RequestBody EmployeePartialUpdateDTO partialUpdateDTO) {
        employeeService.updateEmployee(id, partialUpdateDTO.getStatus(), partialUpdateDTO.getDepartment());
    }



    //hayq eu pasarle todas las propiedades
    @PutMapping("/employees/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateDoctor(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }



}

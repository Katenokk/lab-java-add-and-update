package com.lab402.demo.model;

public class EmployeePartialUpdateDTO {


    private Status status;
    private String department;



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    public EmployeePartialUpdateDTO(){}
}

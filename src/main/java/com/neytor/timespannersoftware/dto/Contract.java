package com.neytor.timespannersoftware.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Contract {

    private Long id;

    private String reference;

    private Person person;

    private int contractType;

    private LocalDate startDate;

    private LocalDate endingDate;

    private BigDecimal salary;

    private int payrollPeriodicity;

    private EmployeesGroup employeesGroup;

    private City city;

    public Contract() {
        // Empty constructor
    }

    public Contract(Long id, String reference, Person person, int contractType, LocalDate startDate, LocalDate endingDate, BigDecimal salary, int payrollPeriodicity, EmployeesGroup employeesGroup, City city) {
        this.id = id;
        this.reference = reference;
        this.person = person;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.salary = salary;
        this.payrollPeriodicity = payrollPeriodicity;
        this.employeesGroup = employeesGroup;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getContractType() {
        return contractType;
    }

    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPayrollPeriodicity() {
        return payrollPeriodicity;
    }

    public void setPayrollPeriodicity(int payrollPeriodicity) {
        this.payrollPeriodicity = payrollPeriodicity;
    }

    public EmployeesGroup getEmployeesGroup() {
        return employeesGroup;
    }

    public void setEmployeesGroup(EmployeesGroup employeesGroup) {
        this.employeesGroup = employeesGroup;
    }

    public City getTerrirorialDivision() {
        return city;
    }

    public void setTerrirorialDivision(City city) {
        this.city = city;
    }
}

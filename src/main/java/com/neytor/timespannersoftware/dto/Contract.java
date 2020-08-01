package com.neytor.timespannersoftware.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Contract {

    private Long id;

    private String reference;

    private Person person;

    private int contractType;

    private Date startDate;

    private Date endingDate;

    private BigDecimal salary;

    private int payrollPeriodicity;

    private EmployeesGroup employeesGroup;

    private OperatingCenter operatingCenter;

    private CostsCenter costsCenter;

    private BusinessUnit businessUnit;

    private Project project;

    public Contract() {
        // Empty constructor
    }

    public Contract(Long id, String reference, Person person, int contractType, Date startDate, Date endingDate, BigDecimal salary, int payrollPeriodicity, EmployeesGroup employeesGroup, OperatingCenter operatingCenter, CostsCenter costsCenter, BusinessUnit businessUnit, Project project) {
        this.id = id;
        this.reference = reference;
        this.person = person;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.salary = salary;
        this.payrollPeriodicity = payrollPeriodicity;
        this.employeesGroup = employeesGroup;
        this.operatingCenter = operatingCenter;
        this.costsCenter = costsCenter;
        this.businessUnit = businessUnit;
        this.project = project;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
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

    public OperatingCenter getOperatingCenter() {
        return operatingCenter;
    }

    public void setOperatingCenter(OperatingCenter operatingCenter) {
        this.operatingCenter = operatingCenter;
    }

    public CostsCenter getCostsCenter() {
        return costsCenter;
    }

    public void setCostsCenter(CostsCenter costsCenter) {
        this.costsCenter = costsCenter;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

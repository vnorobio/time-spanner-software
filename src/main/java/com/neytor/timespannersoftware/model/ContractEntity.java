package com.neytor.timespannersoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    private String reference;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    private PersonEntity person;

    @Column(name = "contract_type")
    private int contractType;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ending_date")
    private Date endingDate;

    private BigDecimal salary;

    @Column(name = "payroll_periodicity")
    private int payrollPeriodicity;

    @ManyToOne
    @JoinColumn(name = "employees_group_id", referencedColumnName = "employees_group_id", insertable = false, updatable = false)
    private EmployeesGroupEntity employeesGroup;

    @ManyToOne
    @JoinColumn(name = "operating_center_id", referencedColumnName = "operating_center_id", insertable = false, updatable = false)
    private OperatingCenterEntity operatingCenter;

    @ManyToOne
    @JoinColumn(name = "cost_center_id", referencedColumnName = "cost_center_id", insertable = false, updatable = false)
    private CostsCenterEntity costsCenter;

    @ManyToOne
    @JoinColumn(name = "business_unit_id", referencedColumnName = "business_unit_id", insertable = false, updatable = false)
    private BusinessUnitEntity businessUnit;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)
    private ProjectEntity project;

    public ContractEntity() {
        // Empty constructor
    }

    public ContractEntity(Long id, String reference, PersonEntity person, int contractType, Date startDate, Date endingDate, BigDecimal salary, int payrollPeriodicity, EmployeesGroupEntity employeesGroup, OperatingCenterEntity operatingCenter, CostsCenterEntity costsCenter, BusinessUnitEntity businessUnit, ProjectEntity project) {
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

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
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

    public EmployeesGroupEntity getEmployeesGroup() {
        return employeesGroup;
    }

    public void setEmployeesGroup(EmployeesGroupEntity employeesGroup) {
        this.employeesGroup = employeesGroup;
    }

    public OperatingCenterEntity getOperatingCenter() {
        return operatingCenter;
    }

    public void setOperatingCenter(OperatingCenterEntity operatingCenter) {
        this.operatingCenter = operatingCenter;
    }

    public CostsCenterEntity getCostsCenter() {
        return costsCenter;
    }

    public void setCostsCenter(CostsCenterEntity costsCenter) {
        this.costsCenter = costsCenter;
    }

    public BusinessUnitEntity getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnitEntity businessUnit) {
        this.businessUnit = businessUnit;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }
}
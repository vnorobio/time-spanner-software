package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "ending_date", columnDefinition = "DATE")
    private LocalDate endingDate;

    private BigDecimal salary;

    @Column(name = "payroll_periodicity")
    private int payrollPeriodicity;

    @ManyToOne
    @JoinColumn(name = "employees_group_id", referencedColumnName = "employees_group_id", insertable = false, updatable = false)
    private EmployeesGroupEntity employeesGroup;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
    private CityEntity city;

}

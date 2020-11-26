package com.neytor.timespannersoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees_group_id")
    private Long id;

    private String code;

    private String description;

}

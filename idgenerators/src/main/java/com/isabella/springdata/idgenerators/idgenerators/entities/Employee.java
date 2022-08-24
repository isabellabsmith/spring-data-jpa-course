package com.isabella.springdata.idgenerators.idgenerators.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {
    // @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val",allocationSize=100)
    @GenericGenerator(name="emp_id", strategy = "com.isabella.springdata.idgenerators.idgenerators.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
    // @GeneratedValue(strategy = GenerationType.TABLE,generator="employee_gen")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

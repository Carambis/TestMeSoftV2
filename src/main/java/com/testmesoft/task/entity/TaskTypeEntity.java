package com.testmesoft.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_types")
public class TaskTypeEntity {
    @Id
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public TaskTypeEntity() {
    }

    public TaskTypeEntity(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

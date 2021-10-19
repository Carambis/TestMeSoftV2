package com.testmesoft.task.entity;

import javax.persistence.*;

@Entity
@Table(name = "task_sequences")
public class TaskSequenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity task;

    public TaskSequenceEntity() {
    }

    public TaskSequenceEntity(Long id, String userId, TaskEntity task) {
        this.id = id;
        this.userId = userId;
        this.task = task;
    }

    public TaskSequenceEntity(String userId, TaskEntity task) {
        this.userId = userId;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }
}

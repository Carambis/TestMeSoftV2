package com.testmesoft.task.entity;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class AnswerEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity task;
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private Boolean correct;

    public AnswerEntity(Long id, TaskEntity task, String text, Boolean correct) {
        this.id = id;
        this.task = task;
        this.text = text;
        this.correct = correct;
    }

    public AnswerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}

package com.testmesoft.task.entity;

import com.testmesoft.common.entity.LanguageEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_code", referencedColumnName = "code")
    private LanguageEntity language;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "header")
    private String header;
    @Column(name = "task_path")
    private String taskPath;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_type_code", referencedColumnName = "code")
    private TaskTypeEntity taskType;
    @OneToMany(mappedBy = "task")
    private List<AnswerEntity> answers;

    public TaskEntity() {
    }

    public TaskEntity(Long id, LanguageEntity language, String taskName, String header, String taskPath, TaskTypeEntity taskType, List<AnswerEntity> answers) {
        this.id = id;
        this.language = language;
        this.taskName = taskName;
        this.header = header;
        this.taskPath = taskPath;
        this.taskType = taskType;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTaskPath() {
        return taskPath;
    }

    public void setTaskPath(String taskPath) {
        this.taskPath = taskPath;
    }

    public TaskTypeEntity getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskTypeEntity taskType) {
        this.taskType = taskType;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }
}

package com.testmesoft.task.entity;

import com.testmesoft.common.entity.LanguageEntity;

import javax.persistence.*;

@Entity
@Table(name = "task_recommendations")
public class TaskRecommendationEntity {
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_code", referencedColumnName = "code")
    private LanguageEntity language;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_type_code", referencedColumnName = "code")
    private TaskTypeEntity taskTypeEntity;
    @Column(name = "minimum_value")
    private int minimumValue;
    @Column(name = "maximum_value")
    private int maximumValue;
    @Column(name = "recommendation")
    private String recommendation;

    public TaskRecommendationEntity() {
    }

    public TaskRecommendationEntity(Long id, LanguageEntity language, TaskTypeEntity taskTypeEntity, int minimumValue, int maximumValue, String recommendation) {
        this.id = id;
        this.language = language;
        this.taskTypeEntity = taskTypeEntity;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.recommendation = recommendation;
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

    public TaskTypeEntity getTaskTypeEntity() {
        return taskTypeEntity;
    }

    public void setTaskTypeEntity(TaskTypeEntity taskTypeEntity) {
        this.taskTypeEntity = taskTypeEntity;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}

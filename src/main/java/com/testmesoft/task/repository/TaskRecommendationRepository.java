package com.testmesoft.task.repository;

import com.testmesoft.task.entity.TaskRecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRecommendationRepository extends JpaRepository<TaskRecommendationEntity, Long> {
}

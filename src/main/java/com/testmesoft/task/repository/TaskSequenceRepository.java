package com.testmesoft.task.repository;

import com.testmesoft.task.entity.TaskSequenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskSequenceRepository extends JpaRepository<TaskSequenceEntity, Long> {

    TaskSequenceEntity findFirstByUserId(String userId);

}

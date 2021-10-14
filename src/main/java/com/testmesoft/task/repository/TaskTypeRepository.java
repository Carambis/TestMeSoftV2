package com.testmesoft.task.repository;

import com.testmesoft.task.entity.TaskTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskTypeEntity, String> {
}

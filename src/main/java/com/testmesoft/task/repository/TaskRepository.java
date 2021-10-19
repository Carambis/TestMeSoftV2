package com.testmesoft.task.repository;

import com.testmesoft.task.entity.TaskEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("select t from TaskEntity t inner join t.type tt where tt.code =:code order by function('RANDOM')")
    List<TaskEntity> findRandomTasks(String code, Pageable pageable);
}
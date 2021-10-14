package com.testmesoft.task.repository;

import com.testmesoft.task.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
    @Query("select a from AnswerEntity a inner join a.task at where at.id =:id")
    List<AnswerEntity> findByTaskId(Long id);
}

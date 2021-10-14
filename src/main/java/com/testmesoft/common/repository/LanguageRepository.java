package com.testmesoft.common.repository;

import com.testmesoft.common.entity.LanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {

    LanguageEntity findDistinctByCode(String code);

    Page<LanguageEntity> findByCodeContaining(String code, Pageable pageable);

    Page<LanguageEntity> findByNameContaining(String name, Pageable pageable);

}

package com.testmesoft;

import com.testmesoft.common.entity.LanguageEntity;
import com.testmesoft.common.repository.LanguageRepository;
import com.testmesoft.task.entity.AnswerEntity;
import com.testmesoft.task.entity.TaskEntity;
import com.testmesoft.task.repository.AnswerRepository;
import com.testmesoft.task.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LanguageServiceTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AnswerRepository answerRepository;

//    @Autowired
//    private TestEntityManager entityManager;

    @Test
    public void contextLoads() throws Exception {
        assertThat(languageRepository).isNotNull();
    }

    @Test
    public void testSave() {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setCode("1");
        languageEntity.setName("1");
        LanguageEntity save = languageRepository.save(languageEntity);
        Optional<LanguageEntity> byId = languageRepository.findById(save.getCode());
        Assertions.assertTrue(byId.isPresent());
    }

    @Test
    @Transactional
    public void testfind(){
        List<TaskEntity> all = taskRepository.findAll();
        languageRepository.save(new LanguageEntity("as", "лвпов"));
        List<AnswerEntity> byTaskId = answerRepository.findByTaskId(1L);
        System.out.println(all.size());
    }


}

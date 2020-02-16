package com.learn.scala.springscala.service;

import com.learn.scala.springscala.SpringScalaApplicationTests;
import com.learn.scala.springscala.domain.MetaDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class MetaDatabaseServiceTest extends SpringScalaApplicationTests {

    @Autowired
    private MetaDatabaseService metaDatabaseService;

    @Test
    public void testSave() {
        final MetaDatabase metaDatabase = metaDatabaseService.save(
                MetaDatabase.builder()
                        .name("defaul")
                        .location("hdfs://hadoop000:8020/user/hive/warehouse")
                        .build()
        );
        assertThat(metaDatabase.getId()).isNotNull();
    }

    @Test
    public void testQuery() {
        testSave();
        final List<MetaDatabase> all = metaDatabaseService.findAll();
        all.stream().filter(it -> it.getName().equals("default"))
                .forEach(it -> {
                    assertThat(it.getId()).isNotNull();
                    assertThat(it.getName()).isEqualTo("default");
                    assertThat(it.getLocation()).isEqualTo("hdfs://hadoop000:8020/user/hive/warehouse");
                });

        assertThat(all).isNotEmpty();
    }
}

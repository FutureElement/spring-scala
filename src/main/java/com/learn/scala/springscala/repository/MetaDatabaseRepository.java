package com.learn.scala.springscala.repository;

import com.learn.scala.springscala.domain.MetaDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDatabaseRepository extends JpaRepository<MetaDatabase, Integer> {

}

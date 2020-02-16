package com.learn.scala.springscala.repository

import com.learn.scala.springscala.domain.MetaTable
import org.springframework.data.jpa.repository.JpaRepository

trait MetaTableRepository extends JpaRepository[MetaTable, Integer]

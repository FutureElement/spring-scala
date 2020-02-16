package com.learn.scala.springscala.service

import java.util

import com.learn.scala.springscala.domain.MetaTable
import com.learn.scala.springscala.repository.MetaTableRepository
import javax.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MetaTableService(metaTableRepository: MetaTableRepository) {

  @Transactional
  def save(metaTable: MetaTable): MetaTable = {
    metaTableRepository.save(metaTable)
  }

  def findAll(): util.List[MetaTable] = {
    metaTableRepository.findAll()
  }
}

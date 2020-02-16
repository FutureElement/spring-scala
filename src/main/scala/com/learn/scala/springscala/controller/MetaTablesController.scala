package com.learn.scala.springscala.controller

import java.util

import com.learn.scala.springscala.controller.response.ApiResult
import com.learn.scala.springscala.domain.MetaTable
import com.learn.scala.springscala.service.MetaTableService
import org.springframework.web.bind.annotation.{GetMapping, ModelAttribute, PostMapping, RequestMapping, RestController}

@RestController
@RequestMapping(value = Array("/meta/tables"))
class MetaTablesController(metaTableService: MetaTableService) {

  @PostMapping
  def save(@ModelAttribute metaTable: MetaTable): ApiResult[Nothing] = {
    metaTableService.save(metaTable)
    ApiResult.success()
  }

  @GetMapping
  def queryAll(): ApiResult[util.List[MetaTable]] = {
    val all = metaTableService.findAll()
    ApiResult.success(all)
  }
}

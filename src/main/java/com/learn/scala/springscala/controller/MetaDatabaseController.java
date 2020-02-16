package com.learn.scala.springscala.controller;

import com.learn.scala.springscala.controller.request.CreateMetaDatabaseCommand;
import com.learn.scala.springscala.controller.response.ApiResult;
import com.learn.scala.springscala.domain.MetaDatabase;
import com.learn.scala.springscala.service.MetaDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/meta/databases")
@RequiredArgsConstructor
public class MetaDatabaseController {
    private final MetaDatabaseService metaDatabaseService;

    @PostMapping
    public ApiResult<Object> save(@ModelAttribute @Valid CreateMetaDatabaseCommand createMetaDatabaseCommand) {
        val metaDatabase = metaDatabaseService.save(
                MetaDatabase.builder()
                        .name(createMetaDatabaseCommand.name)
                        .location(createMetaDatabaseCommand.location)
                        .build()
        );
        return metaDatabase.getId() != null ? ApiResult.success() : ApiResult.error();
    }

    @GetMapping
    public ApiResult<List<MetaDatabase>> findAll() {
        return ApiResult.success(metaDatabaseService.findAll());
    }
}

package com.learn.scala.springscala.controller.request;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
public class CreateMetaDatabaseCommand {
    @NotBlank
    public final String name;
    @NotBlank
    public final String location;
}

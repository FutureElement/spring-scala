package com.learn.scala.springscala.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(value = Array("/scala"))
class ScalaHelloController {

  @GetMapping(value = Array("/hello"))
  def sayHello(): String = {
    "Hello, scala..."
  }
}

package com.ecommerce.implementspringsecuritywithauthentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ApplicationController {

  @GetMapping("/")
  public ResponseEntity<String> home() {
    return new ResponseEntity<String>("<h1>Logged in, successfully!</h1", HttpStatus.OK);
  }
}

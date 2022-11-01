package com.bankaccount.application.rest.commands;

import com.bankaccount.application.rest.commands.dto.UserDto;
import com.bankaccount.application.service.UserService;

import io.swagger.annotations.Api;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "All Account Commands", description = "Api for Bank Account application")
@RestController
@NoArgsConstructor
@RequestMapping(UserCommandController.RESOURCE_PATH)
public class UserCommandController extends BaseController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserCommandController.class);
  public static final String RESOURCE_PATH = API_PATH + "/users";

  @Autowired
  private UserService service;

  @PostMapping
  public String addUser(@RequestBody UserDto user) {
    LOGGER.info("REACHED HERE");
    return service.createUser(user);
  }

}

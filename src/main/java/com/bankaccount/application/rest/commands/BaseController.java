package com.bankaccount.application.rest.commands;

import static com.bankaccount.application.rest.commands.BaseController.API_PATH;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(API_PATH)
public abstract class BaseController {

  public static final String API_PATH = "/api";

}

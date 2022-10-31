package com.bankaccount.application.rest.commands;

import com.wordnik.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "All Account Commands", description = "Api for Bank Account application")
@AllArgsConstructor
@RestController
@RequestMapping("/bankAccounts")
public class BankAccountCommandController {


}

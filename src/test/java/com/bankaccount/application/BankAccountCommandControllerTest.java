package com.bankaccount.application;

import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;

import com.bankaccount.application.service.BankAccountCommandService;
import com.bankaccount.application.rest.commands.BankAccountCommandController;
import com.bankaccount.application.rest.commands.dto.BankAccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class BankAccountCommandControllerTest {

  private static final String RESOURCE_URL = "/api/bankAccounts";

  @InjectMocks
  private BankAccountCommandService bankAccountService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  private BankAccountDto bankAccountDto;

  private BankAccountDto bankAccountDto1;

  @BeforeEach
  public void setUp() {
    openMocks(this);

    bankAccountDto1 = mock(BankAccountDto.class);

    bankAccountDto = new BankAccountDto(
        new BigDecimal("100.00"), "test user");

    BankAccountCommandController commandController
        = new BankAccountCommandController();
    mockMvc = MockMvcBuilders.standaloneSetup(commandController).build();

  }

  @Test
  public void shouldCreateAccountWithInitialDeposit() throws Exception {

     bankAccountDto.setUserName("TEST-uSER");
     bankAccountDto.setBalance(new BigDecimal("200"));

    //when
    Mockito.when(bankAccountService.createAccount(Mockito.any(BankAccountDto.class)))
        .thenReturn(bankAccountDto);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(RESOURCE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(bankAccountDto).getBytes(StandardCharsets.UTF_8))
            .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

  }

}

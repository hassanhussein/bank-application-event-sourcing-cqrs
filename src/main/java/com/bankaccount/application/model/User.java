package com.bankaccount.application.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseModel {

  @NotNull
  private String firstName;

  private String lastName;

  @Unique
  private String phoneNumber;

}

package com.bankaccount.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Class BaseModel is the root of the domain objects hierarchy. It defines identity and audit fields for any entity.
 * Most domain objects have BaseModel as a superclass which defines its primary attributes.
 */

@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseModel {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "ID", updatable = false, nullable = false)
  @ColumnDefault("random_uuid()")
  @Type(type = "uuid-char")
  @Setter
  @Getter
  protected UUID id;

  @JsonIgnore
  protected Date createdDate;

  @JsonIgnore
  protected Date modifiedDate;

}
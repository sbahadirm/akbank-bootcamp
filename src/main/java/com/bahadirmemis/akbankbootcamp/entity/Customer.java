package com.bahadirmemis.akbankbootcamp.entity;

import com.bahadirmemis.akbankbootcamp.enums.EnumStatus;
import com.bahadirmemis.akbankbootcamp.general.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseEntity {

  @Id
  @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
  private Long id;

  @Column(name = "NAME", length = 100, nullable = false)
  private String name;

  @Column(name = "SURNAME", length = 100, nullable = false)
  private String surname;

  @NotBlank
  @Column(name = "USERNAME", length = 50, nullable = false)
  private String username;

  @NotNull
  @Column(name = "PASSWORD", length = 400, nullable = false)
  private String password;

  @Email
  @Column(name = "EMAIL", length = 50)
  private String email;

  //@Column(name = "BIRTH_DATE")
  //@Temporal(TemporalType.DATE)
  //private Date birthDate;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @Column(name = "STATUS", length = 30)
  @Enumerated(EnumType.STRING)
  private EnumStatus status;
}

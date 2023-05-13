package com.bahadirmemis.akbankbootcamp.entity;

import com.bahadirmemis.akbankbootcamp.general.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Entity
@Getter
@Setter
public class City extends BaseEntity {

  @Id
  private Long id;


}

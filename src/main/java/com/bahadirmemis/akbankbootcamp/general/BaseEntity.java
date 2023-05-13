package com.bahadirmemis.akbankbootcamp.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel {

  @Embedded
  private BaseAdditionalFields baseAdditionalFields;

}

package com.bahadirmemis.akbankbootcamp.general;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  @Column(name = "ID_CUSTOMER_CREATED_BY")
  private Long createdBy;

  @Column(name = "ID_CUSTOMER_UPDATE_BY")
  private Long updatedBy;

  @Column(name = "CREATE_DATE")
  private LocalDateTime createDate;

  @Column(name = "UPDATE_DATE")
  private LocalDateTime updateDate;
}

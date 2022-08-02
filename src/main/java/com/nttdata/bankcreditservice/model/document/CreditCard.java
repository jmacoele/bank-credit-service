package com.nttdata.bankcreditservice.model.document;

import com.nttdata.bankcreditservice.model.document.type.CreditCardTypeEnum;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Credit Card Class.
 *
 * @author jmacoele
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "creditcards")
public class CreditCard {

  @Id
  private String id;

  private CreditCardTypeEnum creditCardType;

  private String number;

  private String ownerName;

  private LocalDateTime issueDate;

  private LocalDateTime dueDate;

  private String cvc;

}

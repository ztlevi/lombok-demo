package org.example;

import lombok.experimental.FieldNameConstants;
import lombok.AccessLevel;

// Configuration is set in lombok.config
// lombok.fieldNameConstants.uppercase = true
@FieldNameConstants
public class FieldNameConstantsExample {
  private String i-am-afield;
  private int andSoAmI;
  @FieldNameConstants.Exclude private int asAmI;
}

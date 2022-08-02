package com.nttdata.bankcreditservice.exception;

/**
 * Exception class for invalid enum values
 * @author jmacoele
 * @date 2022/07/20
 */
public class UnknownEnumValueException extends RuntimeException {

  public UnknownEnumValueException(String message) {
    super(message);
  }
}

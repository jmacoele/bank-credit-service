package com.nttdata.bankcreditservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bankcreditservice.exception.UnknownEnumValueException;

public enum CreditCardTypeEnum {
	PERSONAL("P"),
	ENTERPRISE("E");

	private String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CreditCardTypeEnum of(String value) {
        if (null == value) {
            return null;
        }

        for (CreditCardTypeEnum item : CreditCardTypeEnum.values()) {
            if (value.equals(item.getValue())) {
                return item;
            }
        }

        throw new UnknownEnumValueException("CreditTypeEnum: unknown value: " + value);
    }

    CreditCardTypeEnum(String value) {
        this.value = value;
    }
	
}
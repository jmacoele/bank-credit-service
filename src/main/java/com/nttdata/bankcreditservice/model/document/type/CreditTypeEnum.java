package com.nttdata.bankcreditservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bankcreditservice.exception.UnknownEnumValueException;

public enum CreditTypeEnum {
	PERSONAL("P"),
	ENTERPRISE("E"),
	CREDITCARD("C");

	private String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CreditTypeEnum of(String value) {
        if (null == value) {
            return null;
        }

        for (CreditTypeEnum item : CreditTypeEnum.values()) {
            if (value.equals(item.getValue())) {
                return item;
            }
        }

        throw new UnknownEnumValueException("CreditTypeEnum: unknown value: " + value);
    }

    CreditTypeEnum(String value) {
        this.value = value;
    }
	
}
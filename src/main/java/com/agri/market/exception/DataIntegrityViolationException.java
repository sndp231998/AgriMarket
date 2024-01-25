package com.agri.market.exception;

public class DataIntegrityViolationException extends RuntimeException {

    String keyName;
    String duplicateValue;

    public DataIntegrityViolationException(String keyName, String duplicateValue) {
        super(String.format("Duplicate entry for key %s with value: %s", keyName, duplicateValue));
        this.keyName = keyName;
        this.duplicateValue = duplicateValue;
    }
}
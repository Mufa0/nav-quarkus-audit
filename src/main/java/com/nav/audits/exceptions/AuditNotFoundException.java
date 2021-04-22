package com.nav.audits.exceptions;

public class AuditNotFoundException extends RuntimeException {
    public final String code;

    public AuditNotFoundException(String code) {
        this.code = code;
    }
}

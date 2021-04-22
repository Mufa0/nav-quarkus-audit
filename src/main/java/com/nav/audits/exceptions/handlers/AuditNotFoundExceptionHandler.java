package com.nav.audits.exceptions.handlers;

import com.nav.audits.exceptions.AuditNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuditNotFoundExceptionHandler implements ExceptionMapper<AuditNotFoundException> {

    @Override
    public Response toResponse(AuditNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(String.format("Audit with code: %s not found!", e.code)).build();
    }
}

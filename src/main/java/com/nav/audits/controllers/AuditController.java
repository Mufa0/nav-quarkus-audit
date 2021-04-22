package com.nav.audits.controllers;

import com.nav.audits.dto.AuditRequest;
import com.nav.audits.dto.AuditResponse;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/audits")
@Produces(APPLICATION_JSON)
public interface AuditController {

    @GET
    @Path("/owner/{owner}")
    List<AuditResponse> getAll(@PathParam("owner") String owner);

    @GET
    @Path("/user/{user}")
    List<AuditResponse> getAllForUser(@PathParam("user") String user);

    @GET
    @Path("/{code}")
    AuditResponse get(@PathParam("code") String code);

    @POST
    @Consumes(APPLICATION_JSON)
    AuditResponse create(AuditRequest request);
}

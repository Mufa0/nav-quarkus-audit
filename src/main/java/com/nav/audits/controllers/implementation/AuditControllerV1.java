package com.nav.audits.controllers.implementation;

import com.nav.audits.controllers.AuditController;
import com.nav.audits.dto.AuditRequest;
import com.nav.audits.dto.AuditResponse;
import com.nav.audits.service.AuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class AuditControllerV1 implements AuditController {

    AuditService auditService;

    @Override
    public List<AuditResponse> getAll(String owner) {
        List<AuditResponse> response = auditService.getAll(owner);
        log.info("Fetched {} audits for owner: {}",response.size(), owner);
        return response;
    }

    @Override
    public List<AuditResponse> getAllForUser(String user) {
        List<AuditResponse> response = auditService.getAllForUser(user);
        log.info("Fetched {} audits for user: {}",response.size(),user);
        return response;
    }

    @Override
    public AuditResponse get(String code) {
        AuditResponse response = auditService.get(code);
        log.info("Successfully fetched audit with code {}", code);
        return response;
    }

    @Override
    public AuditResponse create(AuditRequest request) {
        AuditResponse response = auditService.create(request);
        log.info("Successfully created audit for owner: {}", response.getOwner());
        return response;
    }
}

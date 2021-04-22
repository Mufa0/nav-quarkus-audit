package com.nav.audits.service;

import com.nav.audits.dto.AuditRequest;
import com.nav.audits.dto.AuditResponse;

import java.util.List;

public interface AuditService {

    AuditResponse get(String code);

    List<AuditResponse> getAll(String owner);

    List<AuditResponse> getAllForUser(String user);

    AuditResponse create(AuditRequest request);
}

package com.nav.audits.domain.mapper;

import com.nav.audits.domain.Audit;
import com.nav.audits.domain.enums.Action;
import com.nav.audits.dto.AuditRequest;
import com.nav.audits.dto.AuditResponse;

import java.util.Calendar;
import java.util.UUID;

public class AuditMapper {

    public AuditResponse from(Audit audit){
        return AuditResponse.builder()
                .owner(audit.getOwner())
                .code(audit.getCode())
                .action(audit.getAction().name())
                .message(audit.getMessage())
                .user(audit.getUser())
                .build();
    }

    public Audit from (AuditRequest request){
        return Audit.builder()
                .action(Action.valueOf(request.getAction()))
                .message(request.getMessage())
                .owner(request.getOwner())
                .user(request.getUser())
                .code("audit_"+UUID.randomUUID()+ Calendar.getInstance().getTimeInMillis())
                .build();
    }
}

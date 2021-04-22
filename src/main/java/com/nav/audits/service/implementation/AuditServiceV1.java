package com.nav.audits.service.implementation;

import com.nav.audits.domain.Audit;
import com.nav.audits.domain.mapper.AuditMapper;
import com.nav.audits.dto.AuditRequest;
import com.nav.audits.dto.AuditResponse;
import com.nav.audits.exceptions.AuditNotFoundException;
import com.nav.audits.service.AuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class AuditServiceV1 implements AuditService {
    AuditMapper auditMapper;

    public AuditServiceV1(){
        this.auditMapper = new AuditMapper();
    }
    @Override
    public AuditResponse get(String code) {
        Optional<Audit> audit = Audit.find("code",code).firstResultOptional();
        if(audit.isPresent()){
            return auditMapper.from(audit.get());
        }else{
            log.error("Audit with code: {} not found!", code);
            throw new AuditNotFoundException(code);
        }
    }

    @Override
    public List<AuditResponse> getAll(String owner) {
        List<Audit> audits = Audit.list("owner", owner);
        if(audits != null){
            return audits.stream().map(x -> auditMapper.from(x)).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public List<AuditResponse> getAllForUser(String user) {
        List<Audit> audits = Audit.list("user", user);
        if(audits != null){
            return audits.stream().map(x -> auditMapper.from(x)).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public AuditResponse create(AuditRequest request) {
        Audit audit = auditMapper.from(request);
        Audit.persist(audit);
        return auditMapper.from(audit);
    }
}

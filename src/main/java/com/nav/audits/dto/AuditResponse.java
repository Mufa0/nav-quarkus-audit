package com.nav.audits.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {

    String code;

    String message;

    String user;

    String action;

    String owner;

}

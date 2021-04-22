package com.nav.audits.domain;

import com.nav.audits.domain.enums.Action;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "audit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audit extends PanacheEntity {

    long id;

    String owner;

    String code;

    @Column(name = "_user")
    String user;

    String message;

    @Enumerated(EnumType.STRING)
    Action action;
}

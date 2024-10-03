package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * BsBaseEntity
 * <p>
 * BsBaseEntity class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */
@Getter
@Setter
@MappedSuperclass
public class BsBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3432415118999768157L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BS_REGION_SEQ")
    @SequenceGenerator(name = "BS_REGION_SEQ", sequenceName = "BS_REGION_SEQ", allocationSize = 1)
    @Column(nullable = false)
    protected Long id;
}

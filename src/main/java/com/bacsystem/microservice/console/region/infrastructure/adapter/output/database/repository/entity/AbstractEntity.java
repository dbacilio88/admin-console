package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

/**
 * AbstractEntity
 * <p>
 * AbstractEntity class.
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
@ToString
@MappedSuperclass
public class AbstractEntity extends BsBaseEntity {
    @Serial
    private static final long serialVersionUID = 7701282890865255780L;

    @Size(max = 36)
    @Column(name = "re_uuid", length = 36)
    private String reUuid;
}

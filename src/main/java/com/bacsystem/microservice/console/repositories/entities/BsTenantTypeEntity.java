package com.bacsystem.microservice.console.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * data
 * <p>
 * data class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 30/09/2024
 */

@Getter
@Setter
@Entity
@Table(name = "bs_tenant_type", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "tenant_type_un", columnNames = {"tt_uuid", "tt_name"})
})
public class BsTenantTypeEntity {
    @Id
    @Column(name = "tt_id", nullable = false, precision = 38)
    private Long id;

    @Size(max = 36)
    @Column(name = "tt_uuid", length = 36)
    private String ttUuid;

    @Size(max = 50)
    @Column(name = "tt_name", length = 50)
    private String ttName;

    @Size(max = 100)
    @Column(name = "tt_description", length = 100)
    private String ttDescription;

    @OneToMany(mappedBy = "teTenantType")
    private Set<BsTenantEntity> bsTenants = new LinkedHashSet<>();

}
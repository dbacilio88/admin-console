package com.bacsystem.microservice.console.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "bs_tenant", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_tenant_un", columnNames = {"te_uuid", "te_client_id", "te_name"})
})
public class BsTenantEntity {
    @Id
    @Column(name = "te_id", nullable = false, precision = 38)
    private Long id;

    @Size(max = 36)
    @Column(name = "te_uuid", length = 36)
    private String teUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "te_tenant_type_id")
    private BsTenantTypeEntity teTenantType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "te_address_id")
    private BsAddressEntity teAddress;

    @Size(max = 50)
    @Column(name = "te_client_id", length = 50)
    private String teClientId;

    @Size(max = 50)
    @Column(name = "te_name", length = 50)
    private String teName;

    @Column(name = "te_deleted", precision = 1)
    private BigDecimal teDeleted;

    @Size(max = 36)
    @Column(name = "te_created_by", length = 36)
    private String teCreatedBy;

    @Size(max = 36)
    @Column(name = "te_updated_by", length = 36)
    private String teUpdatedBy;

    @Size(max = 36)
    @Column(name = "te_deleted_by", length = 36)
    private String teDeletedBy;

    @Column(name = "te_created_date")
    private Instant teCreatedDate;

    @Column(name = "te_updated_date")
    private Instant teUpdatedDate;

    @Column(name = "te_deleted_date")
    private Instant teDeletedDate;

    @Size(max = 100)
    @Column(name = "te_directory_code", length = 100)
    private String teDirectoryCode;

}
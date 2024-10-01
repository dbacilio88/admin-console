package com.bacsystem.microservice.console.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
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
@Table(name = "bs_address", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_address_un", columnNames = {"ad_uuid"})
})
public class BsAddressEntity {
    @Id
    @Column(name = "ad_id", nullable = false, precision = 38)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_address_type_id")
    private BsAddressTypeEntity adAddressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_city_id")
    private BsCityEntity adCity;

    @Size(max = 36)
    @Column(name = "ad_uuid", length = 36)
    private String adUuid;

    @Size(max = 100)
    @Column(name = "ad_line_1", length = 100)
    private String adLine1;

    @Size(max = 100)
    @Column(name = "ad_line_2", length = 100)
    private String adLine2;

    @Size(max = 100)
    @Column(name = "ad_zip_code", length = 100)
    private String adZipCode;

    @Size(max = 100)
    @Column(name = "ad_home_number", length = 100)
    private String adHomeNumber;

    @Size(max = 100)
    @Column(name = "ad_building_number", length = 100)
    private String adBuildingNumber;

    @Size(max = 200)
    @Column(name = "ad_description", length = 200)
    private String adDescription;

    @Column(name = "ad_deleted", precision = 1)
    private BigDecimal adDeleted;

    @Size(max = 200)
    @Column(name = "ad_created_by", length = 200)
    private String adCreatedBy;

    @Size(max = 200)
    @Column(name = "ad_updated_by", length = 200)
    private String adUpdatedBy;

    @Size(max = 200)
    @Column(name = "ad_deleted_by", length = 200)
    private String adDeletedBy;

    @Column(name = "ad_created_date")
    private Instant adCreatedDate;

    @Column(name = "ad_updated_date")
    private Instant adUpdatedDate;

    @Column(name = "ad_deleted_date")
    private Instant adDeletedDate;

    @OneToMany(mappedBy = "teAddress")
    private Set<BsTenantEntity> bsTenants = new LinkedHashSet<>();

}
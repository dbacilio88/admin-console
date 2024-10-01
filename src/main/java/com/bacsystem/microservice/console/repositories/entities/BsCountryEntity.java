package com.bacsystem.microservice.console.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
@Table(name = "bs_country", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_country_un", columnNames = {"co_uuid", "co_name"})
})
public class BsCountryEntity {

    @Id
    @Column(name = "co_id", nullable = false, precision = 38)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_region_id")
    private BsRegionEntity coRegion;

    @Size(max = 36)
    @Column(name = "co_uuid", length = 36)
    private String coUuid;

    @Size(max = 3)
    @Column(name = "co_code_iso_3", length = 3)
    private String coCodeIso3;

    @Size(max = 2)
    @Column(name = "co_code_iso_2", length = 2)
    private String coCodeIso2;

    @Size(max = 6)
    @Column(name = "co_phone_code", length = 6)
    private String coPhoneCode;

    @Size(max = 60)
    @Column(name = "co_name", length = 60)
    private String coName;

    @OneToMany(mappedBy = "stCountry")
    private Set<BsStateEntity> bsStates = new LinkedHashSet<>();

}
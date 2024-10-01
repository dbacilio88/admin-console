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
@Table(name = "bs_state", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_state_un", columnNames = {"st_uuid"})
})
public class BsStateEntity {
    @Id
    @Column(name = "st_id", nullable = false, precision = 38)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "st_country_id")
    private BsCountryEntity stCountry;

    @Size(max = 36)
    @Column(name = "st_uuid", length = 36)
    private String stUuid;

    @Size(max = 100)
    @Column(name = "st_name", length = 100)
    private String stName;

    @Size(max = 200)
    @Column(name = "st_description", length = 200)
    private String stDescription;

    @OneToMany(mappedBy = "ciState")
    private Set<BsCityEntity> bsCities = new LinkedHashSet<>();

}
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
@Table(name = "bs_region", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_region_un", columnNames = {"re_uuid", "re_code", "re_name"})
})
public class BsRegionEntity {

    @Id
    @Column(name = "re_id", nullable = false, precision = 38)
    private Long id;

    @Size(max = 36)
    @Column(name = "re_uuid", length = 36)
    private String reUuid;

    @Size(max = 10)
    @Column(name = "re_code", length = 10)
    private String reCode;

    @Size(max = 60)
    @Column(name = "re_name", length = 60)
    private String reName;

    @OneToMany(mappedBy = "coRegion")
    private Set<BsCountryEntity> bsCountries = new LinkedHashSet<>();

}
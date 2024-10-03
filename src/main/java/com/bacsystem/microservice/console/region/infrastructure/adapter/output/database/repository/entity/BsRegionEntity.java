package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

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
@Table(name = "bs_region", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "bs_region_un", columnNames = {"re_uuid", "re_code", "re_name"})
})
public class BsRegionEntity extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8333421438774157011L;

  /*
    @Id
   */
    //@Column(name = "re_id", nullable = false, precision = 38)
    //private Long id;


    @Size(max = 10)
    @Column(name = "re_code", length = 10)
    private String reCode;

    @Size(max = 60)
    @Column(name = "re_name", length = 60)
    private String reName;
//
    //@OneToMany(mappedBy = "coRegion")
    // private Set<BsCountryEntity> bsCountries = new LinkedHashSet<>();

}
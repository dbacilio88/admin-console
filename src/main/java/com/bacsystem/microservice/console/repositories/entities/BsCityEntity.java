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
@Table(name = "bs_city", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_city_un", columnNames = {"ci_uuid"})
})
public class BsCityEntity {
    @Id
    @Column(name = "ci_id", nullable = false, precision = 38)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci_state_id")
    private BsStateEntity ciState;

    @Size(max = 36)
    @Column(name = "ci_uuid", length = 36)
    private String ciUuid;

    @Size(max = 100)
    @Column(name = "ci_name", length = 100)
    private String ciName;

    @Size(max = 200)
    @Column(name = "ci_description", length = 200)
    private String ciDescription;

    @OneToMany(mappedBy = "adCity")
    private Set<BsAddressEntity> bsAddresses = new LinkedHashSet<>();

}
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
@Table(name = "bs_address_type", schema = "sc000000", uniqueConstraints = {
        @UniqueConstraint(name = "bs_address_type_un", columnNames = {"at_uuid"})
})
public class BsAddressTypeEntity {
    @Id
    @Column(name = "at_id", nullable = false, precision = 38)
    private Long id;

    @Size(max = 36)
    @Column(name = "at_uuid", length = 36)
    private String atUuid;

    @Size(max = 50)
    @Column(name = "at_name", length = 50)
    private String atName;

    @Size(max = 100)
    @Column(name = "at_description", length = 100)
    private String atDescription;

    @OneToMany(mappedBy = "adAddressType")
    private Set<BsAddressEntity> bsAddresses = new LinkedHashSet<>();

}
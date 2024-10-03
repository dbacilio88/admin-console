package com.bacsystem.microservice.console.region.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * RegionModel
 * <p>
 * RegionModel class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 1/10/2024
 */

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionModel {
    private long id;
    private String re_uuid;
    private String re_name;
    private String re_code;
}

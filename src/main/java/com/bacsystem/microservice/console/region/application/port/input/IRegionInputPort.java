package com.bacsystem.microservice.console.region.application.port.input;


import com.bacsystem.microservice.console.region.domain.model.RegionModel;

/**
 * IRegionQueryInputPort
 * <p>
 * IRegionQueryInputPort interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 1/10/2024
 */

public interface IRegionInputPort {

    RegionModel save(String name, String code);
    RegionModel update(String name, String code);

}

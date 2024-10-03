package com.bacsystem.microservice.console.region.infrastructure.adapter.input.http.contracts;


import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * IApplicationController
 * <p>
 * IApplicationController interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 25/09/2024
 */

public interface IRegionController {

    ResponseEntity<List<RegionModel>> findAllExecute();

    ResponseEntity<RegionModel> findByIdExecute(long id);

    ResponseEntity<RegionModel> saveExecute(String name, String code);

    ResponseEntity<RegionModel> updateExecute(String name, String code);

    ResponseEntity<Long> deleteExecute(long id);

    ResponseEntity<Page<RegionModel>> pageExecute(String page, String size);
}

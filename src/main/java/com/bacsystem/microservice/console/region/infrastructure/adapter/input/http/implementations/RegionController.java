package com.bacsystem.microservice.console.region.infrastructure.adapter.input.http.implementations;


import com.bacsystem.microservice.console.region.application.port.input.IMessageBrokerInputPort;
import com.bacsystem.microservice.console.region.application.port.input.IRegionInputPort;
import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import com.bacsystem.microservice.console.region.infrastructure.adapter.input.http.contracts.IRegionController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RegionController
 * <p>
 * RegionController class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */
@Log4j2
@RestController
@RequestMapping(path = "/region")
@RequiredArgsConstructor
public class RegionController implements IRegionController {

    private final IRegionInputPort commandInputPort;
    private final IMessageBrokerInputPort messageBrokerInputPort;

    @Override
    @GetMapping
    public ResponseEntity<List<RegionModel>> findAllExecute() {
        log.info("findAllExecute {}", messageBrokerInputPort.getAll("bs_region"));
        messageBrokerInputPort.getAll("bs_region");
        return new ResponseEntity<>(messageBrokerInputPort.getAlls("bs_region"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegionModel> findByIdExecute(long id) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<RegionModel> saveExecute(String name, String code) {
        log.info("controller saveExecute name {}, code {} ", name, code);
        return new ResponseEntity<>(this.commandInputPort.save(name, code), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RegionModel> updateExecute(String name, String code) {
        return null;
    }

    @Override
    public ResponseEntity<Long> deleteExecute(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<RegionModel>> pageExecute(String page, String size) {
        return null;
    }
}

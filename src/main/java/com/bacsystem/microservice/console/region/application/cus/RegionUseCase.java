package com.bacsystem.microservice.console.region.application.cus;


import com.bacsystem.microservice.console.region.application.port.input.IRegionInputPort;
import com.bacsystem.microservice.console.region.application.port.output.database.IRepositoryCommand;
import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * RegionUseCase
 * <p>
 * RegionUseCase class.
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
@Component
public class RegionUseCase implements IRegionInputPort {

    private final IRepositoryCommand commandOutputPort;

    public RegionUseCase(IRepositoryCommand commandOutputPort) {
        this.commandOutputPort = commandOutputPort;
    }


    @Override
    public RegionModel save(String name, String code) {
        log.info("use case name {}, code {} ", name, code);
        return commandOutputPort.save(RegionModel.builder()
                .id(0)
                .re_uuid(UUID.randomUUID().toString())
                .re_code(code)
                .re_name(name)
                .build());
    }

    @Override
    public RegionModel update(String name, String code) {
        return null;
    }
}

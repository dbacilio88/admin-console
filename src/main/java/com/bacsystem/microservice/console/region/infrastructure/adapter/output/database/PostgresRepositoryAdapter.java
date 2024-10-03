package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database;


import com.bacsystem.microservice.console.region.application.port.output.database.IRepositoryCommand;
import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import com.bacsystem.microservice.console.region.infrastructure.adapter.input.mapper.IRegionMapper;
import com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.IBsRegionRepository;
import com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity.BsRegionEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * PostgresRepositoryAdapter
 * <p>
 * PostgresRepositoryAdapter class.
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
@AllArgsConstructor
public class PostgresRepositoryAdapter implements IRepositoryCommand {


    private final IBsRegionRepository regionRepository;
    private final IRegionMapper regionMapper;

    @Override
    public RegionModel save(RegionModel model) {
        final BsRegionEntity entity = regionRepository.save(this.regionMapper.toEntity(model));
        return regionMapper.toDto(entity);
    }
}

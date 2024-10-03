package com.bacsystem.microservice.console.region.application.cus;


import com.bacsystem.microservice.console.region.application.port.input.IMessageBrokerInputPort;
import com.bacsystem.microservice.console.region.application.port.output.database.IRepositoryQuery;
import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * MessageBrokerUseCase
 * <p>
 * MessageBrokerUseCase class.
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
public class MessageBrokerUseCase implements IMessageBrokerInputPort {

    private final IRepositoryQuery repositoryQuery;

    Map<String, Class<?>> classes = Map.of("bs_region", RegionModel.class);

    public MessageBrokerUseCase(IRepositoryQuery repositoryQuery) {
        this.repositoryQuery = repositoryQuery;
    }

    @Override
    public void deleteReg(String table, Map<String, Object> reg) {

        this.repositoryQuery.delete((String) reg.get("id"), classes.get(table));
    }

    @Override
    public void updateReg(String table, Map<String, Object> reg) {
        this.repositoryQuery.save(reg, classes.get(table));
    }

    @Override
    public void insertReg(String table, Map<String, Object> reg) {
        log.info("insertReg {} ", table);
        log.info("insertReg {}", reg);
        log.info("insertReg {}", classes.get(table));
        this.repositoryQuery.save(reg, classes.get(table));
    }

    @Override
    public List<Map<String, Object>> getAll(String table) {
        return repositoryQuery.getAll(classes.get(table));
    }

    @Override
    public List<RegionModel> getAlls(String table) {
        return repositoryQuery.getAlls(classes.get(table));
    }
}

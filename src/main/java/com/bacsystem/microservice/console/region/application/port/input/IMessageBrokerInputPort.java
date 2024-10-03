package com.bacsystem.microservice.console.region.application.port.input;


import com.bacsystem.microservice.console.region.domain.model.RegionModel;

import java.util.List;
import java.util.Map;

/**
 * IMessageBrokerInputPort
 * <p>
 * IMessageBrokerInputPort interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */

public interface IMessageBrokerInputPort {
     void deleteReg(String table, Map<String, Object> reg);

     void updateReg(String table, Map<String, Object> reg);

     void insertReg(String table, Map<String, Object> reg);

     List<Map<String, Object>> getAll(String table);

     List<RegionModel> getAlls(String table);
}

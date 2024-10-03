package com.bacsystem.microservice.console.region.application.port.output.database;


import com.bacsystem.microservice.console.region.domain.model.RegionModel;

import java.util.List;
import java.util.Map;

/**
 * IRepositoryQuery
 * <p>
 * IRepositoryQuery interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 1/10/2024
 */

public interface IRepositoryQuery {
    public void save(Map<String, Object> reg, Class<?> clazz);

    public void delete(String id, Class<?> clazz);

    public Map<String, Object> getById(String id, Class<?> clazz);

    public List<Map<String, Object>> getAll(Class<?> clazz);

    public List<RegionModel> getAlls(Class<?> clazz);
}

package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database;


import com.bacsystem.microservice.console.region.application.port.output.database.IRepositoryQuery;
import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.utils.ConversionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class RedisRepositoryAdapter implements IRepositoryQuery {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(Map<String, Object> reg, Class<?> clazz) {
        redisTemplate.opsForHash().put(
                getHashFromClass(clazz),
                String.valueOf(reg.get("id")),
                ConversionUtils.map2Jsonstring(reg)
        );
    }

    @Override
    public void delete(String id, Class<?> clazz) {

    }

    @Override
    public Map<String, Object> getById(String id, Class<?> clazz) {
        return ConversionUtils
                .jsonstring2Map((String) redisTemplate
                        .opsForHash()
                        .get(getHashFromClass(clazz), id));

    }

    @Override
    public List<Map<String, Object>> getAll(Class<?> clazz) {
        return redisTemplate.opsForHash()
                .values(getHashFromClass(clazz))
                .stream()
                .map(el -> ConversionUtils.jsonstring2Map((String) el))
                .collect(Collectors.toList());
    }

    @Override
    public List<RegionModel> getAlls(Class<?> clazz) {
        return redisTemplate.opsForHash()
                .values(getHashFromClass(clazz))
                .stream()
                .map(el -> ConversionUtils.jsonstring2Map((String) el))
                .map(this::convertToRegionModel)
                .collect(Collectors.toList());
    }

    private String getHashFromClass(Class<?> clazz) {
        log.info("getHashFromClass {}", clazz.getName().replace('.', '_'));
        return clazz.getName().replace('.', '_');
    }

    private void addRegion(Map<String, Object> region, boolean appendOrder) {
        String regionId = (String) region.get("id");
        if (regionId == null) return;

        String customerJson = ConversionUtils.map2Jsonstring(region);

        redisTemplate.opsForHash().put(getHashFromClass(RegionModel.class), regionId, customerJson);
    }

    private RegionModel convertToRegionModel(Map<String, Object> map) {
        RegionModel region = new RegionModel();
        log.info("convertToRegionModel {}", map);
        region.setId((Integer) map.get("id"));  // Ajusta según tus campos
        region.setRe_code((String) map.get("re_code"));  // Ajusta según tus campos
        region.setRe_name((String) map.get("re_name"));  // Ajusta según tus campos
        region.setRe_uuid((String) map.get("re_uuid"));  // Ajusta según tus campos
        // Agrega otros campos según sea necesario
        return region;
    }
}

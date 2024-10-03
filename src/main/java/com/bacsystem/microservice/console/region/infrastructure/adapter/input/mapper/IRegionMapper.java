package com.bacsystem.microservice.console.region.infrastructure.adapter.input.mapper;


import com.bacsystem.microservice.console.region.domain.model.RegionModel;
import com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity.BsRegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * IRegionMapper
 * <p>
 * IRegionMapper interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 25/09/2024
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface IRegionMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "reUuid", source = "re_uuid")
    @Mapping(target = "reName", source = "re_name")
    @Mapping(target = "reCode", source = "re_code")
    BsRegionEntity toEntity(RegionModel dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "re_uuid", source = "reUuid")
    @Mapping(target = "re_name", source = "reName")
    @Mapping(target = "re_code", source = "reCode")
    RegionModel toDto(BsRegionEntity entity);

    List<RegionModel> toList(Iterable<BsRegionEntity> entities);

    default Page<RegionModel> toPage(Page<BsRegionEntity> entities) {
        List<RegionModel> list = entities.getContent()
                .stream()
                .map(this::toDto)
                .toList();
        return new PageImpl<>(list, entities.getPageable(), entities.getTotalElements());
    }


}

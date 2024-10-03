package com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository;


import com.bacsystem.microservice.console.region.infrastructure.adapter.output.database.repository.entity.BsRegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IBsRegionRepository
 * <p>
 * IBsRegionRepository interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */

@Repository
public interface IBsRegionRepository extends JpaRepository<BsRegionEntity, Long> {
}

package com.simplyminds.supplier.repository;

import com.simplyminds.supplier.entity.SupplierEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> , JpaSpecificationExecutor<SupplierEntity> {

    boolean existsByName(String name);
}

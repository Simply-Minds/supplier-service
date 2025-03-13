package com.simplyminds.supplier.mapper;

import com.simplyminds.model.Supplier;
import com.simplyminds.supplier.entity.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplierMapper {

        /**
         * Map a SupplierEntity to a Supplier DTO.
         *
         * @param supplierEntity the supplier entity
         * @return the corresponding Supplier DTO
         */
        @Mapping(source = "supplierId", target = "id")
        @Mapping(source = "productIds", target = "productId")  // Explicit mapping
        Supplier supplierEntityToSupplierDTO(SupplierEntity supplierEntity);

        /**
         * Map a Supplier DTO to a SupplierEntity.
         *
         * @param supplierDto the supplier DTO
         * @return the corresponding Supplier entity
         */
        @Mapping(source = "id", target = "supplierId")
        @Mapping(source = "productId", target = "productIds")  // Explicit mapping
        SupplierEntity supplierDtoToSupplierEntity(Supplier supplierDto);

        // Helper method for mapping List<Long> correctly (optional)
        default List<Long> mapProductIds(List<Long> productIds) {
                return productIds;
        }
}

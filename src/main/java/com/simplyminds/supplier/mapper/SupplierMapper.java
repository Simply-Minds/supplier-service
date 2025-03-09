package com.simplyminds.supplier.mapper;


import com.simplyminds.model.Supplier;

import com.simplyminds.supplier.entity.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

        /**
         * Map a supplier entity to a SupplierDto.
         *
         * @param SupplierEntity the supplier entity
         * @return the corresponding SupplierDto
         */
        @Mapping(source = "supplierId", target = "id")
        Supplier supplierEntityToSupplierDTO(SupplierEntity SupplierEntity);

        /**
         * Map a SupplierDto to a Supplier entity.
         *
         * @param supplierDto the supplier DTO
         * @return the corresponding Supplier entity
         */
        @Mapping(source = "id", target = "categoryId")
        SupplierEntity supplierDtoToSupplierEntity(Supplier supplierDto);

//    @Named("supplierDtoIdToEntity")
//    default SupplierEntity SupplierIdToEntity(Long supplierId) {
//        if (supplierId == null) {
//            return null;
//        }
//        SupplierEntity supplierEntity = new SupplierEntity();
//        supplierEntity.setSupplierId(supplierId);
//        return supplierEntity;
//    }
    }

}

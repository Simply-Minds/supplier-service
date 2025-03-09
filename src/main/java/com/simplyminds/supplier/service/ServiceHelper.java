package com.simplyminds.supplier.service;

import com.simplyminds.model.SuccessResponseDTO;
import com.simplyminds.model.SupplierListResponseDTO;
import com.simplyminds.model.SupplierResponseDTO;
import com.simplyminds.supplier.entity.SupplierEntity;
import org.springframework.data.domain.Page;

public interface ServiceHelper {
    SupplierResponseDTO setSupplierResponseDTO(SupplierEntity savedProduct, boolean success, String errCode, String errMessage);
    SupplierListResponseDTO setListSupplierResponseDTO(boolean success, int page, int size, Page<SupplierEntity> productsPage, String errCode, String errMessage);

    SuccessResponseDTO setSuccessResponseDto(boolean success, String errCode, String errMessage);
}

package com.simplyminds.supplier.service;

import com.simplyminds.model.*;
import com.simplyminds.supplier.dto.ProductDTO;

import java.util.List;

public interface SupplierService {
    SupplierResponseDTO createSupplier(Supplier supplierDto);

    SupplierListResponseDTO getListOfSupplier(Integer page, Integer size, String filter, String search);
    List<ProductDTO>  getProductsDto(Long supplierId);
    SuccessResponseDTO supplerIdDelete(Integer id);

    SupplierResponseDTO supplierIdPut(Integer id, Supplier supplierDto);

    SupplierResponseDTO suppliersIdGet(Integer id);

}

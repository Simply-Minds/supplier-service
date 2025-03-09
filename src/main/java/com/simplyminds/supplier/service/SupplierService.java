package com.simplyminds.supplier.service;

import com.simplyminds.model.SuccessResponseDTO;
import com.simplyminds.model.Supplier;
import com.simplyminds.model.SupplierListResponseDTO;
import com.simplyminds.model.SupplierResponseDTO;

public interface SupplierService {
    SupplierResponseDTO createSupplier(Supplier supplierDto);

    SupplierListResponseDTO getListOfSupplier(Integer page, Integer size, String filter, String search);

    SuccessResponseDTO supplerIdDelete(Integer id);

    SupplierResponseDTO supplierIdPut(Integer id, Supplier supplierDto);

    SupplierResponseDTO suppliersIdGet(Integer id);

}

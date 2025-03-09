package com.simplyminds.supplier.controller;

import com.simplyminds.api.SuppliersApi;
import com.simplyminds.model.SuccessResponseDTO;
import com.simplyminds.model.Supplier;
import com.simplyminds.model.SupplierListResponseDTO;
import com.simplyminds.model.SupplierResponseDTO;
import com.simplyminds.supplier.repository.SupplierRepository;
import com.simplyminds.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping
@Validated
public class SupplierController implements SuppliersApi {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @Override
    public ResponseEntity<SupplierListResponseDTO> suppliersGet(Integer page, Integer size, String filter, String search) {
        SupplierListResponseDTO supplierListResponseDTO = supplierService.getListOfSupplier(page, size, filter, search);
        return new ResponseEntity<>(supplierListResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SuccessResponseDTO> suppliersIdDelete(Integer id) {
       SuccessResponseDTO successResponseDTO = supplierService.supplerIdDelete(id);
       return new ResponseEntity<>(successResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SupplierResponseDTO> suppliersIdGet(Integer id) {
        SupplierResponseDTO supplierResponseDTO = supplierService.suppliersIdGet(id);
        return new ResponseEntity<>(supplierResponseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SupplierResponseDTO> suppliersIdPut(Integer id, Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = supplierService.supplierIdPut(id, supplier);
        return new ResponseEntity<>(supplierResponseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SupplierResponseDTO> suppliersPost(Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = supplierService.createSupplier(supplier);
        return new ResponseEntity<>(supplierResponseDTO,HttpStatus.CREATED);
    }
}

package com.simplyminds.supplier.controller;

import com.simplyminds.api.SuppliersApi;
import com.simplyminds.common.enums.ErrorCode;
import com.simplyminds.common.exception.BadRequestException;
import com.simplyminds.common.exception.NotFoundException;
import com.simplyminds.model.*;
import com.simplyminds.supplier.dto.ProductDTO;
import com.simplyminds.supplier.mapper.ProductDtosMapper;
import com.simplyminds.supplier.service.ServiceHelper;
import com.simplyminds.supplier.service.SupplierService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The SupplierController is responsible to perform , Crud operations on supplier
 * The key thing to take a look at the productsIdGet() which is responsible to set the get the product by
 * SupplierId.
 * NOTE a single supplier may have multiple products so, for this what i did is i added the productId to thr supplierEntity
 * And then calling the product-service to get the details of product.
 * Used WebClient for making communication between services.
 * **/

@RestController
@RequestMapping
@Validated
public class SupplierController implements SuppliersApi {

    private final SupplierService supplierService;
    private ServiceHelper serviceHelper;
    @Autowired
    private ProductDtosMapper productDtosMapper;



    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * Retrieves the list of products associated with a specific supplier based on the supplier ID.
     * If no products are found for the given supplier ID, a 404 Not Found response is returned.
     *
     * @param id The ID of the supplier for which to retrieve the products. Must be a positive integer
     *           and greater than or equal to 1.
     * @return A {@code ResponseEntity} containing a list of {@code ProductDto} objects if products
     * are found, or a 404 Not Found response if the product list is empty.
     */
    @Override
    public ResponseEntity<List<ProductDto>> suppliersIdProductsGet(@Min(1) Integer id) {
      // Call the service to fetch products synchronously
        List<ProductDto> products = new ArrayList<>();
        for (ProductDTO product:  supplierService.getProductsDto(Long.valueOf(id))){
            products.add(productDtosMapper.productDTOToProductDto(product));
        }
        // Handle an empty product list gracefully
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();  // Return 404 if no products found
            }

            return ResponseEntity.ok(products);  // Return 200 with the list of products
    }

    @Override
    public ResponseEntity<SupplierListResponseDTO> suppliersGet(Integer page, Integer size, String filter, String search) {
        SupplierListResponseDTO supplierListResponseDTO = supplierService.getListOfSupplier(page, size, filter, search);
        return new ResponseEntity<>(supplierListResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SuccessResponseDTO> suppliersIdDelete(Integer id) {
        try {
            SuccessResponseDTO successResponseDTO = supplierService.supplerIdDelete(id);
            return ResponseEntity.ok(successResponseDTO);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(serviceHelper.setSuccessResponseDto(false, ErrorCode.ERR404.getCode(), ErrorCode.ERR404.getMessage()));
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(serviceHelper.setSuccessResponseDto(false,ErrorCode.BAD0001.getCode(), ErrorCode.BAD0001.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(serviceHelper.setSuccessResponseDto(false, ErrorCode.ERR500.getCode(), ErrorCode.ERR500.getMessage()));
        }
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

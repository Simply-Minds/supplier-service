package com.simplyminds.supplier.service.Impl;

import com.simplyminds.model.*;
import com.simplyminds.supplier.entity.SupplierEntity;
import com.simplyminds.supplier.mapper.SupplierMapper;
import com.simplyminds.supplier.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class ServiceHelperImpl implements ServiceHelper {
        @Autowired
        private SupplierMapper supplierMapper;

        @Override
        public SupplierResponseDTO setSupplierResponseDTO(SupplierEntity savedProduct, boolean success, String errCode, String errMessage) {
            Supplier entityToSupplierDTO = supplierMapper.supplierEntityToSupplierDTO(savedProduct);
           SupplierResponseDTO supplierResponseDto = new SupplierResponseDTO();
            supplierResponseDto.setData(entityToSupplierDTO);
            supplierResponseDto.errorCode(errCode);
            supplierResponseDto.errorMessage(errMessage);
            supplierResponseDto.setSuccess(success);
            return supplierResponseDto;
        }

        @Override
        public SupplierListResponseDTO setListSupplierResponseDTO(boolean success, int page, int size, Page<SupplierEntity> SupplierPage, String errCode, String errMessage) {
            SupplierListResponseDTO supplierListResponseDTO = new SupplierListResponseDTO();
            // Iterating over SupplierPage.getContent to map the
            List<Supplier> supplierList = new ArrayList<>();
            for (SupplierEntity supplier: SupplierPage.getContent()){
                supplierList.add(supplierMapper.supplierEntityToSupplierDTO(supplier));
            }
            supplierListResponseDTO.setData(supplierList);
            supplierListResponseDTO.errorMessage(errMessage);
            supplierListResponseDTO.errorCode(errCode);
            supplierListResponseDTO.setSuccess(success);
            PaginationDTO pagination = new PaginationDTO();

            pagination.setTotalObjects(((int) SupplierPage.getTotalElements()));
            pagination.currentPage(page);
            pagination.setTotalPages(SupplierPage.getTotalPages());
            pagination.currentSize(size);
            supplierListResponseDTO.setPagination(pagination);
            supplierListResponseDTO.getPagination().getTotalObjects();
            supplierListResponseDTO.getPagination().getCurrentSize();
            supplierListResponseDTO.getPagination().getCurrentPage();
            supplierListResponseDTO.getPagination().getTotalPages();
            return supplierListResponseDTO;
        }

        @Override
        public SuccessResponseDTO setSuccessResponseDto(boolean success, String errCode, String errMessage) {
            SuccessResponseDTO successResponseDTO = new SuccessResponseDTO();
            successResponseDTO.success(success);
            successResponseDTO.errorCode(errCode);
            successResponseDTO.errorMessage(errMessage);
            successResponseDTO.data(null);
            return successResponseDTO;
        }
    }


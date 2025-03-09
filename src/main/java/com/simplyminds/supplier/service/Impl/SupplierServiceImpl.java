package com.simplyminds.supplier.service.Impl;

import com.simplyminds.common.enums.ErrorCode;
import com.simplyminds.common.exception.ResourceAlreadyExistException;
import com.simplyminds.common.service.impl.GenericServiceImpl;

import com.simplyminds.model.SuccessResponseDTO;
import com.simplyminds.model.Supplier;
import com.simplyminds.model.SupplierListResponseDTO;
import com.simplyminds.model.SupplierResponseDTO;
import com.simplyminds.supplier.entity.SupplierEntity;
import com.simplyminds.supplier.mapper.SupplierMapper;
import com.simplyminds.supplier.repository.SupplierRepository;
import com.simplyminds.supplier.service.ServiceHelper;
import com.simplyminds.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


/**
 * Service implementation for managing suppliers.
 * This class extends the GenericServiceImpl and implements the SupplierService interface.
 * It provides methods for creating, retrieving, updating, and deleting suppliers.
 *
 * Dependencies:
 * - SupplierMapper: for mapping between Supplier DTOs and Supplier entities.
 * - ServiceHelper: for setting response DTOs.
 *
 * Methods:
 * - createSupplier(Supplier supplierDto): Creates a new supplier.
 * - getListOfSupplier(Integer page, Integer size, String filter, String search): Retrieves a paginated list of suppliers.
 * - supplerIdDelete(Integer id): Deletes a supplier by ID.
 * - supplierIdPut(Integer id, Supplier supplierDto): Updates a supplier by ID.
 * - suppliersIdGet(Integer id): Retrieves a supplier by ID.
 *
 * Exceptions:
 * - ResourceAlreadyExistException: Thrown if a supplier with the same name already exists.
 *
 * Annotations:
 * - @Service: Indicates that this class is a service component in the Spring context.
 * - @Autowired: Marks the constructor for dependency injection.
 */
@Service
public class SupplierServiceImpl extends GenericServiceImpl<SupplierEntity, SupplierRepository> implements SupplierService {

    private final SupplierMapper supplierMapper;
    private final ServiceHelper serviceHelper;

    /**
     * Constructs a new SupplierServiceImpl.
     *
     * @param repository the supplier repository
     * @param supplierMapper the supplier mapper
     * @param serviceHelper the service helper
     */
    @Autowired
    public SupplierServiceImpl(SupplierRepository repository, SupplierMapper supplierMapper, ServiceHelper serviceHelper) {
        super(repository);
        this.supplierMapper = supplierMapper;
        this.serviceHelper = serviceHelper;
    }

    /**
     * Creates a new supplier.
     *
     * @param supplierDto the supplier DTO
     * @return the created supplier response DTO
     * @throws ResourceAlreadyExistException if a supplier with the same name already exists
     */
    @Override
    public SupplierResponseDTO createSupplier(Supplier supplierDto) {
        if (repository.existsByName(supplierDto.getName())) {
            throw new ResourceAlreadyExistException(ErrorCode.RES0001.getCode(), ErrorCode.RES0001.getMessage());
        }
        SupplierEntity supplierEntity = supplierMapper.supplierDtoToSupplierEntity(supplierDto);
        SupplierEntity savedProduct = super.createObject(supplierEntity);
        return serviceHelper.setSupplierResponseDTO(savedProduct, true, null, null);
    }

    /**
     * Retrieves a paginated list of suppliers.
     *
     * @param page the page number
     * @param size the page size
     * @param filter the filter criteria
     * @param search the search criteria
     * @return the list of suppliers response DTO
     */
    @Override
    public SupplierListResponseDTO getListOfSupplier(Integer page, Integer size, String filter, String search) {
        Page<SupplierEntity> supplierEntities = super.getListOfObjects(page, size, filter, search);
        return serviceHelper.setListSupplierResponseDTO(true, page, size, supplierEntities, null, null);
    }

    /**
     * Deletes a supplier by ID.
     *
     * @param id the supplier ID
     * @return the success response DTO
     */
    @Override
    public SuccessResponseDTO supplerIdDelete(Integer id) {
        return serviceHelper.setSuccessResponseDto(super.DeleteObject(id), null, null);
    }

    /**
     * Updates a supplier by ID.
     *
     * @param id the supplier ID
     * @param supplierDto the supplier DTO
     * @return the updated supplier response DTO
     * @throws ResourceAlreadyExistException if a supplier with the same name already exists
     */
    @Override
    public SupplierResponseDTO supplierIdPut(Integer id, Supplier supplierDto) {
        if (repository.existsByName(supplierDto.getName())) {
            throw new ResourceAlreadyExistException(ErrorCode.RES0001.getCode(), ErrorCode.RES0001.getMessage());
        }
        SupplierEntity supplierEntity = supplierMapper.supplierDtoToSupplierEntity(supplierDto);
        SupplierEntity savedProduct = super.objectsIdPut(id, supplierEntity);
        return serviceHelper.setSupplierResponseDTO(savedProduct, true, null, null);
    }

    /**
     * Retrieves a supplier by ID.
     *
     * @param id the supplier ID
     * @return the supplier response DTO
     */
    @Override
    public SupplierResponseDTO suppliersIdGet(Integer id) {
        return serviceHelper.setSupplierResponseDTO(super.objectsIdGet(id), true, null, null);
    }
}


package com.simplyminds.supplier.mapper;

import com.simplyminds.supplier.dto.ProductDTO; // Custom DTO from src folder
import com.simplyminds.model.ProductDto; // Generated DTO
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDtosMapper {

    /**
     * Map a generated ProductDto to the custom ProductDTO.
     *
     * @param productDto the generated ProductDto
     * @return the corresponding custom ProductDTO
     */
    @Mapping(source = "id", target = "productId")
    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "productUnitId", target = "productUnit")
    ProductDTO productDtoToProductDTO(ProductDto productDto);

    /**
     * Map a custom ProductDTO to the generated ProductDto.
     *
     * @param productDTO the custom ProductDTO
     * @return the corresponding generated ProductDto
     */
    @Mapping(source = "productId", target = "id")
    @Mapping(source = "category", target = "categoryId")
    @Mapping(source = "productUnit", target = "productUnitId")
    ProductDto productDTOToProductDto(ProductDTO productDTO);
}
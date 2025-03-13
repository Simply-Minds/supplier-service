package com.simplyminds.supplier.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplyminds.supplier.dto.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDTO> getProductById(List<Integer> productIds) {
        List<ProductDTO> products = new ArrayList<>();

        for (Integer id : productIds) {
            try {
                // Make a synchronous GET call for each product ID
                ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                        "http://localhost:8082/product-service/v1/products/{id}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Map<String, Object>>() {},
                        id

                );
                Map<String, Object> responseBody = response.getBody();
                ObjectMapper objectMapper = new ObjectMapper();
                assert responseBody != null;
                ProductDTO product = objectMapper.convertValue(responseBody.get("data"), ProductDTO.class);

                // Check for a successful response and add to the list
                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    products.add(product);
                }

            } catch (Exception e) {
                System.err.println("Failed to fetch product with ID: " + id);
                e.printStackTrace(); // Log the exception but continue fetching other products
            }
        }

        return products;
    }

}
package com.simplyminds.supplier.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//TODO test cases , and communication btw product-service.

@Entity
@Table(name = "supplier")
@Setter
@Getter
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;
    @ElementCollection
    @CollectionTable(name = "supplier_products", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "product_id")
    private List<Long> productIds;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String status;
    private String location;
    public SupplierEntity() {}

    public SupplierEntity(Long supplierId, List<Long> productIds, String name, String address, String phone, String email, String status, String location) {
        this.supplierId = supplierId;
        this.productIds = productIds;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.location = location;
    }
}

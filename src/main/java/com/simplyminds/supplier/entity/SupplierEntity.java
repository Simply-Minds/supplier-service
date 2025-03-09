package com.simplyminds.supplier.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "supplier")
@Setter
@Getter
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String status;
    private String location;
    public SupplierEntity() {}

    public SupplierEntity(Long supplierId, Long productId, String name, String address, String phone, String email, String status, String location) {
        this.supplierId = supplierId;
        this.productId = productId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.location = location;
    }
}

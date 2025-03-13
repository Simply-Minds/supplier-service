--liquibase formatted sql
--changeset Jeet:2
-- IOMS-1015: Alter supplier table and create supplier_products table

ALTER TABLE supplier
    ADD COLUMN address VARCHAR(255),
    ADD COLUMN phone VARCHAR(20),
    ADD COLUMN email VARCHAR(100),
    ADD COLUMN location VARCHAR(255);

-- Create supplier_products table for mapping supplier to products
CREATE TABLE IF NOT EXISTS supplier_products (
                                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                 supplier_id BIGINT NOT NULL,
                                                 product_id BIGINT NOT NULL,
                                                 FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id) ON DELETE CASCADE
    );

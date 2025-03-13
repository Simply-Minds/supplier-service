--liquibase formatted sql
--changeset Jeet:1
-- IOMS-1014: Create Basic Database Schema for supplier

CREATE TABLE supplier (
                          supplier_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          product_id BIGINT,
                          name VARCHAR(100) NOT NULL,
                          status VARCHAR(100)

);

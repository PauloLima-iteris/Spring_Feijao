package com.example.project.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SupplierId", nullable = false)
    private Supplier supplier;

    @Column(nullable = false, length = 40, columnDefinition="nvarchar(40)")
    private String productName;

    @Column(nullable = false)
    private Integer supplierId;

    @Column(nullable = true, columnDefinition="Decimal(12,2) default '0'")
    private Double unitPrice;

    @Column(nullable = false, length = 30, name = "Package", columnDefinition="nvarchar(30)")
    private String packageName;

    @Column(nullable = false, columnDefinition="bit default '0'")
    private Boolean isDiscontinued;

    @Column(nullable = false, length = 400)
    private String imagem;
}
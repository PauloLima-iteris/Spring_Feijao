package com.example.project.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.project.domain.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private Integer id;

    private Supplier supplier;

    @NotEmpty(message = "Product Name is required")
    @NotNull
    private String productName;

    @NotNull
    private Integer supplierld;

    private Double unitPrice;

    @NotEmpty(message = "Package is required")
    private String packageName;

    @NotNull
    private Boolean isDiscontinued;

    @NotNull
    private String imagem;
}
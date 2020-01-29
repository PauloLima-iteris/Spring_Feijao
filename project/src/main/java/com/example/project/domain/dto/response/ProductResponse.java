package com.example.project.domain.dto.response;

import com.example.project.domain.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    
    private Integer id;
    private Supplier supplier;
    private String productName;
    private Integer supplierId;
    private Double unitPrice;
    private String packageName;
    private Boolean isDiscontinued;
    private String imagem;
}


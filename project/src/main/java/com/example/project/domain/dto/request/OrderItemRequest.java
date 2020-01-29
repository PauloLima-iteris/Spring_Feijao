package com.example.project.domain.dto.request;

import javax.validation.constraints.NotNull;

import com.example.project.domain.entities.Ordeer;
import com.example.project.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {

    private Integer id;
    
    private Ordeer ordeer;

    private Product product;

    @NotNull
    private Integer orderId;

    @NotNull
    private Integer productId;

    @NotNull
    private Double unitPrice;

    @NotNull
    private Integer quantity;
}
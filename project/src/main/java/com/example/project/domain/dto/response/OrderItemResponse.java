package com.example.project.domain.dto.response;

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
public class OrderItemResponse {

    private Integer id;
    private Ordeer ordeer;
    private Product product;
    private Integer orderId;
    private Integer productId;
    private Double unitPrice;
    private Integer quantity;
}


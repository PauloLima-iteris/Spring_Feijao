package com.example.project.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.project.domain.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private Integer id;

    private Customer customer;

    @NotNull
    private Date orderDate;

    @NotEmpty(message = "OrderNumber is required")
    private String orderNumber;

    @NotNull
    private Integer customerld;

    private Double totalAmount;
}
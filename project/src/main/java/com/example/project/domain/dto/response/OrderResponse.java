package com.example.project.domain.dto.response;

import java.util.Date;
import com.example.project.domain.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    
    private Integer id;
    private Customer customer;
    private Date orderDate;
    private String orderNumber;
    private Integer customerId;
    private Double totalAmount;
}



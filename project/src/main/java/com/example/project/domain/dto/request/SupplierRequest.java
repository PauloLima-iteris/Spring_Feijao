package com.example.project.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierRequest {

    private Integer id;

    @NotEmpty(message = "Company Name is required")
    @NotNull
    private String companyName;
    
    @NotEmpty(message = "Contact Name is required")
    private String contactName;
    
    @NotEmpty(message = "Contact Title is required")
    private String contactTitle;
    
    @NotEmpty(message = "City is required")
    private String city;
    
    @NotEmpty(message = "Country is required")
    private String country;
    
    @NotEmpty(message = "Phone is required")
    private String phone;
    
    @NotEmpty(message = "Fax is required")
    private String fax;
}


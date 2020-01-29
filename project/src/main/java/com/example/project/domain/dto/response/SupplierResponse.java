package com.example.project.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierResponse {

    private Integer id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String city;
    private String country;
    private String phone;
    private String fax;
}




package com.example.project.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String phone;
}
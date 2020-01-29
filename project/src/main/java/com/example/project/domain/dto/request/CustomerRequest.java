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
public class CustomerRequest {

    private Integer id;

    @NotEmpty(message = "firstname is required")
    @NotNull
    private String firstName;

    @NotEmpty(message = "lastname is required")
    @NotNull
    private String lastName;

    @NotEmpty(message = "city is required")
    private String city;

    @NotEmpty(message = "country is required")
    private String country;

    @NotEmpty(message = "phone is required")
    private String phone;
}
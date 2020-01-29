package com.example.project.domain.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ordeer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(nullable = false, columnDefinition= "datetime default getdate()")
    private Date orderDate;

    @Column(nullable = true, length = 10, columnDefinition= "nvarchar(10)")
    private String orderNumber;

    @Column(nullable = false)
    private Integer customerId;

    @Column(nullable = true, columnDefinition="Decimal(12,2) default '0'")
    private Double totalAmount;
}
package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@NoArgsConstructor
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal comissionRate;
    private Integer payoutDelayCount;

    //Merchant and Payment
    //one merchant has many payments

    @OneToMany(mappedBy = "merchant")
    private List<Payment> paymentList;
    // not creating merchant_payment_list as another table and
    // not creating foreign key merchant_id and "payment_id" inside the merchant_payment_list  table


    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal comissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.comissionRate = comissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}

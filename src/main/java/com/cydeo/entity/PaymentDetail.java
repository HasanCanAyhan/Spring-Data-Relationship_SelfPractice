package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paymentDetails")
@NoArgsConstructor
@Data
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal comissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    /*
    We want to be able to get Payment from PaymentDetail class and PaymentDetail from Payment class,
    but we don't want to put foreign key in both tables in database,
    we only want to be able to use that in Java side.

    we do that so we can have access to the payment object inside the payment detail without duplicating the foreign key
    bidirectional : two
    unidirectional : one
     */

    @OneToOne(mappedBy = "paymentDetail") // not creating foreign key "payment_id" inside the paymentdetail table
    private Payment payment;


    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal comissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.comissionAmount = comissionAmount;
        this.payoutDate = payoutDate;
    }
}

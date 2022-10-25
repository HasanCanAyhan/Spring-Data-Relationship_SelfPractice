package com.cydeo.entity;


import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    //every payment has payment detail

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;


    //Cascading used not so much
    //@OneToOne(cascade = CascadeType.ALL)
    //Whatever you do in the parent class "Payment" do same action inside the child"PaymentDetail"
    //With Cascading, child table's fields will be created and filled before parent "payment table"
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "payment_detail_id") // it means join, it is created foreign key inside the payment table
    private PaymentDetail paymentDetail;

    //-----------------------------------------------

    //Many payments one merchant
    @ManyToOne
    private Merchant merchant;
    //1.created merchant_id as foreign_key in the payment table


    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }



}

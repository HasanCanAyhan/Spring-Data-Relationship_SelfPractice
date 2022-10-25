package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    //Many Item Many Cart : such as Milk

    @ManyToMany(mappedBy = "itemList")
    private List<Cart> carts;



    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }


}

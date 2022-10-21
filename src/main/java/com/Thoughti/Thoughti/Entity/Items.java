package com.Thoughti.Thoughti.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

@Table
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer itemId;

    private String itemName;

    private double itemUnitPrice;

    private Integer itemQuantity;

    @ManyToOne()
    private Order order;


}

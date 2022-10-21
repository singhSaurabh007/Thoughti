package com.Thoughti.Thoughti.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private Date date;

    private String orderStatus;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Items> items = new ArrayList<>();
}

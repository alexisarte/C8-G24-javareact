package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull @Min(0)
    private Long stock;
    @NotNull
    private CategoryEnum category;
    @NotNull
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
}

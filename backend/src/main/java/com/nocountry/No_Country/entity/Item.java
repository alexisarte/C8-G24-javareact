package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String name;

    private Double price;

    private Long stock;

    @Enumerated(value = EnumType.STRING)
    private CategoryEnum category;
    @Enumerated(value= EnumType.STRING)
    private AnimalEnum animal;

    private String imageUrl;


}

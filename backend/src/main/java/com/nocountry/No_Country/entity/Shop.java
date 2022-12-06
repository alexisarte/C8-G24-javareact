package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="shop")
public class Shop {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String name;

    private Long phoneNumber;

    private String email;

    private String password;
    private String streetName;
    private String imageUrl;
    private String openingHours;
    private Double shipping;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="location_id")
    private Location location;

    @ManyToMany(cascade ={
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "shop_item",
            joinColumns = @JoinColumn(name="id_item"),
            inverseJoinColumns = @JoinColumn(name="id_shop"))

    private List<Item> shopItems = new ArrayList<>();

    public void addItem(Item item){
        this.shopItems.add(item);
    }




}

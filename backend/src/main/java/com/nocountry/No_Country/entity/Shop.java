package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long phoneNumber;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private String imageUrl;
    private String openingHours;
    private Double shipping;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="location_id")
    private Location location;


}

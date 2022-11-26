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
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;


    private String city;
    private String state;


    @OneToMany(mappedBy = "location")
    private List<User> users;

    @OneToMany(mappedBy = "location")
    private List<Shop> shops = new ArrayList<>();
}

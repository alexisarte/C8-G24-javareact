package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
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

    @NotNull
    private String city;
    @NotNull
    private String state;

    @NotNull
    @OneToMany(mappedBy = "location")
    private List<User> users;

    @OneToMany(mappedBy = "location")
    private List<Shop> shops;
}

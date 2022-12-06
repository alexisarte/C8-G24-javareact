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
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    private String streetName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name="location")
    private Location location;

    @OneToOne
    private Cart cart;

    @ManyToMany(cascade ={
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "user_fav_item",
            joinColumns = @JoinColumn(name="id_item"),
            inverseJoinColumns = @JoinColumn(name="id_user"))
    private List<Item> userFavItems = new ArrayList<>();

}

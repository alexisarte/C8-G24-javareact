package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private LocalDateTime localDateTime = LocalDateTime.now();
    @NotNull
    private Double totalAmount;


    @OneToMany(mappedBy = "cart")
    private List<Item> items;

    @OneToOne
    private User user;
}

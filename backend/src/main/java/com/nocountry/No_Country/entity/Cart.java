package com.nocountry.No_Country.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

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


    @ManyToMany(cascade ={
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "cart_item",
            joinColumns = @JoinColumn(name="id_item"),
            inverseJoinColumns = @JoinColumn(name="id_cart"))
    private List<Item> items = new ArrayList<>();

    @OneToOne
    private User user;


    public void addItem(Item item){
        this.items.add(item);
    }

    public void deleteItem(Long itemId){
        this.items.stream().filter(
                itemMap -> Objects.equals(itemMap.getId(), itemId))
                .findFirst().ifPresent(item -> this.items.remove(item));
    }
}

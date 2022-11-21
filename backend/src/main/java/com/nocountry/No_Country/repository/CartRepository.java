package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}

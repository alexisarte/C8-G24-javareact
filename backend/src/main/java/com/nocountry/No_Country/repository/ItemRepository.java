package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}

package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> getAllByCategory(CategoryEnum category);
}

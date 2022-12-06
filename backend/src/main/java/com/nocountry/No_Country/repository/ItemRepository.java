package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.AnimalEnum;
import com.nocountry.No_Country.entity.CategoryEnum;
import com.nocountry.No_Country.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> getAllByCategory(CategoryEnum category);

    Page<Item> getItemsByNameAndCategoryAndAnimal(String name,
                                                  CategoryEnum category,
                                                  AnimalEnum animal,
                                                  Pageable pageable);
    Page<Item> getItemsByNameAndCategoryOrAnimal(String name,
                                                  CategoryEnum category,
                                                  AnimalEnum animal,
                                                  Pageable pageable);
}

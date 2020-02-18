package com.vsnu.market.repositories;

import com.vsnu.market.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM item WHERE category_id = ?1", nativeQuery = true)
    List<Item> findByCategoryId(Integer id);


    @Query(value = "SELECT id FROM item WHERE category_id = ?1", nativeQuery = true)
    List<Integer> fetchIdsByCategoryId(Integer id);

    @Query(value = "select * from item where IFNULL(discount, 0) != 0 and discount_expiry > ?1", nativeQuery = true)
    List<Item> findDiscountedItems(LocalDateTime dateTime);

}
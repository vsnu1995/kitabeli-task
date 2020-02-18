package com.vsnu.market.repositories;

import com.vsnu.market.entities.Category;
import com.vsnu.market.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT id FROM category", nativeQuery = true)
    List<Integer> fetchCategoryIds();
}

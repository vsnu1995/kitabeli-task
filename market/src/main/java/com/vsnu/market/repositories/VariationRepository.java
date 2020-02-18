package com.vsnu.market.repositories;

import com.vsnu.market.entities.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Integer> {

    @Query(value = "SELECT * FROM variations WHERE item_id = ?1", nativeQuery = true)
    List<Variation> findByItemId(Integer id);
}

package com.vsnu.market.entities;

import com.vsnu.market.utilities.HashMapConverter;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
public class Variation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer stock;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Convert(converter = HashMapConverter.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> variations;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

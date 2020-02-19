package com.vsnu.market.tasks;

import com.vsnu.market.entities.Item;
import com.vsnu.market.repositories.CategoryRepository;
import com.vsnu.market.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class ScheduledTasks {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Scheduled(cron = "0 0 0 * * *") //Run everyday at 00:00
    public void putDiscountToRandomItem() {
        final List<Integer> categoryIds = categoryRepository.fetchCategoryIds();
        Random rand = new Random();
        LocalDateTime dt = LocalDateTime.now().plusDays(1);

        categoryIds.forEach(id -> {
            List<Integer> itemIds = itemRepository.fetchIdsByCategoryId(id);

            Integer idToUpdate = itemIds.get(rand.nextInt(itemIds.size()));

            Optional<Item> item = itemRepository.findById(idToUpdate);

            if(item.isPresent()){
                Item item1 = item.get();
                item1.setDiscount(10);
                item1.setDiscountExpiry(dt);
                itemRepository.save(item1);
            }
        });
    }
}

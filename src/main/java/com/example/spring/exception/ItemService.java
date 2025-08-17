package com.example.spring.exception;

import com.example.spring.exception.model.Item;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemService.class);

    private AtomicInteger counter = new AtomicInteger(0);

    @Retry(name = "itemService", fallbackMethod = "fallbackGetItem")
    public Item getItem(Long id) {
        log.info("Attempting to fetch item with ID {}", id);
        if (counter.incrementAndGet() % 2 != 0) {
            throw new RuntimeException("Temporary service failure!");
        }
        return new Item(id, "Resilient Item");
    }

    public Item fallbackGetItem(Long id, Exception ex) {
        log.warn("Fallback triggered for ID {} due to: {}", id, ex.getMessage());
        return new Item(-1L, "Fallback Item");
    }
}


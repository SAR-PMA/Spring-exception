package com.example.spring.exception.Controller;

import com.example.spring.exception.ItemService;
import com.example.spring.exception.dto.ItemRequest;
import com.example.spring.exception.exception.InvalidRequestException;
import com.example.spring.exception.exception.ResourceNotFoundException;
import com.example.spring.exception.model.Item;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        if(id <= 0) throw new InvalidRequestException("ID must be positive");
        if(id != 1) throw new ResourceNotFoundException("Item with ID " + id + " not found");
        return new Item(id, "Sample Item");
    }

    @PostMapping
    public Item createItem(@Valid @RequestBody ItemRequest request) {
        return new Item(1L, request.getName());
    }

    @GetMapping("/resilient/{id}")
    public Item getResilientItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }
}

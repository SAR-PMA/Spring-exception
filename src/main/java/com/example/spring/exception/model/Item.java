package com.example.spring.exception.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Item {
    private Long id;
    private String name;

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}


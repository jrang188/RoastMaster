package com.sirwayne.roastmaster;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> findById(@PathVariable Long id) {
        Coffee coffee = new Coffee(
                id,
                "Frank Torres: Sidra Natural",
                "September Coffee Co.",
                "Colombia",
                "Single Origin",
                "Narino",
                "Frank Torres",
                "Caturra",
                1850,
                "Honey",
                "Full Caffeine",
                List.of("Espresso"),
                "Light",
                List.of("Red fruits", "Watermelon", "Grape"),
                250,
                23.00,
                "CAD"
        );
        return ResponseEntity.ok(coffee);
    }
}

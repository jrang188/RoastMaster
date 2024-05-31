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
        Coffee coffee = new Coffee.Builder()
                .id(88L)
                .name("Frank Torres: Sidra Natural")
                .roaster("September Coffee Co.")
                .origin("Colombia")
                .originType("Single Origin")
                .region("Narino")
                .producer("Frank Torres")
                .variety("Caturra")
                .altitudeMASL(1850)
                .process("Honey")
                .caffeine("Full Caffeine")
                .roastLevel("Light")
                .quantity(250)
                .price(23.00)
                .currency("CAD")
                // Uncomment and modify the following lines if you have logic to convert the context read values to lists
                // .brewMethods(List.of(new BrewMethod(null, "Espresso")))
                // .tastingNotes(List.of(new TastingNote(null, "Red fruits"), new TastingNote(null, "Watermelon"), new TastingNote(null, "Grape")))
                .build();

        return ResponseEntity.ok(coffee);
    }
}

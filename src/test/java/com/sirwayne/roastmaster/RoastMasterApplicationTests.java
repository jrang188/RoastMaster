package com.sirwayne.roastmaster;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoastMasterApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnCoffeeWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/coffee/88", String.class);
        System.out.println(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext context = JsonPath.parse(response.getBody());
        Number id = context.read("$.id");
        assertThat(id).isEqualTo(88);

        Coffee coffee = new Coffee.Builder()
                .id(id.longValue())
                .name(context.read("$.name"))
                .roaster(context.read("$.roaster"))
                .origin(context.read("$.origin"))
                .originType(context.read("$.originType"))
                .region(context.read("$.region"))
                .producer(context.read("$.producer"))
                .variety(context.read("$.variety"))
                .altitudeMASL(context.read("$.altitudeMASL"))
                .process(context.read("$.process"))
                .caffeine(context.read("$.caffeine"))
                .roastLevel(context.read("$.roastLevel"))
                .quantity(context.read("$.quantity"))
                .price(context.read("$.price"))
                .currency(context.read("$.currency"))
                // Uncomment and modify the following lines if you have logic to convert the context read values to lists
                // .brewMethods(context.read("$.brewMethods"))
                // .tastingNotes(context.read("$.tastingNotes"))
                .build();

        Coffee expectedCoffee = new Coffee.Builder()
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

        assertThat(coffee).isEqualTo(expectedCoffee);

    }
}

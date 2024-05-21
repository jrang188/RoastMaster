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

        Coffee coffee = new Coffee(
                id.longValue(),
                context.read("$.name"),
                context.read("$.roaster"),
                context.read("$.origin"),
                context.read("$.originType"),
                context.read("$.region"),
                context.read("$.producer"),
                context.read("$.variety"),
                context.read("$.altitudeMASL"),
                context.read("$.process"),
                context.read("$.caffeine"),
                context.read("$.brewMethods"),
                context.read("$.roastLevel"),
                context.read("$.tastingNotes"),
                context.read("$.quantity"),
                context.read("$.price"),
                context.read("$.currency")
        );

        assertThat(coffee).isEqualTo(new Coffee(
                88L,
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
        ));
    }
}

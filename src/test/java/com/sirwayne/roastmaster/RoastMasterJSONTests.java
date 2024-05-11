package com.sirwayne.roastmaster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class RoastMasterJSONTests {

    @Autowired
    private JacksonTester<Coffee> json;

    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new Coffee(
                1L,                               // id
                "Frank Torres: Sidra Natural",   // name
                "September Coffee Co.",          // roaster
                "Colombia",                      // origin
                "Single Origin",                 // originTypeÏ
                "Narino",                        // region
                "Frank Torres",                  // producer
                "Caturra",                       // variety
                1850,                            // altitudeMASL
                "Honey",                         // process
                "Full Caffeine",                 // caffeineÏ
                List.of("Espresso"),         // brewMethod
                "Light",                         // roastLevel
                List.of("Red fruits", "Watermelon", "Grape"), // tastingNotes
                250,                             // quantity
                23.00,                           // price
                "CAD"                            // currency
        );
    }

    @Test
    void coffeeSerializationTest() throws IOException {
        assertThat(json.write(coffee)).isStrictlyEqualToJson("single.json");
        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.id").isEqualTo(1);

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.name");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.name").isEqualTo("Frank Torres: Sidra Natural");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.roaster");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.roaster").isEqualTo("September Coffee Co.");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.origin");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.origin").isEqualTo("Colombia");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.originType");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.originType").isEqualTo("Single Origin");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.region");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.region").isEqualTo("Narino");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.producer");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.producer").isEqualTo("Frank Torres");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.variety");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.variety").isEqualTo("Caturra");

        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.altitudeMASL");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.altitudeMASL").isEqualTo(1850);

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.process");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.process").isEqualTo("Honey");

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.caffeine");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.caffeine").isEqualTo("Full Caffeine");

        assertThat(json.write(coffee)).hasJsonPathArrayValue("@.brewMethods");
        assertThat(json.write(coffee)).extractingJsonPathArrayValue("@.brewMethods").isEqualTo(List.of("Espresso"));

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.roastLevel");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.roastLevel").isEqualTo("Light");

        assertThat(json.write(coffee)).hasJsonPathArrayValue("@.tastingNotes");
        assertThat(json.write(coffee)).extractingJsonPathArrayValue("@.tastingNotes").isEqualTo(List.of("Red fruits", "Watermelon", "Grape"));

        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.quantity");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.quantity").isEqualTo(250);

        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.price");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.price").isEqualTo(23.00);

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.currency");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.currency").isEqualTo("CAD");

    }

    @Test
    void coffeeDeserializationTest() throws IOException {
        Coffee coffee = json.readObject(new File("src/test/resources/com/sirwayne/roastmaster/single.json"));

        assertThat(coffee.id()).isEqualTo(1L);
        assertThat(coffee.name()).isEqualTo("Frank Torres: Sidra Natural");
        assertThat(coffee.roaster()).isEqualTo("September Coffee Co.");
        assertThat(coffee.origin()).isEqualTo("Colombia");
        assertThat(coffee.originType()).isEqualTo("Single Origin");
        assertThat(coffee.region()).isEqualTo("Narino");
        assertThat(coffee.producer()).isEqualTo("Frank Torres");
        assertThat(coffee.variety()).isEqualTo("Caturra");
        assertThat(coffee.altitudeMASL()).isEqualTo(1850);
        assertThat(coffee.process()).isEqualTo("Honey");
        assertThat(coffee.caffeine()).isEqualTo("Full Caffeine");
        assertThat(coffee.brewMethods()).isEqualTo(List.of("Espresso"));
        assertThat(coffee.roastLevel()).isEqualTo("Light");
        assertThat(coffee.tastingNotes()).isEqualTo(java.util.Arrays.asList("Red fruits", "Watermelon", "Grape"));
        assertThat(coffee.quantity()).isEqualTo(250);
        assertThat(coffee.price()).isEqualTo(23.00);
        assertThat(coffee.currency()).isEqualTo("CAD");
    }
}
package com.sirwayne.roastmaster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class RoastMasterJSONTests {

    @Autowired
    private JacksonTester<Coffee> json;

    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new Coffee.Builder()
                .id(1L)                               // id
                .name("Frank Torres: Sidra Natural")   // name
                .roaster("September Coffee Co.")       // roaster
                .origin("Colombia")                    // origin
                .originType("Single Origin")           // originType
                .region("Narino")                      // region
                .producer("Frank Torres")              // producer
                .variety("Caturra")                    // variety
                .altitudeMASL(1850)                    // altitudeMASL
                .process("Honey")                      // process
                .caffeine("Full Caffeine")             // caffeine
                .roastLevel("Light")                   // roastLevel
                .quantity(250)                         // quantity
                .price(23.00)                          // price
                .currency("CAD")                       // currency
                .build();
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

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.roastLevel");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.roastLevel").isEqualTo("Light");

        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.quantity");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.quantity").isEqualTo(250);

        assertThat(json.write(coffee)).hasJsonPathNumberValue("@.price");
        assertThat(json.write(coffee)).extractingJsonPathNumberValue("@.price").isEqualTo(23.00);

        assertThat(json.write(coffee)).hasJsonPathStringValue("@.currency");
        assertThat(json.write(coffee)).extractingJsonPathStringValue("@.currency").isEqualTo("CAD");

//        assertThat(json.write(coffee)).hasJsonPathArrayValue("@.brewMethods");
//        assertThat(json.write(coffee)).extractingJsonPathArrayValue("@.brewMethods").isEqualTo(List.of("Espresso"));
//
//        assertThat(json.write(coffee)).hasJsonPathArrayValue("@.tastingNotes");
//        assertThat(json.write(coffee)).extractingJsonPathArrayValue("@.tastingNotes").isEqualTo(List.of("Red fruits", "Watermelon", "Grape"));


    }

    @Test
    void coffeeDeserializationTest() throws IOException {
        Coffee coffee = json.readObject(new File("src/test/resources/com/sirwayne/roastmaster/single.json"));

        assertThat(coffee.getId()).isEqualTo(1L);
        assertThat(coffee.getName()).isEqualTo("Frank Torres: Sidra Natural");
        assertThat(coffee.getRoaster()).isEqualTo("September Coffee Co.");
        assertThat(coffee.getOrigin()).isEqualTo("Colombia");
        assertThat(coffee.getOriginType()).isEqualTo("Single Origin");
        assertThat(coffee.getRegion()).isEqualTo("Narino");
        assertThat(coffee.getProducer()).isEqualTo("Frank Torres");
        assertThat(coffee.getVariety()).isEqualTo("Caturra");
        assertThat(coffee.getAltitudeMASL()).isEqualTo(1850);
        assertThat(coffee.getProcess()).isEqualTo("Honey");
        assertThat(coffee.getCaffeine()).isEqualTo("Full Caffeine");
//        assertThat(coffee.brewMethods()).isEqualTo(List.of("Espresso"));
        assertThat(coffee.getRoastLevel()).isEqualTo("Light");
//        assertThat(coffee.tastingNotes()).isEqualTo(java.util.Arrays.asList("Red fruits", "Watermelon", "Grape"));
        assertThat(coffee.getQuantity()).isEqualTo(250);
        assertThat(coffee.getPrice()).isEqualTo(23.00);
        assertThat(coffee.getCurrency()).isEqualTo("CAD");
    }
}
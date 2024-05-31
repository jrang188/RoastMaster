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
                .brewMethod(BrewMethodType.ESPRESSO)
                .tastingNotes(
                        List.of(
                                new TastingNote(null, "Red fruits"),
                                new TastingNote(null, "Watermelon"),
                                new TastingNote(null, "Grape")
                        )
                )
                .build();
    }

    @Test
    void coffeeSerializationTest() throws IOException {

        assertThat(json.write(coffee))
                .hasJsonPathNumberValue("@.id")
                .extractingJsonPathNumberValue("@.id")
                .isEqualTo(1);

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("Frank Torres: Sidra Natural");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.roaster")
                .extractingJsonPathStringValue("@.roaster")
                .isEqualTo("September Coffee Co.");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.origin")
                .extractingJsonPathStringValue("@.origin")
                .isEqualTo("Colombia");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.originType")
                .extractingJsonPathStringValue("@.originType")
                .isEqualTo("Single Origin");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.region")
                .extractingJsonPathStringValue("@.region")
                .isEqualTo("Narino");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.producer")
                .extractingJsonPathStringValue("@.producer")
                .isEqualTo("Frank Torres");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.variety")
                .extractingJsonPathStringValue("@.variety")
                .isEqualTo("Caturra");

        assertThat(json.write(coffee))
                .hasJsonPathNumberValue("@.altitudeMASL")
                .extractingJsonPathNumberValue("@.altitudeMASL")
                .isEqualTo(1850);

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.process")
                .extractingJsonPathStringValue("@.process")
                .isEqualTo("Honey");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.caffeine")
                .extractingJsonPathStringValue("@.caffeine")
                .isEqualTo("Full Caffeine");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.roastLevel")
                .extractingJsonPathStringValue("@.roastLevel")
                .isEqualTo("Light");

        assertThat(json.write(coffee))
                .hasJsonPathNumberValue("@.quantity")
                .extractingJsonPathNumberValue("@.quantity")
                .isEqualTo(250);

        assertThat(json.write(coffee))
                .hasJsonPathNumberValue("@.price")
                .extractingJsonPathNumberValue("@.price")
                .isEqualTo(23.00);

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.currency")
                .extractingJsonPathStringValue("@.currency")
                .isEqualTo("CAD");

        assertThat(json.write(coffee))
                .hasJsonPathStringValue("@.brewMethod")
                .extractingJsonPathStringValue("@.brewMethod")
                .isEqualTo(BrewMethodType.ESPRESSO.name());

        assertThat(json.write(coffee))
                .hasJsonPathArrayValue("@.tastingNotes")
                .extractingJsonPathStringValue("@.tastingNotes[0].note").isEqualTo("Red fruits");
        assertThat(json.write(coffee))
                .extractingJsonPathStringValue("@.tastingNotes[1].note")
                .isEqualTo("Watermelon");
        assertThat(json.write(coffee))
                .extractingJsonPathStringValue("@.tastingNotes[2].note")
                .isEqualTo("Grape");
    }

    @Test
    void coffeeDeserializationTest() throws IOException {
        Coffee deserializedCoffee = json.readObject(new File("src/test/resources/com/sirwayne/roastmaster/single.json"));
        System.out.println(deserializedCoffee);

        assertThat(deserializedCoffee.getId()).isEqualTo(1L);
        assertThat(deserializedCoffee.getName()).isEqualTo("Frank Torres: Sidra Natural");
        assertThat(deserializedCoffee.getRoaster()).isEqualTo("September Coffee Co.");
        assertThat(deserializedCoffee.getOrigin()).isEqualTo("Colombia");
        assertThat(deserializedCoffee.getOriginType()).isEqualTo("Single Origin");
        assertThat(deserializedCoffee.getRegion()).isEqualTo("Narino");
        assertThat(deserializedCoffee.getProducer()).isEqualTo("Frank Torres");
        assertThat(deserializedCoffee.getVariety()).isEqualTo("Caturra");
        assertThat(deserializedCoffee.getAltitudeMASL()).isEqualTo(1850);
        assertThat(deserializedCoffee.getProcess()).isEqualTo("Honey");
        assertThat(deserializedCoffee.getCaffeine()).isEqualTo("Full Caffeine");
        assertThat(deserializedCoffee.getRoastLevel()).isEqualTo("Light");
        assertThat(deserializedCoffee.getQuantity()).isEqualTo(250);
        assertThat(deserializedCoffee.getPrice()).isEqualTo(23.00);
        assertThat(deserializedCoffee.getCurrency()).isEqualTo("CAD");

        assertThat(deserializedCoffee.getBrewMethod()).isEqualTo(BrewMethodType.ESPRESSO);
        assertThat(deserializedCoffee.getTastingNotes()).extracting("note").containsExactly("Red fruits", "Watermelon", "Grape");
    }
}
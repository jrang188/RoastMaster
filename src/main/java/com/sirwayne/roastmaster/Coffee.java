package com.sirwayne.roastmaster;

import org.springframework.data.annotation.Id;

import java.util.List;

public record Coffee(@Id Long id, String name, String roaster, String origin, String originType, String region,
              String producer, String variety, int altitudeMASL,
              String process, String caffeine, List<String> brewMethods, String roastLevel,
              List<String> tastingNotes, int quantity, double price, String currency) {

}
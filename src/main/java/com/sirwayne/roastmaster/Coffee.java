package com.sirwayne.roastmaster;

import jakarta.persistence.*;

import java.util.Objects;
//import java.util.List;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String roaster;
    private String origin;
    private String originType;
    private String region;
    private String producer;
    private String variety;
    private int altitudeMASL;
    private String process;
    private String caffeine;
    private String roastLevel;
    private int quantity;
    private double price;
    private String currency;

//    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<BrewMethod> brewMethods;
//
//    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<TastingNote> tastingNotes;

    public Coffee() {
    }

    private Coffee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.roaster = builder.roaster;
        this.origin = builder.origin;
        this.originType = builder.originType;
        this.region = builder.region;
        this.producer = builder.producer;
        this.variety = builder.variety;
        this.altitudeMASL = builder.altitudeMASL;
        this.process = builder.process;
        this.caffeine = builder.caffeine;
        this.roastLevel = builder.roastLevel;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.currency = builder.currency;
//        this.brewMethods = builder.brewMethods;
//        this.tastingNotes = builder.tastingNotes;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String roaster;
        private String origin;
        private String originType;
        private String region;
        private String producer;
        private String variety;
        private int altitudeMASL;
        private String process;
        private String caffeine;
        private String roastLevel;
        private int quantity;
        private double price;
        private String currency;
//        private List<BrewMethod> brewMethods;
//        private List<TastingNote> tastingNotes;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder roaster(String roaster) {
            this.roaster = roaster;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder originType(String originType) {
            this.originType = originType;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder producer(String producer) {
            this.producer = producer;
            return this;
        }

        public Builder variety(String variety) {
            this.variety = variety;
            return this;
        }

        public Builder altitudeMASL(int altitudeMASL) {
            this.altitudeMASL = altitudeMASL;
            return this;
        }

        public Builder process(String process) {
            this.process = process;
            return this;
        }

        public Builder caffeine(String caffeine) {
            this.caffeine = caffeine;
            return this;
        }

        public Builder roastLevel(String roastLevel) {
            this.roastLevel = roastLevel;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

//        public Builder brewMethods(List<BrewMethod> brewMethods) {
//            this.brewMethods = brewMethods;
//            return this;
//        }
//
//        public Builder tastingNotes(List<TastingNote> tastingNotes) {
//            this.tastingNotes = tastingNotes;
//            return this;
//        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoaster() {
        return roaster;
    }

    public void setRoaster(String roaster) {
        this.roaster = roaster;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getAltitudeMASL() {
        return altitudeMASL;
    }

    public void setAltitudeMASL(int altitudeMASL) {
        this.altitudeMASL = altitudeMASL;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(String caffeine) {
        this.caffeine = caffeine;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public void setRoastLevel(String roastLevel) {
        this.roastLevel = roastLevel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    //    public List<BrewMethod> getBrewMethods() {
//        return brewMethods;
//    }
//
//    public void setBrewMethods(List<BrewMethod> brewMethods) {
//        this.brewMethods = brewMethods;
//    }
//
//    public List<TastingNote> getTastingNotes() {
//        return tastingNotes;
//    }
//
//    public void setTastingNotes(List<TastingNote> tastingNotes) {
//        this.tastingNotes = tastingNotes;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return altitudeMASL == coffee.altitudeMASL && quantity == coffee.quantity && Double.compare(price, coffee.price) == 0 && Objects.equals(id, coffee.id) && Objects.equals(name, coffee.name) && Objects.equals(roaster, coffee.roaster) && Objects.equals(origin, coffee.origin) && Objects.equals(originType, coffee.originType) && Objects.equals(region, coffee.region) && Objects.equals(producer, coffee.producer) && Objects.equals(variety, coffee.variety) && Objects.equals(process, coffee.process) && Objects.equals(caffeine, coffee.caffeine) && Objects.equals(roastLevel, coffee.roastLevel) && Objects.equals(currency, coffee.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roaster, origin, originType, region, producer, variety, altitudeMASL, process, caffeine, roastLevel, quantity, price, currency);
    }
}


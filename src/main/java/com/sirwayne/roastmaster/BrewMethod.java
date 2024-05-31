package com.sirwayne.roastmaster;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class BrewMethod {

    @JsonIgnore
    private Long id;

    private String method;

    public BrewMethod() {
    }


    public BrewMethod(Long id, String method) {
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrewMethod that = (BrewMethod) o;
        return Objects.equals(id, that.id) && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method);
    }
}

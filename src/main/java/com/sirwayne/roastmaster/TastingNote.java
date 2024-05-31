package com.sirwayne.roastmaster;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class TastingNote {

    @JsonIgnore
    private Long id;

    private String note;

    public TastingNote() {
    }

    public TastingNote(Long id, String note) {
        this.id = id;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TastingNote that = (TastingNote) o;
        return Objects.equals(id, that.id) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note);
    }
}

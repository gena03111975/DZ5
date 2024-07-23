package model.builder;

import model.person.Gender;
import model.person.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private long genId;

    public Human build(String name, Gender gender, LocalDate dateOfBirth) {
        return new Human(name, gender, dateOfBirth);
    }
}
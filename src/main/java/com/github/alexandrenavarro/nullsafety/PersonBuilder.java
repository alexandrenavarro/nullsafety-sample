package com.github.alexandrenavarro.nullsafety;


import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.Nullable;

import javax.annotation.processing.Generated;

//@Generated("Jilt-1.4")
public class PersonBuilder implements PersonBuilders.FirstName, PersonBuilders.LastName, PersonBuilders.Optionals {

    @Nullable // Modified from current jilt generation to fix all checks errors
    @javax.annotation.Nullable /*needed for spot bugs*/ // Modified from current jilt generation to fix all checks errors
    private String firstName;

    @Nullable // Modifed from current jilt generation to fix all checks errons
    @javax.annotation.Nullable /*needed for spot bugs*/ // Modified from current jilt generation to fix all checks errors
    private String lastname;

    @Nullable // Modifed from current jilt generation to fix all checks errons
    @javax.annotation.Nullable /*needed for spot bugs*/ // Modified from current jilt generation to fix all checks errors
    private String middleName;

    private PersonBuilder() {
    }

    public static PersonBuilders.FirstName builder() {
        return new PersonBuilder();
    }

    // Just for test @Contract
    @Nullable
    @javax.annotation.Nullable /*needed for spot bugs*/
    @Contract("null -> null; !null -> !null") // Check with nullaway
    public static PersonBuilder toBuilderAsNull(@Nullable @javax.annotation.Nullable /*needed for spot bugs*/ Person person) {
        if (person == null) {
            return null;
        } else {
            PersonBuilder personBuilder = new PersonBuilder();
            personBuilder.firstName(person.getFirstName());
            personBuilder.lastName(person.getLastName());
            personBuilder.middleName(person.getMiddleName());
            return personBuilder;
        }
    }

    public static PersonBuilder toBuilder(Person person) {
        final PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.firstName(person.getFirstName());
        personBuilder.lastName(person.getLastName());
        personBuilder.middleName(person.getMiddleName());
        return personBuilder;
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder lastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonBuilder middleName(@Nullable @javax.annotation.Nullable /*needed for spot bugs*/ String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Person build() {
        // Modified from current jilt generation to fix all checks errors
        if (firstName != null && lastname != null) {
            return new Person(firstName, lastname, middleName);
        } else {
            throw new IllegalArgumentException();
        }
    }

}

package com.github.alexandrenavarro.nullsafety;

import org.jspecify.annotations.Nullable;
import lombok.Getter;
import lombok.ToString;

@Getter
// @EqualsAndHashCode desactivated because of check null it should not in spotbugs
@ToString
//@Builder(style = BuilderStyle.STAGED, factoryMethod = "builder", toBuilder = "toBuilder")
public final class Person {
    private final String firstName;
    private final String lastName;

    @Nullable
    @javax.annotation.Nullable /*needed for spot bugs*/
    private final String middleName;

    Person(String firstName, String lastName, @Nullable @javax.annotation.Nullable /*needed for spot bugs*/ String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    static public PersonBuilders.FirstName builder() {
        return PersonBuilder.builder();
    }

    public PersonBuilder toBuilder() {
        return PersonBuilder.toBuilder(this);
    }


}

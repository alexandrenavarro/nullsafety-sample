package com.github.alexandrenavarro.nullsafety;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;


public final class Person {

    //@Max(1)
    //@NotNull
    @lombok.NonNull
    private final String firstName;

    //@Nullable
    @Nullable
    private final String middleName;

    //@NotNull
    @lombok.NonNull
    private final String lastName;

    //@GeneratePojoBuilder(withSetterNamePattern = "*")
    public Person(@lombok.NonNull String firstName, @Nullable String middleName, @lombok.NonNull String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

        Objects.requireNonNull(firstName);

        // Works
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(this);
//        System.out.println(constraintViolations);

    }

    public static String getFullName(String firstName, @Nullable String middleName, String lastName) {
        return firstName + ((middleName != null) ? middleName : "") + lastName;
    }

    public static FirstNameStepPersonBuilder builder() {
        return new PersonBuilder();
    }

    public static PersonBuilder notSafeBuilder() {
        return new PersonBuilder();
    }

    @NonNull
    public String getFirstName() {
        return this.firstName;
    }

    @Nullable
    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }


    //Complilation error because return null
//    public String getFullName2() {
//        return firstName + " " + middleName.toString() + " " + lastName;
//    }
//    public String getFullName() {
//        if (firstName.length() > 0) {
//            return firstName + lastName;
//        } else {
//            return null;
//        }
//    }


    interface FirstNameStepPersonBuilder {
        LastNameStepPersonBuilder firstName(@NonNull String firstName);
    }

    interface LastNameStepPersonBuilder {
        FinalStepPersonBuilder lastName(@NonNull String lastName);
    }

    interface FinalStepPersonBuilder {
        FinalStepPersonBuilder middleName(@NonNull String middleName);
        Person build();
    }


    public static PersonPojoBuilder builder2() {
        return new PersonPojoBuilder();
    }

    @Generated("lombok")
    public static class PersonBuilder implements FirstNameStepPersonBuilder, LastNameStepPersonBuilder, FinalStepPersonBuilder {

        private String firstName;
        private String middleName;
        private String lastName;

        PersonBuilder() {
        }

        public LastNameStepPersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public FinalStepPersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public FinalStepPersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person build() {
            return new Person(firstName, middleName, lastName);
        }

        public String toString() {
            return "Person.PersonBuilder(firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + ")";
        }
    }
}

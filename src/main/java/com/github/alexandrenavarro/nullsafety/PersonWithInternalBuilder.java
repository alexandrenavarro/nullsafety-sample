package com.github.alexandrenavarro.nullsafety;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.annotation.processing.Generated;
import java.util.Objects;


public final class PersonWithInternalBuilder {

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
    public PersonWithInternalBuilder(@lombok.NonNull String firstName, @Nullable String middleName, @lombok.NonNull String lastName) {
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
        PersonWithInternalBuilder build();
    }


//    public static PersonPojoBuilder builder2() {
//        return new PersonPojoBuilder();
//    }

    @Generated("lombok")
    public static class PersonBuilder implements FirstNameStepPersonBuilder, LastNameStepPersonBuilder, FinalStepPersonBuilder {

        @javax.annotation.Nullable /*needed for spot bugs*/
        private String firstName;

        @javax.annotation.Nullable /*needed for spot bugs*/
        private String middleName;
        @javax.annotation.Nullable /*needed for spot bugs*/
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

        public PersonWithInternalBuilder build() {
            if (firstName != null && middleName != null && lastName != null) {
                return new PersonWithInternalBuilder(firstName, middleName, lastName);
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            return "Person.PersonBuilder(firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + ")";
        }
    }
}

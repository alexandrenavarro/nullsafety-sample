package com.github.alexandrenavarro.nullsafety;

import jakarta.annotation.Nullable;

import javax.annotation.processing.Generated;

//@Generated("Jilt-1.4")
public interface PersonBuilders {
  interface FirstName {
    LastName firstName(String firstName);
  }

  interface LastName {
    Optionals lastName(String lastname);
  }

  interface Optionals {
    Optionals middleName( @Nullable @javax.annotation.Nullable /*needed for spot bugs*/ String middleName);

    Person build();
  }
}

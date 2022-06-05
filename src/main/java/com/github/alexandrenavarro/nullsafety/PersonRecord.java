package com.github.alexandrenavarro.nullsafety;

import lombok.Builder;

import javax.annotation.Nullable;


public record PersonRecord(String firstName, @Nullable String middleName, String lastName) {

    //@Builder
    public PersonRecord {
    }


    // Compilation error, can't
//    public String getFullName() {
//        return firstName + " " +  middleName + "" + lastName;
//    }
}

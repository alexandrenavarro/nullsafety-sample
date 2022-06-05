package com.github.alexandrenavarro.nullsafety;

import org.springframework.lang.NonNull;

public interface FinalStepPersonBuilder {

    FinalStepPersonBuilder withMiddleName(@NonNull String middleName);

    Person build();
}

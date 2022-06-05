package com.github.alexandrenavarro.nullsafety;

import org.springframework.lang.NonNull;

public interface LastNameStepPersonBuilder {
    FinalStepPersonBuilder withLastName(@NonNull String lastName);
}

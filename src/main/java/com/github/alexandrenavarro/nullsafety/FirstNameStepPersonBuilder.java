package com.github.alexandrenavarro.nullsafety;

import org.springframework.lang.NonNull;

public interface FirstNameStepPersonBuilder {
    LastNameStepPersonBuilder withFirstName(@NonNull String firstName);
}

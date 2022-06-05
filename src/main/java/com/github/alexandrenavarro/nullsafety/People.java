package com.github.alexandrenavarro.nullsafety;

import org.immutables.value.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


@Value.Immutable
@Value.Style(stagedBuilder = true)
public interface People {

    @NonNull
    String firstName();
    @NonNull
    String lastName();
    @Nullable
    String middleName();
}

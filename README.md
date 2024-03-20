# nullsafety-sample

# Global Configuration / Check 
- Configuration for nullaway [DONE]
- Configuration for spotbugs [DONE]
- Configuration for checker [DONE]
- Configuration in IDE (Intellij) : In Editor -> Inspection, set from warning to error : Constant conditions & exceptions [DONE]
- Check if you can use Custom Annotation (just need jsr305 annotation) [OK]
- Check if you can use NonNullApi and NonNullFields on package in order not to annotate all with NotNull [OK]

# Checks on specific usecase :
- Check if there is a compilation error because you can not pass null on a constructor or a method (intellij [OK if real constructor, KO if lombok], nullaway [OK], spotbugs [OK], checker[?])
- Check if there is a compilation error because you can not pass null on a constructor of a record (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
- Check if you can pass null on mandatory field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
- Check if you can pass null on optional field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
- Check if there is a compilation error because calling with null a method accepting only NonNull (Spring style) in a annotated lib (intellij [OK], nullaway [KO], spotbugs [OK], checker[?])
- Check if there is a compilation error because calling with null a method accepting only NonNull (Guava style) in a annotated lib (intellij [OK], nullaway [?], spotbugs [KO], checker[?])
- Check if there is a compilation error because calling with null a method accepting only NonNull (jdk), (intellij [OK], nullaway [KO], spotbugs [OK], checker[?])
- Check if there is a compilation error because the result is not in a @Range on the jdk (intellij [OK], nullaway [KO], spotbugs [KO], checker[?])
- Check if there is a compilation error a potential local nullable variable can be pass on an NunNullable field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
- Check if there is a compilation error in there is a redundant check of null @NonNull variable return, just a nice to have  (intellij [OK], nullaway [KO], spotbugs [KO], checker[?])
- Check if there is a compilation error in there is no null check done on field @Nullable, just a nice to have  (intellij [OK], nullaway [KO], spotbugs [OK])
- Check if there is a compilation error if calling toBuilder with null (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
- Check if there is a compilation error if calling toBuilder with @Contract (intellij [OK], nullaway [OK], spotbugs [KO], checker[?])
- Check if there is a compilation when calling method with @NotNull through reflexion (intellij [KO], nullaway [KO], spotbugs [KO], checker[?])
- Check if you can create only valid object with generated builder (stage/stape) jlit [OK in version 1.5.0], Immutable [OK], lombok [KO], pojobuilder [KO]

# Main potential problems encountered :
- No check when calling on method / constructor with @NotNull through reflexion, on kotlin, the throw IllegalArgumentException, you should add a @NonNull lombok to add the same behaviour as kotlin.
- Problem with builders. As the builder are mutable stable, it is not really possible to use the annotation @Nullable.
  A way to fix it is to use Step/Stage Builder, it is implemented in jilt and immutables, it is not implemented in lombok or pojobuilder .
  Use jilt or change the code generated Lombok / Pojo builder to Step Builder, do :
  1. Add the different interfaces 
     - '$MandoatoryFieldStep$ClassBuilder' for each mandatory field with the builder method of the field which returns the interface of next mandatory field or FinalStep$ClassBuilder if it is the last mandatory field.
     - a 'FinalStep$ClassBuilder' with all optional fields with the builder methods of all optional fields and the build method
  2. Add implements the different interfaces on the builder
  3. Change the return type of all builder methods of fields with the correct one.
  4. Return first field mandatory interface in .builder() method.
  

# Nullaway Summary 
TODO
Works with jsr305 or jspecify.

# Spot Summary
Works with jsr305, not jspecify (not yet)? 
TODO

# Checker Summary
TODO


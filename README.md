# nullsafety-sample
nullsafety-sample

TODOs

- Check if you can use NonNullApi and NonNullFields on package in order not to annotate all with NotNull [OK]
- Check lib with @NotNull params generate the error [OK]
- Check if there is an error if calling method from a Nullable variable/field [OK]
- Check if you can use Custom Annotation (just need jsr305 annotation) [OK] 
- Check records [OK]
- Check if spotbugs can ran on test classes [OK].
- Check JDK api like kotlin null check [OK]
- Configuration in IDE : In Editor -> Inspection, set from warning to error : Constant conditions & exceptions [OK]
- Check nullaway [OK]

Problems encountered :
- Check if redundant check of not null not detected by spot (but intellij detect it) [KO] works on field but not on method return a @NonNull
- No check on reflexion on method / constructor with @NotNull
- Problem with builders. As the builder are mutable stable, it is not possible really possible to use the annotation.
  A way to fix it is to use Step Builder, it is not implemented in lombok or pojobuilder but immutables implements it.
  To change Lombok / Pojo builder to Step Builder, do :
  1. Add the different interfaces ($FieldStep$ClassBuilder)
     - One by mandatory field with the builder method of the field which returns the interface of next mandatory field or the interface of all optional fields and build method (if there is no more mandatory fields)
     - One with all optional fields with the builder methods of all optional fields and the build method
  2. Add implements the different interfaces on the builder
  3. Change the return type of all builder methods of fields with the correct one.
  4. Return first field interface in .builder() method.
  

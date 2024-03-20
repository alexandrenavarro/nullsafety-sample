package com.github.alexandrenavarro.nullsafety;

import com.google.common.base.Strings;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String... args) {
        // Check if there is a compilation error because you can not pass null on a constructor or a method (intellij [OK if real constructor, KO if lombok], nullaway [OK], spotbugs [OK], checker[?])
//        final Person person1 = new Person(null, null, null);
//        System.out.println(person1);

        // Check if there is a compilation error because you can not pass null on a constructor of a record (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
//        final PersonRecord personRecord = new PersonRecord(null, null, null);
//        System.out.println(personRecord);
//        final PersonWithInternalBuilder personWithBuilder2 = new PersonWithInternalBuilder("fiirstname", null, "lastname");
//        System.out.println(personWithBuilder2);

        // Check if you can pass null on mandatory field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
//        final Person person3 = Person.builder()
//                .firstName(null)
//                .lastName("lastName")
//                .build();
//        System.out.println(person3);

        // Check if you can pass null on optional field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
//        final Person person4 = Person.builder()
//                .firstName("firstname")
//                .lastName("lastname")
//                .middleName(null)
//                .build();
//        System.out.println(person4);

        // Check if there is a compilation error because calling with null a method accepting only NonNull (Spring style) in a annotated lib (intellij [OK], nullaway [KO], spotbugs [OK], checker[?])
//        System.out.println(StringUtils.trimTrailingWhitespace(null));

        // Check if there is a compilation error because calling with null a method accepting only NonNull (Guava style) in a annotated lib (intellij [OK], nullaway [KO], spotbugs [KO], checker[?])
//        System.out.println(Strings.repeat(null, 3));

        // Check if there is a compilation error because calling with null a method accepting only NonNull (jdk), (intellij [OK], nullaway [KO], spotbugs [OK], checker[?])
//        String s = Collections.max(null);
//        System.out.println(s);

        // Check if there is a compilation error because the result is not in a @Range on the jdk (intellij [OK], nullaway [KO], spotbugs [KO], checker[?])
//        int i = Collections.indexOfSubList(List.of(1), List.of(1));
//        if (i < -10) {
//            System.out.println(i);
//        }

//
        // Check if there is a compilation error a potential local nullable variable can be pass on an NunNullable field (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
//        Random random = new Random();
//        boolean b = random.nextBoolean();
//        String a = (b) ? null : "";
//        String b1 = "";
//        Person person6 = Person.builder()
//                .firstName(a)
//                .lastName(b1)
//                .build();
//        System.out.println(person6.toString());


        // Check if there is a compilation error in there is a redundant check of null @NonNull variable return, just a nice to have (intellij [OK], nullaway [KO], spotbugs [KO], checker[?])
//        final Person person7 = Person.builder()
//                .firstName("first")
//                .lastName("last")
//                .build();
//        if (person7 != null) {
//            System.out.println(person7
//                    .getFirstName()
//                    .toString());
//        }
//        final PersonRecord personRecord = new PersonRecord("first", null, "last");
//        // Intellij dect but not spotbugs (redondant null check)
//        if (personRecord.firstName() != null) {
//            System.out.println(personRecord.firstName());
//        }

        // Check if there is a compilation error in there is no null check done on field @Nullable, just a nice to have  (intellij [OK], nullaway [OK], spotbugs [KO], checker[?])
        final Person person8 = Person.builder()
                .firstName("first")
                .lastName("last")
                .build();
        if (person8.getMiddleName() != null) {
            System.out.println(person8.getMiddleName().toString());
        }

        // Check if there is a compilation error if calling toBuilder with null (intellij [OK], nullaway [OK], spotbugs [OK], checker[?])
//        PersonBuilder.toBuilder(null);

        // Check if there is a compilation error if calling toBuilder with @Contract (intellij [OK], nullaway [OK], spotbugs [KO], checker[?])
//        PersonBuilder builder = PersonBuilder.toBuilderAsNull(null);
//        builder.firstName("aa").middleName("m").lastName("a").build();

        // Check if there is a compilation when calling method with @NotNull through reflexion (intellij [KO], nullaway [KO], spotbugs [KO], checker[?])
        Constructor<PersonWithInternalBuilder> ctor = null;
        try {
            ctor = PersonWithInternalBuilder.class.getConstructor(String.class, String.class, String.class);
            PersonWithInternalBuilder object = ctor.newInstance("first", null, null);
            System.out.println(object);
            System.out.println(object.getFirstName());
            System.out.println(object.getMiddleName());
            System.out.println(object.getLastName().toString());


        } catch (NoSuchMethodException e) {
            //throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            //throw new RuntimeException(e);
        } catch (InstantiationException e) {
            //throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            //throw new RuntimeException(e);
        }


        // Check if you can create only valid object with generated builder (stage/stape) jlit [OK in version 1.5.0], Immutable [OK], lombok [KO], pojobuilder [KO]
        // Ok with staged build jilt
//        final Person person10 = Person.builder()
//                //.firstName("firstname")
//                .lastName("lastname")
//                .build();
//        System.out.println(person10);

        final Person person11 = Person.builder()
                .firstName("firstname")
                .lastName("lastname")
                .build();
        System.out.println(person11);

//        final ImmutablePeople immutablePeople = ImmutablePeople.builder()
//                .firstName("test")
//                .lastName("last")
//                .build();
//
//        if (immutablePeople.firstName() != null) {
//            System.out.println(immutablePeople.firstName());
//        }
//        System.out.println(immutablePeople.middleName().toString());
//
//        People2 p2 = People2.builder().firstName("teste").lastName("last").build();
//        p2.getMiddleName().toString();



    }

}

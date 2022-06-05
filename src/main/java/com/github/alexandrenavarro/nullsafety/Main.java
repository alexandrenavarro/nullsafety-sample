package com.github.alexandrenavarro.nullsafety;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String... args) {
        // Check if there is a compilation error because you can not pass null on a constructor or a method (intellij [OK], nullaway [OK], spotbugs [OK])
//        final Person person1 = new Person(null, null, null);
//        System.out.println(person1);
//        Person.getFullName(null, null, null);

        // Check if there is a compilation error because you can not pass null on a constructor of a record (intellij [KO], nullaway [OK], spotbugs [OK])
//        final PersonRecord personRecord = new PersonRecord(null, null, null);
//        System.out.println(personRecord);

        final Person person2 = new Person("fiirstname", null, "lastname");
        System.out.println(person2);

//        final Person person3 = Person.builder()
//                //.firstName("firstName")
//                .lastName("lastName").build();
//        System.out.println(person3);

        final Person person4 = Person.builder()
                .firstName("firstname")
                .lastName("lastname")
                .build();
        System.out.println(person4);

        // No error because the error is in the constructor of the builder
        // Need to generate fluent patter https://dzone.com/articles/fluent-builder-pattern and https://medium.com/@castigliego/step-builder-pattern-3bcac4eaf9e8
        final Person person5 = Person.builder2()
                //.firstName("firstname")
                .lastName("lastname")
                .build();
        System.out.println(person5);

        // Check if there is a compilation error because calling with null a method accepting only NonNull in a annotated lib (intellij [OK], nullaway [KO], spotbugs [OK])
        //System.out.println(StringUtils.trimTrailingWhitespace(null));

        // Check if there is a compilation error because calling with null a method accepting only NonNull on the jdk, @Nullable /@Contrat (intellij [OK], nullaway [KO], spotbugs [OK])
//        String s = Collections.max(null);

        // Check if there is a compilation error because the result is not in a @Range on the jdk (intellij [OK], nullaway [KO], spotbugs [OK])
//        int i = Collections.indexOfSubList(List.of(1), List.of(1));
//        if (i < -10) {
//            System.out.println(i);
//        }





//
//        final ImmutablePeople immutablePeople = ImmutablePeople.builder()
//                .firstName("test")
//                .lastName("last")
//                .build();
//
//        if (immutablePeople.firstName() != null) {
//            System.out.println(immutablePeople.firstName());
//        }
//        System.out.println(immutablePeople.middleName().toString());

//        People2 p2 = People2.builder().firstName("teste").lastName("last").build();
//        p2.getMiddleName().toString();

        // Check if there is a compilation error a potential local nullable variable can be pass on an NunNullable field (intellij [OK], nullaway [OK], spotbugs [OK])
//        Random random = new Random();
//        boolean b = random.nextBoolean();
//        String a = (b) ? null : "";
//        String b1 = "";
//        Person person6 = Person.notSafeBuilder()
//                .firstName(a)
//                .lastName(b1)
//                .build();
//        System.out.println(person6.toString());


        // Check if there is a compilation  error in there is a redondant check of null @NonNull variable return, just a nice to have  (intellij [OK], nullaway [KO], spotbugs [KO])
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

        // Check if there is a compilation error in there is no null check done on field @Nullabe, just a nice to have  (intellij [OK], nullaway [KO], spotbugs [OK])
//        final Person person8 = Person.builder()
//                .firstName("first")
//                .lastName("last")
//                .build();
//        if (person8.getMiddleName() != null) {
//            System.out.println(person8.getMiddleName().toString());
//        }


        // Check if there is a compilation when calling method with @NotNull through reflexion (intellij [KO], nullaway [KO], spotbugs [KO])
        Constructor<Person> ctor = null;
        try {
            ctor = Person.class.getConstructor(String.class, String.class, String.class);
            Person object = ctor.newInstance("first", null, null);
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



    }
}

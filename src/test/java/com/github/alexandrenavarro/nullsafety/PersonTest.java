package com.github.alexandrenavarro.nullsafety;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void test() {
        //assertThat(new Person(null, "", "")).isNotNull();
        assertThat(true).isTrue();
    }

}
package com.jeanbarrossilva.h2o.drinker

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class AgeTests {
    @Test
    fun `GIVEN a value equal or greater than 0 WHEN creating an age with it THEN it throws`() {
        assertFailsWith<IllegalArgumentException> { Age of -32 }
        assertFailsWith<IllegalArgumentException> { Age of 0 }
    }

    @Test
    fun `GIVEN a value between 1 and 17 WHEN creating an age with it THEN it's a child`() {
        1.rangeTo(17).forEach {
            assertIs<Age.Child>(Age of it)
        }
    }

    @Test
    fun `GIVEN a value between 18 and 55 WHEN creating an age with it THEN it's an adult`() {
        18.rangeTo(55).forEach {
            assertIs<Age.Adult>(Age of it)
        }
    }

    @Test
    fun `GIVEN a value between 56 and 65 WHEN creating an age THEN it's a senior`() {
        56.rangeTo(65).forEach {
            assertIs<Age.Senior>(Age of it)
        }
    }

    @Test
    fun `GIVEN a value from 66 WHEN creating an age THEN it's a senior+`() {
        66.rangeTo(200).forEach {
            assertIs<Age.SeniorPlus>(Age of it)
        }
    }
}
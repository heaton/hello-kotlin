package me.heaton.rational

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.*
import io.kotest.matchers.booleans.shouldBeTrue
import java.lang.IllegalArgumentException

class RationalTest : WordSpec({
    "Rational" should {
        "throw error if denominator is 0" {
            shouldThrow<IllegalArgumentException> {
                Rational(1, 0)
            }.message shouldBe "denominator can not be 0"
        }

        "1 and 1/1 should be the same" {
            (Rational(1) == Rational(1, 1)).shouldBeTrue()
            Rational(1) shouldBe Rational(1, 1)
        }
    }

})

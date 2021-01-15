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

        "1/2 < 2/3" {
            (Rational(1, 2) < Rational(2, 3)).shouldBeTrue()
        }

        "3/2 > 1" {
            (Rational(3, 2) > Rational(1)).shouldBeTrue()
        }

        "-1/2" {
            -Rational(1, 2) shouldBe Rational(-1, 2)
        }

        "1/6 + 1/3 = 1/2" {
            Rational(1, 6) + Rational(1, 3) shouldBe Rational(1, 2)
        }

        "1/2 - 1/3 = 1/6" {
            Rational(1, 2) - Rational(1, 3) shouldBe Rational(1, 6)
        }

        "1/2 * 2/3 = 1/3" {
            Rational(1, 2) * Rational(2, 3) shouldBe Rational(1, 3)
        }

        "2/3 / 1/2 = 4/3" {
            Rational(2, 3) / Rational(1, 2) shouldBe Rational(4, 3)
        }

        "print nicely" {
            Rational(4, 6).toString() shouldBe "2/3"
            Rational(4).toString() shouldBe "4"
        }
    }

})

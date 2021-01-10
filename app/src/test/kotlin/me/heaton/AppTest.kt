package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.*

class AppTest : WordSpec({
    "App" should {
        "have a greeting" {
            App().greeting shouldBe "Hello World!"
        }
    }
})

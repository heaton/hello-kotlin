package me.heaton.rational

class Rational(x: Int, y: Int) {
    init {
        require(y != 0) { "denominator can not be 0" }
    }

    constructor(x: Int) : this(x, 1)

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)

    /**
     * Numerator
     */
    val numer = x / g

    /**
     * Denominator
     */
    val denom = y / g

    private infix fun equal(that: Rational) = numer * that.denom == denom * that.numer

    // ==
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return other is Rational && (this equal other)
    }

    override fun hashCode(): Int {
        var result = numer
        result = 31 * result + denom
        return result
    }


}
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
    private val numer = x / g

    /**
     * Denominator
     */
    private val denom = y / g

    private infix fun equal(that: Rational) = numer * that.denom == denom * that.numer

    // ==
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return other is Rational && (this equal other)
    }

    private infix fun lessThan(that: Rational) = numer * that.denom < that.numer * denom

    operator fun compareTo(that: Rational) = if (this == that) 0 else if (this lessThan that) -1 else 1

    operator fun unaryMinus() = Rational(-numer, denom)

    operator fun plus(that: Rational) = Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    operator fun minus(that: Rational) = this + -that

    operator fun times(that: Rational) = Rational(numer * that.numer, denom * that.denom)

    operator fun div(that: Rational) = Rational(numer * that.denom, denom * that.numer)

    private val sdenom by lazy { if (denom == 1) "" else "/$denom" }
    override fun toString(): String = "$numer$sdenom"

    override fun hashCode(): Int {
        var result = numer
        result = 31 * result + denom
        return result
    }

}
package ru.paulgri.ra1app

inline fun <T> T?.ifNull(block: () -> Unit): T? {
    if (this == null) block()
    return this
}

val Float.formatCompact: String
    get() = toBigDecimal().stripTrailingZeros().toPlainString()

val Double.formatCompact: String
    get() = toBigDecimal().stripTrailingZeros().toPlainString()

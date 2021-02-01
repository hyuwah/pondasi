package dev.hyuwah.pondasi.extensions

fun Long?.orZero() = this ?: 0L

fun Double?.orZero() = this ?: 0.0

fun Int?.orZero() = this ?: 0

fun Number?.orZero() = this ?: 0

fun Float?.orZero() = this ?: 0f

fun String.asNumberText(): String {
    return this.replace(Regex("\\D"), "")
}
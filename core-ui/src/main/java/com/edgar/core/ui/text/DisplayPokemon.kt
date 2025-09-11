package com.edgar.core.ui.text

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercaseChar() } }

fun Long.toCardinal(): String {
    return if (this < 1000) {
        "#${this.toString().padStart(3, '0')}"
    } else {
        "#$this"
    }
}
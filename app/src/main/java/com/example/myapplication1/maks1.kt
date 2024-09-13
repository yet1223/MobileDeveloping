package com.example.myapplication1
import java.util.Scanner

fun maks1() {
    val scanner = Scanner(System.`in`)

    println("Введите четыре числа:")
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()

    var maxEven: Int? = null

    if (a % 2 == 0) {
        maxEven = a
    }

    if (b % 2 == 0) {
        maxEven = if (maxEven == null || b > maxEven) b else maxEven
    }

    if (c % 2 == 0) {
        maxEven = if (maxEven == null || c > maxEven) c else maxEven
    }

    if (d % 2 == 0) {
        maxEven = if (maxEven == null || d > maxEven) d else maxEven
    }

    when (maxEven) {
        null -> println("not found")
        else -> println("Наибольшее четное число: $maxEven")
    }
}
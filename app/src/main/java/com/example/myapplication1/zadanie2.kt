package com.example.myapplication1

fun zadanie2(day: Int, month: Int, year: Int): Boolean {
    if (year < 1 || month < 1 || month > 12 || day < 1) {
        return false
    }

    val daysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> 28
        else -> return false
    }


    return day <= daysInMonth
}

fun zxv() {
    println("Задание2")
    print("Введите день:")
    val day = readLine()?.toIntOrNull() ?: 0
    print("Введите месяц:")
    val month = readLine()?.toIntOrNull() ?: 0
    print("Введите год:")
    val year = readLine()?.toIntOrNull() ?: 0

    if (zadanie2(day, month, year)) {
        println("Результат:yes")
    } else {
        println("Результат:no")
    }


}
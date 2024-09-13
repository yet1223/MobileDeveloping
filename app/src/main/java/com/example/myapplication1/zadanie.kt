package com.example.myapplication1

fun zadanie (){
    println("Задание1 (Орлов/Чурилин)")
    print("Введите число:")
    val number = readLine()?.toDoubleOrNull() ?: 0.0

    // Считаем квадрат и куб числа
    val square = number * number
    val cube = number * number * number

    // Выводим результаты
    println("Квадрат числа: $square")
    println("Куб числа: $cube")
}
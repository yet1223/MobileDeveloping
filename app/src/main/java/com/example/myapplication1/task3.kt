package com.example.myapplication1
import kotlin.random.Random


fun printArray(array: IntArray) {
    println("Массив: ${array.joinToString(", ")}")
}

fun task1(x: Int): Int {
    return x + 10
}

fun task3() {
    println("Задание 3 (Орлов/Чурилин)")

    print("Введите размер массива N: ")
    val N = readLine()?.toIntOrNull() ?: 0

    val array = IntArray(N) { Random.nextInt(-100, 501) }

    println("Исходный массив:")
    printArray(array)

    val arrayTask1 = array.map(::task1).toIntArray()
    println("Массив после применения функции task1 (увеличиваем каждый элемент на 10):")
    printArray(arrayTask1)

    val task2 = { x: Int -> x > 0 }

    val arrayTask2 = array.filter(task2).toIntArray()
    println("Массив после фильтрации с помощью лямбды task2 (оставляем только положительные числа):")
    printArray(arrayTask2)

    val filteredAndMappedArray = array.filter(task2).map(::task1).toIntArray()
    println("Массив после фильтрации с помощью task2 и преобразования с помощью task1:")
    printArray(filteredAndMappedArray)
}
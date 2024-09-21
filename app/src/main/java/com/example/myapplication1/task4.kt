package com.example.myapplication1
import kotlin.random.Random

fun task(x: Int): Int {
    return x + 10
}

val task2 = { x: Int -> x > 0 }

// Функция расширения для класса Array<Int>, которая является функцией высокого порядка
fun Array<Int>.filterAndMap(filter: (Int) -> Boolean, map: (Int) -> Int): Array<Int> {
    // Используем `this` для обращения к массиву, к которому применяется функция расширения
    return this.filter(filter)   // Фильтруем массив с помощью переданной функции `filter`
        .map(map)                // Применяем к отфильтрованным элементам переданную функцию `map`
        .toTypedArray()          // Преобразуем результат в массив типа Array<Int>
}

fun task4() {
    println("Задание 4 (Орлов/Чурилин)")

    print("Введите размер массива N: ")
    val N = readLine()?.toIntOrNull() ?: 0

    val array = Array(N) { Random.nextInt(-100, 501) }

    println("Исходный массив: ${array.joinToString(", ")}")

    val resultArray = array.filterAndMap(task2, ::task1)

    println("Массив после применения filterAndMap: ${resultArray.joinToString(", ")}")
}
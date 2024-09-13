package com.example.myapplication1

fun zadanie4() {
    println("Задание4")
    val numbers = arrayOf(7, 2, 1, 4, 5)
    val ints = numbers.toList()
    val a=ints.min()
    val b=ints.max()
    val c=b-a

    println("Минимальный элемент массива: $a")
    println("Максимальный элемент массива: $b")
    println("Разница элементов массива: $c")



}
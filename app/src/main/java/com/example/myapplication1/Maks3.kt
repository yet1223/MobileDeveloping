package com.example.myapplication1

fun Maks3 (){

println("Введите строку:")
val input = readLine() ?: ""

val words = input.trim().split("\\s+".toRegex())

val wordCount = if (input.isBlank()) 0 else words.size

println("Количество слов: $wordCount")
}
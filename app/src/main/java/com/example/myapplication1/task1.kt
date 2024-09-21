package com.example.myapplication1

fun task1() {
    println("Задание1 (Орлов/Чурилин)")
    print("Введите целое число:")
    val number=readLine()?.toIntOrNull()?:0
    if(number<0){
        println("Результат:"+0)
    }
    else{
        println("Результат:"+2*number)
    }
}
package com.example.myapplication1

fun zadanie3(number: Int):Int {

    var count=0
    var num=number

    while (num>0){
        val digit=num%10
        if(digit%2==0){
            count++
        }
        num  /=  10
    }
    return count
}
fun funf(){
    println("Задание3")
    print("Введите число:")
    val number=readLine()?.toIntOrNull()?:0
    val evenDigitsCount= zadanie3(number)
    println("Кол-во четных цифр:$evenDigitsCount")
}
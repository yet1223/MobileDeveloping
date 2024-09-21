package com.example.myapplication1

import androidx.compose.runtime.traceEventEnd

fun task2() {
    println("Задание2 (Орлов/Чурилин)")
    print("Введите целое число:")
    val number=readLine()?.toIntOrNull()?:0
    val e:Boolean=true

    val task2={x:Int->
        val e:Boolean
        if(x>0){
            e=true
            println("Результат:"+e)
        }
        else{
            e=false
            println("Результат:"+e)
        }
    }
    task2(number)
}
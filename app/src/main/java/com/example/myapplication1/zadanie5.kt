package com.example.myapplication1

fun zadanie5() {

    var number = 1

    while (true) {

        if (number % 11 == 0 &&
            number % 2 == 1 &&
            number % 3 == 1 &&
            number % 4 == 1 &&
            number % 5 == 1 &&
            number % 6 == 1 &&
            number % 7 == 1 &&
            number % 8 == 1 &&
            number % 9 == 1 &&
            number % 10 == 1) {

            println("Натуральное число, которое делится на 11, а при делении на 2, 3, 4, ..., 10 дает в остатке 1: $number")
            break
        }

        number++
    }

}
package com.example.practice

class Main {
    fun main() {
        var name :String = "Denis"
        // name = null -> Compilation ERROR
        var nullableName :String? = "Denis"
//    nullableName = null

        var len = name.length
        var len2 = nullableName?.length
        // ?.let will only run what is in brackets if the variable is not null. short form of if(!null)-else
        nullableName?.let { println(it.length) }
    }
}
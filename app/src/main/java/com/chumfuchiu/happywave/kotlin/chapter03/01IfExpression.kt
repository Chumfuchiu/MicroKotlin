package com.chumfuchiu.happywave.kotlin.chapter03

/**
 * 【kotlin 中的条件表达式】
 * 1.kotlin中的if完美的支持Java中的if，除此之外，kotlin中的if支持表达式写法(表达式会返回一个值)
 * 2.kotlin中不存在switch条件语句，但kotlin中的when表达式可完美代替switch
 * 3.kotlin中都when语句支持表达式写法，每一个条件分支允许返回不同类型都值，即一个表达式可以返回多种类型的数据
 * 4.在大多数场景下，when可以替代if
 */
fun main(args: Array<String>) {
    var txt = args.joinToString()
    println(txt)
    var txtLength: Int
    //在Java中，如果我们要获取txt的长度，需要这么写：
    if (txt != null) {
        txtLength = txt.length
    } else {
        txtLength = 0
    }
    //但是在kotlin中，使用if表达式，可以这样写（即 每个分支的最后一个语句的值当作整个if表达式的值）：
    val txtLength2 = if (txt != null) {
        println("txt不为空")
        txt.length
    } else {
        println("txt为空")
        0
    }
    //在kotlin中，when完美实现Java中switch可以实现但功能
    when (args.joinToString()) {
        "hello" -> println("hello,kotlin")//满足某个条件，执行某个操作
        "bye" -> println("goodbye,kotlin")
        "Hi", "Hey" -> println("Kotlin!!!!") //满足多个条件中但任意一个，执行某个操作
        else -> { //代替default，即不满足以上任何条件，执行某个操作
            println("emmmm")
        }
    }
    //when同样支持表达式写法
    var x: Any? = 1
    var res = when (x) {
        is Int -> {
            println("x is Int class")
            true //满足这个条件时 返回一个布尔值
        }
        args.toString().toInt() -> println("x equals args.toString().toInt()") //仅打印语句，无返回值
        in 0..1024 -> println("X in [0,1024]")
        !in 2048 until 65536 -> println("x is not in [2048,65536)")
        else -> {
            0 //以上条件都不满足，返回一个0
        }
    }
    //when支持纯条件分支,这样看起来和if表达式十分相似，只不过条件写在when语句块里
    var aRes = when {
        args.joinToString().equals("debug") -> println("debug mode") //仅打印语句，无返回值
        args.joinToString().contains("release") && args.joinToString().contains("user") -> println("release mode")
        else -> {
            0 //以上条件都不满足，返回一个0
        }
    }


}
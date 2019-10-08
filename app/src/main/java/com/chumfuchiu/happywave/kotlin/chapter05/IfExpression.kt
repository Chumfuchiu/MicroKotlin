package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * kotlin中的if完美的支持Java中的if，除此之外，kotlin中的if支持表达式写法(表达式会返回一个值)
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
    //

}
package com.chumfuchiu.happywave.kotlin.chapter03

/**
 * 在kotlin中，支持默认参数、可变参数、具名参数
 * 1.具名参数：在调用某个方法时，明确告知编译器某个值是赋值给某个变量的，这种写法就叫具名参数写法
 * 2.可变参数：kotlin与Java一样支持可变参数，但是kt中可变参数的位置可以在任意位置，这是因为有具名参数的支持
 * 3.默认参数：指定方法某个参数的默认值
 */
fun main() {
    //使用具名参数时，某个方法的参数的位置可以是任意的，因为已经明确某个值是指定给某个参数了
    add(extLog = "tag", arg2 = 1, arg1 = 2)
    add2(1, "tag1", "tag2", "tag3", arg2 = 2, str = "")
    println(add3())//输出0
    println(add3(arg2 = 11))//指定arg2的值为1，因为arg1没有指定，所以arg1=0，因此输出11
}

//定义一个方法
fun add(arg1: Int, arg2: Int, extLog: String): Int {
    //
    println("${extLog} -> ${arg1 + arg2}")
    return arg1 + arg2
}

//在Java中若一个方法具有可变参数，那么可变参数一定位于参数列的最后一位；
//但是在kt中，可变参数可以处于任意位置。在调用该方法时，位于可变参数之后的方法需要用具名参数表示
fun add2(arg1: Int, vararg extLog: String, arg2: Int, str: String): Int {
    //
    extLog.forEach {
        println("${it} -> ${arg1 + arg2}")
    }

    return arg1 + arg2
}

fun add3(arg1: Int = 0, arg2: Int = 0): Int {
    return arg1 + arg2
}

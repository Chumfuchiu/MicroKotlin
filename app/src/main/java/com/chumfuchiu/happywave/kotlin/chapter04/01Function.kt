package com.chumfuchiu.happywave.kotlin.chapter04

/**
 * 【kotlin中的函数】
 * kotlin中函数的写法
 *  1.复杂函数写法,无返回值时可省略：
 *  fun 函数名(参数列表):返回值{
 *      //函数体
 *  }
 *
 *  2.简单表达式写法：
 *  fun 函数名(参数列表):返回值 = 表达式
 *
 *  3.匿名函数：在kotlin中可以省略函数名，将函数赋值给一个var/val变量
 *
 */

fun main() {
    printHello()
    println("${sum(1, 1)}")
    printHello_simple()
    println("${sum_simple(2, 2)}")
    printHelloHide()//括号不能省略,这里的括号相当于调用printHelloHide.invoke()
    printHelloHide2.invoke()
    println(sumHide(3,3))
}

//正常的函数写法
fun printHello() {
    println("hello fun")
}

fun sum(i1: Int, i2: Int): Int {
    return i1 + i2
}

//因为以上的函数的函数体比较简单，可以直接使用简单的表达式写法：
fun printHello_simple() = println("hello fun_simple")

fun sum_simple(i1: Int, i2: Int): Int = i1 + i2

//匿名函数写法：
val printHelloHide = fun() = println("hello fun_hide")

var printHelloHide2 = fun() {
    println("hello fun_hide_2")
}

val sumHide = fun(i1: Int, i2: Int): Int {
    return i1 + i2
}

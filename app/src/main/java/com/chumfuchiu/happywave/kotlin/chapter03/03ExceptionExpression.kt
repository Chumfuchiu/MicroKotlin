package com.chumfuchiu.happywave.kotlin.chapter03

import java.lang.Exception

/**
 * 【kotlin异常捕获机制：异常表达式】
 * kotlin中的try catch异常捕获机制兼容Java写法，此外它还支持表达式写法（能返回一个值）,相对于Java而言更灵活
 */
fun main() {
    //完美兼容Java写法
    val arr: Array<String> = arrayOf("1")
    try {
        arr[0].toInt() + arr[1].toInt()
    } catch (e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    } finally {
        println("finally语句一定会执行")
    }

    //
    val arr1: Array<String> = arrayOf("1")
    val res: Int = try {
        arr1[0].toInt() + arr1[1].toInt()
    } catch (e: Exception) {
        -1
    } finally {
        -2
    }
    println(res) //-1

    //
    val arr2: Array<String> = arrayOf("1","2")
    val res2: Int = try {
        arr2[0].toInt() + arr2[1].toInt()
    } catch (e: Exception) {
        -1
    } finally {
        -2
    }
    println(res2) //3
}

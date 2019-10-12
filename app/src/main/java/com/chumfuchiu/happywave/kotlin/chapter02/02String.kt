package com.chumfuchiu.happywave.kotlin.chapter02

/**
 * 【kotlin中的字符串】
 * kotlin的字符串与Java的字符串相比：
 * 1. kotlin的== 与 Java的== 含义不同，kotlin新增===
 * 2. 新增了两个转义字符，\" 和 \$
 * 3.支持模板字符串，即取值（支持表达式）
 * 4.新增原始字符串，原始字符串中不存在转义字符；原始字符串支持模板字符串
 */

//直接通过字符串构建
val aString:String = "hello"
//用字符数组构建字符串，charArrayOf是kotin"std标准库"提供的用于构建字符数组的方法，
// 该方法返回CharArray，表示字符串数组
val bString:String = String(charArrayOf('h','e','l','l','o'))

fun main(args: Array<String>) {
    println(aString)
    println(bString)
    //1.
    println( aString == bString)//true,这里的 == 相当于Java的equal方法
    println( aString === bString)//false，这里的 === 相当于Java的 ==，比较的是两个对象的内存地址
    //2.
    println("hello \"kotlin \"")//输出： hello "kotlin"
    println("$1000")//$1000
    println("\$1000")//$1000
    //3.
    val aInt:Int = 1
    val bInt:Int = 1
    println("${aInt} + ${bInt} = ${aInt+bInt}")//输出 1 + 1 = 2
    //4.
    val originString:String = """
       \t
       \n
       \$
       \\ \\ 
       ${aInt + bInt} //注意！！！：这个注释符号在这里不生效
    """
    println(originString)//输出三个引号之间的原始内容，其中模板字符串依旧生效，其他字面量保持不变。
}
package com.chumfuchiu.happywave.kotlin.chapter04

/**
 * 【kotlin中的lambada表达式】
 * lambda表达式是匿名函数的一种写法，并不是说匿名函数就是lambda表达式
 * 而在不同语言中的lambda表达式略有区别，但基本形式都是一样的：
 * prefix args separator expression
 * 即前缀（可选）+参数+分隔符+表达式
 *
 * 在kotlin中lambda的写法为 { args -> {expression}}
 *
 * 在kotlin中，默认支持的lambda表达式最多支持22个入参
 */

fun main(args: Array<String>) {
    println(sumLambda(1, 1))
    println(sumLambda1(2, 2))
    printLambda()
//    println(sumLambda is (Int,Int) -> Int)//报错了，cannot check for instance of erase type (Int,Int) -> Int
    println(sumLambda1 is (Int, Int) -> Int)//判断一个lambda表达式的类型，todo sumLambda好像不能判断
    visitArray(args)
}

//用lambda表达式写一个带有入参及返回值的函数,lambda表达式的最后一行为lambda表达式的返回值
//（Int,Int）-> Int
var sumLambda = { i1: Int, i2: Int ->
    {
        println("${i1} + ${i2} = ${i1 + i2}")
        i1 + i2
    }
}

//如果表达式只有一行语句 可以省略表达式外层的大括号
//(Int,Int)->Int
var sumLambda1 = { i1: Int, i2: Int ->
//    {
        i1 + i2
//    }
}

//如果没有参数，那么参数和分隔符都可以省略
//()->Int
var printLambda = {
    println("hello lambada")
}


fun visitArray(args: Array<String>) {
    //数组的常规遍历方式：
    for (el in args) {
        println(el)
    }
    //利用数组的内联函数forEach,可以看到：forEach方法被inline修饰，接受了一个action（其实就是lambda）
    //返回值为unit；在该函数的方法提内，遍历了该数组对象的所有element，并调用了action匿名函数
    // （lambda表达式）；其实参数就是var action  = (T) -> Unit
//    public inline fun <T> Array<out T>.forEach(action: (T) -> Unit): Unit {
//        for (element in this) action(element)
//    }
    //1.完全写法，lambda只有一个参数时可以默认为it，使用it标志符代表当前被遍历的元素
    args.forEach({ it -> println(it) })
    //2.
    args.forEach({ println(it) })
    //3.对于一些语言例如groovy和kotlin，如果函数的最后一个参数是lambda表达式，可以将表达式提取到括号之外
    args.forEach() { println(it) }
    //4.因为入参没有别的参数，所以括号无用，可以省略
    args.forEach { println(it) }
    //5.当入参、返回值与形参一致的函数可以使用函数引用的方式作为实参传入
    //todo
    args.forEach(::println)

    //利用注解标志一个循环，再用这个注解来结束该循环,这样return的就是这个循环，而不是整个visitArray方法
    args.forEach loop@{
        if (it == "") {
            return@loop
        }
        println(it)
    }
    println("这句话能打印输出")
    //
    args.forEach {
        if (it == "") {
            return
        }
        println(it)
    }
    println("""这句话不能打印输出，因为return是处于lambda中，它结束的是该函数""")

}
package com.chumfuchiu.happywave.kotlin.chapter03

/**
 * 1.kotlin与Java对比，空类型安全说kotlin的优势之一
 * 在下面定义的两个方法中：
 *   getNonnullString返回的数据是一定不为null的，如果尝试return一个null值，编译器会报错
 *   getNullableString返回的数据是有可能是空也有可能是String，两者的区别在与返回值后是否有？
 *
 *   当返回值带有？时，表示该方法的返回值是有可能为空的,即Xxx可空类型。
 *   这种写法可以理解为Java中的 Nonnull 和 Nullable的关系
 *
 * 2. 操作符Only safe: ?.的用法 若操作符前的对象为空则return null；否则执行操作符后的操作
 *    操作符非空断言: !!.的用法 告知编译器我确信这个对象是不为空的。
 *
 * */


//不允许返回null值，尝试返回null值编译器会报错，该方法返回的对象一定是不为null的
fun getNonnullString(): String {
    return "str"
}

//允许返回null值，因此才操作该方法返回的对象时
fun getNullableString(): String? {

    return "12323232313123113123"
}

fun main(args: Array<String>) {
    println(getNonnullString().length)//不用担心空指针异常
    println(getNullableString()!!.length)//告知编译器我确定getNullableString返回的对象不为空
    println(getNullableString()?.length)//告知编译器getNullableString不为空时执行后面的操作
}
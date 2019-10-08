package com.chumfuchiu.happywave.kotlin.chapter02

/**
 * 数学概念上的区间，表示一个范围。
 * kotlin默认支持四个整形区间Byte Short Int Long,所有区间都是ClosedRange的子类
 * ClosedRange是Compare的子接口；
 *
 */
val aIntRange:IntRange = 0..1024//[0,1024]
val aIntExcludeRange:IntRange = 0 until 1024//[0,1024)
fun main() {
    println(aIntRange.isEmpty())
    println(aIntRange.contains(10))
    println(10 in  aIntRange)//与上面的contain等价

    //区间可以用于迭代
    for(i in aIntRange){
        print("${i},")
    }
}
package com.chumfuchiu.happywave.kotlin.chapter03

/**
 * 【kotlin中的循环表达式】
 * kotlin中的循环完全兼容Java中的循环写法，但是kotlin中支持"标签中断循环"，可通过标签可以跳出任意循环
 */
fun main() {
    val args = arrayOf("hello","kotlin","nice","to","meet","you")
    //类似与Java中的简易for循环
    for(it in args){
        println(it)
    }

    //使用withIndex,withIndex 返回的是Iterable,所有的Iterable对象支持迭代写法
    for(indexValue in args.withIndex()){
        println("${indexValue.index} - ${indexValue.value}")
    }
    //上面迭代的另一种形式
    for((key,value) in args.withIndex() ){
        println("${key} - ${value}")
    }
    //while循环
    var size:Int = args.size
    while(size > 0){
        println(args[size-1])
        size--
    }
    //do...while
    var index:Int = args.size -1
    do{
        print(args[index] + ",")
        index--
    }while (index >= 0)

    //
    println()
    println("-----")
    //以下代码输出 123
    //因为在第一次外循环的时候遇到字符串 break，借助外层循环标签直接跳出的外层循环
    val args2 = arrayOf("1", "2","3","break","5")
    Loop1@ for (it in args2) {
        Loop2@ for (it1 in args2) {
            if(it1.equals("break")){
                break@Loop1
            }
            print(it1)
        }
        println("-> ${it}") //没有打印机会，因为在首次内层循环过程中已经break了外层循环
    }
    //以下代码输出
//    123-> 1
//    123-> 2
//    123-> 3
//    123-> break
//    123-> 5
    //因为break就近原则，只break离它最近的那一层循环
    println()
    println("-----")
    Loop1@ for (it in args2) {
        Loop2@ for (it1 in args2) {
            if(it1.equals("break")){
//                break@Loop2 于break在这里的效果是等价的
                break
            }
            print(it1)
        }
        println("-> ${it}") //打印完内层循环后，打印外层循环并换行
    }
}
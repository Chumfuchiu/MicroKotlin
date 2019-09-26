package com.chumfuchiu.happywave.kotlin.chapter02

/**
 * 数组：
 * 1.kotlin中的数组通过 arrayOf 进行进行创建，arrayOf支持泛型
 * 2.八大基本数据类型也有自己的数组创建方式 xxxArrayOf
 * 3.for循环遍历方式与Java有略微不同
 * 4.kotlin同样支持用[]随机访问
 */
val strArr: Array<String> = arrayOf("北京","中关村","爱奇艺创新大厦")
val intArr : IntArray = intArrayOf(1,2,3)
val charArr : CharArray = charArrayOf('中','国','北','京')
fun main(args: Array<String>) {
    println(strArr)//输出JVM中的类型描述符 及其内存地址[Ljava.lang.String;@60e53b93
    println(intArr)//输出JVM中的类型描述符 及其内存地址[I@5e2de80c

    println(intArr.size)//数组长度3

    //循环输出结果：北京中关村爱奇艺创新大厦
    for(str in strArr){
        print(str)
    }

    println()
    println(strArr.joinToString())//北京, 中关村, 爱奇艺创新大厦
    println(strArr.joinToString(""))//北京中关村爱奇艺创新大厦 设置分隔符为空字符串

    println(strArr[2])//输出 爱奇艺创新大厦
    strArr[2] = "鼎好大厦"
    println(strArr[2])//输出 鼎好大厦

}
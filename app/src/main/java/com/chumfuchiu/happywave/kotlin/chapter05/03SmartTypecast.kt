package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * 【kotlin中的智能类型转换】
 * 在Java中，结合Java的多态性质，若存在形如
 * Object obj = new Integer() 的情况时，想要调用Integer对象的方法，必须要进行强制类型转换:
 * Integer i = (Integer) obj;
 * 这个强制转换失败有可能抛出ClassCastException异常.
 * 因此，在Java中需要在强制转换之前需要使用 instanceof 操作符做类型判断，之后再做强制转换来保证转换正常
 *
 * kotlin中使用 is 操作符来代替Java中的 instanceof 操作符，并且在使用操作符后编译器已经知道该对象的
 * 类型，不需要再次做强制转换。
 *
 * kotlin提供来 as操作符来进行强制转换，若强制转换失败就会抛出异常；如果不想抛出异常，则使用as?替代，该
 * 操作符强制转换失败则返回空对象
 *
 */
fun main() {
    //str是一个可空的任意类型，这里将一个String对象作为其实例
    var str:Any? = String(charArrayOf('1','2','3','4','5'))

    println(str?.toString())//输出12345

    if(str is String){
        println(str.toString())//不需要像Java一样,在使用操作符判断数据类型后还需要做类似于(String)str的强制转换
    }


    var i1:Int? = str as Int
    //转换失败抛出异常，java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
    var i2:Int? = str as? Int
    println(i2)
    //转换失败不会抛出异常，而是return null，因此i2的数据类型必须是可空数据类型Int？，而不是Int

}
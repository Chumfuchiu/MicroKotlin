package com.chumfuchiu.happywave.kotlin.chapter02

/**
 * 【kotlin的基本数据类型】
 * 在kotlin中，变量分为只读变量和普通变量两种。
 * 定义变量写法：
 *  var 标志符：类型 = 值
 *  val 标志符：类型 = 值
 * 变量的类型是可以省略，由编译器去判断。
 *
 * kotlin支持八大基本数据类型，Byte Short Int Long Boolean Char Float Double；
 * 与Java对比：
 * 1.Kotlin不支持八进制
 * 2.Kotlin中的基本数据类型是 “Java基本数据类型及其装箱类型”的结合体，例如Kotlin的Int代表的就是Java的
 *   int和Integer，具体代表哪一种由编译器去决定
 * 3.val表示的是只读变量，不能被修改，对kotlin而言是不可变的，但是它并不是"编译期常量"，编译期常量需要加上const
 * 修饰，具体的不同可以查看字节码。
 *
 */

//Byte一般不用来表示数据，常用于比特流中
val aByet:Byte = Byte.MAX_VALUE
//Short一般用不着，占2个字节空间
val aShort:Short = Short.MIN_VALUE
//Int 通常的整型默认是Int，在kotlin中Int不支持八进制写法
val aInt = 256
val aInt1 = 0xFF
val aInte2 = 0b11111111
//Long 表示的范围比Int大，可以表示更大的范围，需要在字面量后加个L
val aLong = 256L
//Boolean
val aBoolean: Boolean = true
val aBoolean1: Boolean = false
//字符，除了支持Unicode之外还⽀持这⼏个转义序列：\t 、
//\b 、\n 、\r 、\' 、\" 、\\ 与 \$，编码其他字符要⽤ Unicode编码
val aChar: Char = '0'
val bChar: Char = '中'
val cChar: Char = '\u000f'
//Float和Double：Float存在精度问题，一般不适用，表示小数用Double
val aFloat = Float.MAX_VALUE
val aDouble = Double.MIN_VALUE

fun main(args: Array<String>) {
}
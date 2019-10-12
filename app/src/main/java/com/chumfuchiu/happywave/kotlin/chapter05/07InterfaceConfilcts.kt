package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * 【kotlin中的接口冲突】
 * 1.kotlin与Java一样，当遇到接口冲突时，要求方法签名一致&返回值相同，此类的接口冲突时可解的；若方法签名一致但是
 * 返回值不同，那么此接口冲突无解。
 * 2.kotlin在接口冲突时，支持用 super<Type>去调用指定类型的冲突方法
 *
 */
interface A {
    fun x(): Int {
        return -100
    }
}

interface B {
    fun x(): Int {
        return 100
    }
}

class Conflicts(var x: Int) : A, B {
    //编译器报错：Conflictsings Overloading，重载冲突。
    //这点与Java一样，当一个类继承自两个接口发生接口方法冲突时，只能重写一个方法，因为Java时通过
    //方法签名（方法名+参数列表）去标志一个方法
//    override fun x(): Int {
//    }

    override fun x(): Int {
        //Exception in thread "main" java.lang.StackOverflowError,因为这里相当于this递归调用x()方法
//        when {
//            x > 100 -> return (this as A).x()
//            x < -100 -> return (this as B).x()
//        }
        when {
            x > 100 -> return super<A>.x()
            x < -100 -> return super<B>.x()
        }
        return x
    }
}

fun main() {
    var con: Conflicts = Conflicts(200)
    var con1: Conflicts = Conflicts(-200)
    var con2: Conflicts = Conflicts(0)
    println(con.x())
    println(con1.x())
    println(con2.x())
}
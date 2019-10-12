package com.chumfuchiu.happywave.kotlin.chapter05


/**
 * 【kotlin中的抽象类】
 * 1.kotlin与Java一样，是"单继承多实现"。
 * 2.kotlin中的类默认是final的，如果要将一个类变成可继承的，那么该类需要用open关键字修饰；此外，如果父类某个
 * 方法是可重写的，那么父类方法也需要被open修饰，同时子类方法需要用override修饰，表明该方法是重写父类方法；
 * 如果父类的属性想要被子类继承，那么该属性也是需要被open修饰的。
 * 3.接口和抽象类不需要用open修饰也可以被实现&继承，抽象方法需要用abstract修饰，不需要用open修饰，接口方法默认
 * 就是open的。
 * 【kotlin中的可见性01:04:27】
 * 在kotlin中，默认的权限访问修饰符是public
 */

//定义一个接口 Windows系统电脑
interface IWindowComputer {
    fun launch()
    fun shutdown() {
        println("电脑关机了")
    }
}

//定义一个接口 价格
interface IPrice {
    fun type(): String
    fun count(): Int
}

interface ISize {
    fun size(): String
}

//定义一个抽象类 华为电脑
abstract class HuaweiComputer : IWindowComputer {
    abstract fun deviceName(): String//定义一个抽象方法，抽象方法需要用abstract修饰，且没有方法体
    override fun launch() { //只重写'电脑接口'的launch方法
        println("华为电脑开机了")
    }
}

//定义一个类 具体的电脑 华为matebook,继承自华为电脑，实现了价格、尺寸两个接口
class MateBook14 : HuaweiComputer(), IPrice, ISize {

    override fun type(): String {
        return "美元"
    }

    override fun count(): Int {
        return 699
    }

    override fun deviceName(): String {
        return "华为matebook"
    }

    override fun size(): String {
        return "13英寸"
    }

    override fun launch() {
        println("${size()} ${count()}:${type()} 的 ${deviceName()} 开机了")
    }
}

fun main() {
    var mateBook14: MateBook14 = MateBook14()
    mateBook14.launch()
    mateBook14.shutdown()
}
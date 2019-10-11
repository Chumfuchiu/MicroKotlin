package com.chumfuchiu.happywave.kotlin.chapter05


/**
 * 【kotlin中的抽象类】
 * kotlin与Java一样，是"单继承多实现"
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
    abstract fun deviceName():String//定义一个抽象方法
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

    override fun deviceName():String {
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
    var mateBook14:MateBook14 = MateBook14()
    mateBook14.launch()
    mateBook14.shutdown()
}
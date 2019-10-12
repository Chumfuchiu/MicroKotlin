package com.chumfuchiu.happywave.kotlin.chapter05


/**
 * 【kotlin中的接口代理】
 * 通常情况下一个类实现类某个接口，就需要复写该接口的方法。
 * 代理模式是开发中比较常见的设计模式，kotlin提供类接口代理的写法，简化类代理代码。
 */
//定义两个接口 ：开车&喝酒
interface IDrive {
    fun drive()
}

interface IDrink {
    fun drink()
}

//两个接口的实现类：私人司机&私人代酒
class PersonalDriver :IDrive{
    override fun drive() {
        println("专职老司机开车")
    }
}

class PersonalDrinker:IDrink{
    override fun drink() {
        println("酒场老司机喝酒")
    }
}

//职工类，重写IDrink, IDrive接口方法
class Staff : IDrink, IDrive {
    override fun drive() {
        println("我亲自开车送你一程")
    }

    override fun drink() {
        println("我敬你一杯")
    }
}
//老板类，重写IDrink, IDrive方法，通过代理模式实现"代驾"和"代酒"
class Boss(var driver: IDrive, var drinker: IDrink) : IDrive, IDrink {
    override fun drink() {
        print("我头孢了，我让我小弟跟你喝.")
        drinker.drink()//代酒
    }

    override fun drive() {
        print("我喝了些酒，我让我司机送你一程.")
        driver.drive()//代驾
    }
}

//老板类，重写IDrink, IDrive方法，通过代理模式实现"代驾"和"代酒"。
//通过kt提供的接口代理，代码变得十分简洁。
class Boss2(var driver: IDrive, var drinker: IDrink) : IDrive by driver, IDrink by drinker

fun main() {
    var staff = Staff()
    staff.drink()//我敬你一杯
    staff.drive()//我亲自开车送你一程

    var boss = Boss(PersonalDriver(),PersonalDrinker())
    boss.drive()//我喝了些酒，我让我司机送你一程.专职老司机开车
    boss.drink()//我头孢了，我让我小弟跟你喝.酒场老司机喝酒

    var boss2 = Boss2(PersonalDriver(),PersonalDrinker())
    boss2.drive()//专职老司机开车
    boss2.drink()//酒场老司机喝酒
}
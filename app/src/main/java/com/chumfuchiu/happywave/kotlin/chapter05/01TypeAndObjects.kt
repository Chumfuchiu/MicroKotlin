package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * 【kotlin的类与及对象的创建】
 * 1.Any类在kotlin的地位就和Object类在Java中的地位一样，是所有类的基类
 * 2.定义一个类时，类的主体可以省略
 * 3.kotlin中在类名后使用constructor关键字来定义一个类的主构造函数；如果只有一个构造函数，constructor关键字
 *   可以省略
 * 4.init块是构造函数的方法体，在一个类被实例化时会被调用，我们可以在这里调用一些初始化方法；
 *   如果有多个init块，按顺序调用
 * 5.kotlin中的继承关系用“ ：”，被继承的类与Java一样必须是非final的。如果将一个类变成非final的，
 *   在kotlin需要open关键字修饰
 * 6.当一个类被实例化时，它的init块会被调用，同时其父类的init块也会被调用
 * 7.判断一个对象的类型，使用 is 关键字
 * 8.kotlin中任意类型都有可空和不可空两种类型，区别在于类型后是否有一个" ？"
 * 9.kotlin支持成员变量的延迟初始化从而减小第内存的占用
 */

//2.定义一个类,类体可以省略
class Person

//3.定义一个类,类名后使用constructor定义主构造器；如果形参被var/val 修饰，那么这个形参会被认为是属性,否则不是属性；
//例如在下面的构造方法中除了id，其他的都是类的属性
//类的内部也是可以定义属性的
class Developer constructor(
    var name: String, var hometown: String, var profession: String,
    id: Int
) {
    //4.构造函数方法体
    init {
        println("我叫${name},来自${hometown},我的岗位是${profession},我的ID是${id}")
    }

    //在类的内部定义属性lang和age，并重写他们的get方法
    var lang: String = "中文"
        get() {
            println("get方法被重写了")
            return field
        }
    var age: Int = 0
        get() {
            println("get方法被重写了")
            return field
        }

    //lateinit用于支持var属性的延迟初始化，减小对内存的占用
    lateinit var sex: String
    //by layzy接收一个lambda表达式用于支持val属性的延迟初始化，这样可以减少对内存对占用

    val company: String by lazy {
        "爱奇艺"
    }
    //虽然也可以像Java中定义一个默认值为null的属性，但是在kt中访问该属性时需要"!!" 或者"?."操作符保证空安全
    var workTime: String? = null
}

//3.定义一个类，constructor可以省略
class Teacher(var name: String, var hometown: String, var school: String) {
    //构造函数方法体
    init {
        println("我叫${name},来自${hometown},我毕业于${school}")
    }
}

//5.定义一个基类，要使得一个类可以被继承，它必须是非final的，将一个类变成非final的需要用open关键字修饰
open class Student(open var name: String, open var age: Int) {
    init {
        println("我是一个学生，我叫${name}，今年${age}岁了")
    }
}

//5.定义一个子类并重写父类的构造方法，子类从父类继承的属性需要使用override修饰，同时父类可以被继承
// 的属性必须是open的
class SeniorHighSchoolStudent(override var name: String, override var age: Int) :
    Student(name, age) {
    init {
        println("我是一个高学生，我叫${name}，今年${age}岁了")
    }

    fun invitePlayBall() {
        println("我们打球去吧")
    }

    fun invitePlayBall(ball: String) {
        println("我们打${ball}去吧")
    }
}


fun main(args: Array<String>) {
    val developer: Developer = Developer("ChumFuchiu", "广西南宁", "Android开发工程师", 17827)
    val teacher: Teacher = Teacher("小马哥", "广东汕头", "深圳大学")
    val student: Student = Student("雷布斯", 19)
    val shStudent: SeniorHighSchoolStudent = SeniorHighSchoolStudent("小冬瓜", 20)
//    我叫ChumFuchiu,来自广西南宁,我的岗位是Android开发工程师
//    我叫小马哥,来自广东汕头,我毕业于深圳大学
//    我是一个学生，我叫雷布斯，今年19岁了

//    我是一个学生，我叫null，今年0岁了 【6.子类初始化之前，需要进行父类的初始化，这点和Java一样的，毕竟kt也允许在jvm上】
//    我是一个高学生，我叫小冬瓜，今年20岁了

    developer.age//get方法被重写了
    developer.lang//get方法被重写了

    println(shStudent is SeniorHighSchoolStudent)//true
    println(shStudent is Student)//true
    println(shStudent is Any)//true

    //
    shStudent.invitePlayBall()//我们打球去吧
    shStudent.invitePlayBall("篮球")//我们打蓝球去吧
}
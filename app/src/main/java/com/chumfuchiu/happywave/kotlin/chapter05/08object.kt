package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * 【kotlin中的object】
 * 在kotlin中，可以通过object关键字定义一个非延迟的饿汉式单例
 */
interface IClient {
    fun login(name: String, pwd: String)
    fun logout()
}
abstract class AbsClient:IClient{
    lateinit var name: String
    lateinit var pwd: String
    override fun login(name: String, pwd: String) {
        this.name = name
        this.pwd = pwd
        println("${name} 登陆了")
    }

    override fun logout() {
        println("${name} 注销了")
    }
}
object Client:AbsClient(){

}
fun main() {
    //Exception in thread "main" kotlin.UninitializedPropertyAccessException:
    // lateinit property name has not been initialized
//    println(Client.name.length)

    Client.login("ChumFuchiu","pwd123456")
    Client.logout()
}
package com.chumfuchiu.happywave.kotlin.chapter05

/**
 * 【kotlin中的接口】
 * kotlin中的接口与Java中的接口是等价的概念。
 * kotlin中的接口与"Java8"的接口一样，可以为接口方法定义默认实现。
 * kotlin中的接口也允许继承，即允许定义子接口
 */

//定义一个接口 电脑
interface IComputer {
    fun computerName(): String
    fun launch()
    fun shutDown()
}

class MacBookPro : IComputer {
    override fun computerName(): String {
        return "ChumFuchiu的Macbookro"
    }

    override fun launch() {
        println(computerName())
        println("${MacBookPro::class.java.simpleName} 开机了。。。")
    }

    override fun shutDown() {
        println("${MacBookPro::class.java.simpleName} 开机了。。。")
    }

    fun addInputDevice(device: InputDevice) {
        when (device) {
            is USBInputDevice -> {
                addUSBInputDevice(device)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(device)
            }
            else -> {
                println("${computerName()} 接入了未知类型的设备 : ${device.deviceName()}")
            }
        }
    }

    fun addUSBInputDevice(usbDevice: USBInputDevice) {
        println("${computerName()} 接入了USB设备 ${usbDevice.deviceName()}")
    }

    fun addBLEInputDevice(bleDevice: BLEInputDevice) {
        println("${computerName()} 接入了蓝牙设备 ${bleDevice.deviceName()}")
    }
}

//定义一个接口 输入设备
interface InputDevice {
    fun deviceName(): String
}

//定义一个二级接口 USB输入设备，并提供接口方法的默认实现
interface USBInputDevice : InputDevice{
    override fun deviceName(): String {
        return "未知USB输入设备"
    }
}

//定义一个二级接口 蓝牙输入设备
interface BLEInputDevice : InputDevice{
    override fun deviceName(): String {
        return "未知蓝牙输入设备"
    }
}

//定义一个接口的实现类，并实现接口方法；这里的接口方法可以不实现，因为USBInputDevice已经为该方法提供了默认实现
class USBMouse:USBInputDevice{
    override fun deviceName(): String {
        return "USB鼠标"
    }
}

class BLEHi_Fi:BLEInputDevice{
    override fun deviceName(): String {
        return "蓝牙音响"
    }
}

fun main() {
    var macBookPro:MacBookPro = MacBookPro()
    macBookPro.launch()

    //利用接口实现匿名内部类
    val xiaomi:InputDevice = object : InputDevice {
        override fun deviceName(): String {
            return "小米手机"
        }
    }
    macBookPro.addInputDevice(xiaomi)
    macBookPro.addInputDevice(object : InputDevice {
        override fun deviceName(): String {
            return "红米手机"
        }
    })
    macBookPro.addUSBInputDevice(USBMouse())
    macBookPro.addBLEInputDevice(BLEHi_Fi())
    macBookPro.shutDown()
}



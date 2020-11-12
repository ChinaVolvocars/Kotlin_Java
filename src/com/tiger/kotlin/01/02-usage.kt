package com.tiger.kotlin.`01`

import java.io.File
import java.lang.IllegalStateException
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


fun main(args: Array<String>) {
    val customer = Customer("复星医药", 11, "广州")
//    println(customer.toString())
//    foo()
//    filterList()
//    checkElement()
//    stringInterpolation()

//    typeJudgment(Object())
//    traverseMap()
//    range()
//    readOnlyMap1()
//    lazyProperty()
//    "Convert this to camelcase".spaceToCamelCase()

//    ifNotNull()
//    ifNotNullAndElse()
    ifNull()
}


//# 习惯用法

//## 创建 DTOs（POJOs/POCOs）
data class Customer(val name: String, val age: Int, val address: String)

//## 函数的默认参数
fun foo(a: Int = 1, b: String = "--") {
    println("$a,$b")
}

//## 过滤 list
fun filterList() {
    val listOf = listOf<Int>(1, 2, 4, 5, 12, 32, 41, 51)
    val filter1 = listOf.filter { it -> it > 10 }
    //同上意思
    val filter = listOf.filter { it > 10 }

    filter1.forEach { println(it) }
    println("---------------------------------")
    listOf.filter { it > 24 }.forEach { println(it) }
}

//## 检测元素是否存在于集合中
fun checkElement() {
    val emailList = listOf<String>("john@example.com", "jane@example.com", "jack@example.com", "mark@example.com")
    if ("john@example.com" in emailList) {
        println("john@example.com")
    }

    if ("jane1@example.com" !in emailList) {
        println("不含....")
    } else {
        println("john@example.com")
    }
}

//## 字符串内插
fun stringInterpolation() {
    val name: String = "你好啊"
    println("我的名字：$name")
}

//## 类型判断
fun typeJudgment(x: Any) {
    when (x) {
        is Int -> println("Int")
        is String -> println("String")
        is Byte -> println("Byte")
        is Char -> println("Char")
        is Short -> println("Short")
        is Long -> println("Long")
        is Float -> println("Float")
        is Double -> println("Double")
        is Any -> println("Object")
        else -> {
            println("----------------------")
        }
    }
}

//## 遍历 map/pair型list
fun traverseMap() {
    //MutableList<E>、MutableSet<E>、MutableMap<K,V>
    //不可变的Map类型集合的初始化使用：mapOf()函数
    //可变的Map类型集合的初始化使用：mutableMapOf()函数
    val mapOf = mapOf<Int, String>(1 to "A", 2 to "B", 3 to "C", 4 to "D")
    val mutableMapOf = mutableMapOf<String, Int>("A" to 1, "B" to 2, "C" to 3, "D" to 4)

    for ((k, v) in mapOf) {
        println("$k -> $v")
    }
    println("--------------------")
    for ((x, y) in mutableMapOf) {
        println("$x -> $y")
    }
}

//## 使用区间
fun range() {
    for (i in 1..10) {
        println(i)
    }
    println("------------------------")
    for (i in 1 until 10) {
        println(i)
    }
    println("------------------------")

    for (i in 2..10 step 2) {
        println(i)
    }
    println("------------------------")

    for (i in 10 downTo 1) {
        println(i)
    }
    println("------------------------")

    for (x in 1..10) {
        println(x)
    }
    println("------------------------")
}

//## 只读 list
fun readOnlyList() {
    val list = listOf("a", "b", "c")
}

//## 只读 map
fun readOnlyMap() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
}

//## 访问 map
fun readOnlyMap1() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map["a"])
}

//## 延迟属性
fun lazyProperty() {
    val p: String by lazy {
        // 计算该字符串 "1"
        "LAZY"
    }
    val i: Int by lazy {
        1 + 1
    }

    println(p)
    println(i)
}

//## 扩展函数
fun String.spaceToCamelCase() {

}

//## 创建单例
object Resource {
    val name = "name"
}

//## If not null 缩写
fun ifNotNull() {
    val files = File("Test").listFiles()
    println(files?.size)
}

//## If not null and else 缩写
fun ifNotNullAndElse() {
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")
}

//## if null 执行一个语句
fun ifNull() {
    val files = mapOf<String, String>("email" to "2222")
    files["e"] ?: throw IllegalStateException("E 的value 是null")
}

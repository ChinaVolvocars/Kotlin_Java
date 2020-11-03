package com.tiger.kotlin.`01`

import java.time.Year
import java.util.*

fun main() {
//    println(sum(1, 33))
//    variableVal()
//    variableVarDing()
//    stringTemplate()
//    printProduct("2", "33")
//    printProduct("w", "f")

    cycleFor(items = listOf("aa","bbb","cc","dd"))
}

//# 基础
//## 函数
//## 带有两个 Int 参数、返回 Int 的函数
fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sum1(a: Int, b: Int) = a + b
fun printSum(x: Int, y: Int): Unit {
    println("sum of $x and $y is ${x + y}")
}

//## 变量
//### val
//定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
fun variableVal() {
    val a: Int = 1  // 立即赋值
    val b = 22      // 自动推断出 `Int` 类型
    val c: Int      // 如果没有初始值类型不能省略
    c = 55          // 明确赋值

    println("a=${a}，b${b},c=${c}")
}

//### var
//可以重新赋值的变量 `var`
fun variableVar() {
    var x = 6
    x += 1
    println("x=${x}")
}


//顶层变量：
var PI = 3.14
var x = 1

fun incrementX() {
    x += 1
}

fun variableVarDing() {
    println("x=${x}")
    println("x = $x; PI = $PI")
    println("incrementX()")
    println("x = $x; PI = $PI")
}
//## 注释
//这是一个行注释
/*这是一个多行的块注释*/
/* 注释从这里开始
/* 包含嵌套的注释 */
并且在这里结束。 */

//## 字符串模板
fun stringTemplate() {
    var a = 1
    val s = "a is $a"
    a = 2

    val s2 = "${s.replace("is", "was")}，but now is $a"
    println(s2)

    val price = """
         ${'$'}9.99
    """

    println(price)
}

//## 条件表达式

fun conditionalExpressionIf1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun conditionalExpressionIf2(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun conditionalExpressionIf3(a: Int, b: Int) = if (a > b) a else b

//## 空值与 null 检测
//当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
//如果 str 的内容不是数字返回 null：

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("'$arg1' or '${arg2}' is not a number")
    }
}

//## 类型检测与自动类型转换
//is 运算符检测一个表达式是否某类型的一个实例。 如果一个不可变的局部变量或属性已经判断出为某类型，
// 那么检测后的分支中可以直接当作该类型使用，无需显式转换：

fun getStringLength(objects: Any): Int? {
    if (objects is String) {
        return objects.length
    }
    return null
}

fun getStringLength1(objects: Any): Int? {
    if (objects !is String) {
        return null
    }
    return objects.length
}

fun getStringLength2(objects: Any): Int? {
    if (objects is String && objects.length > 0) {
        return objects.length
    }
    return null
}

//## for 循环

val items = listOf<String>("AAA", "bb", "ee", "dd", "fff", "tt", "hhh")
fun cycleFor(items: List<String>) {
    for (item in items) {
        println(item)
    }
}


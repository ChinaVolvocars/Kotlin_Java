package com.tiger.kotlin.`01`

import java.time.Year

fun main() {
    println(sum(1, 33))
}

//# 函数
//## 带有两个 Int 参数、返回 Int 的函数
fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sum1(a: Int, b: Int) = a + b
fun printSum(x: Int, y: Int): Unit {
    println("sum of $x and $y is ${x + y}")
}
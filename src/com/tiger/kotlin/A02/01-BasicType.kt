package com.tiger.kotlin.A02

fun main() {
//    number1()
//    printDouble(1) //不支持
//    printDouble(1.1)
//    printDouble(1.1f)//不支持

//    digitalBox()
//    digitalBox1()
//    integerDivision()
    bitOperation()

}

//# 基本类型：数字、字符、布尔值、数组与字符串

//## 数字
//Kotlin 提供了一组表示数字的内置类型。 对于整数，有四种不同大小的类型，因此值的范围也不同。

fun number1() {
    //所有以未超出 Int 最大值的整型值初始化的变量都会推断为 Int 类型。
    // 如果初始值超过了其最大值，那么推断为 Long 类型。
    // 如需显式指定 Long 型值，请在该值后追加 L 后缀。
    val one = 1 //Int
    val threeBillion = 300000000    //Long
    val oneLong = 1L    //Long
    val oneByte: Byte = 1

    //对于浮点数，Kotlin 提供了 Float 与 Double 类型。
    // 根据 IEEE 754 标准， 两种浮点类型的十进制位数（即可以存储多少位十进制数）不同。
    // Float 反映了 IEEE 754 单精度，而 Double 提供了双精度。

    val pi = 3.14
    val e = 2.7182818284
    val eFloat = 2.7182818284f//float 实际 2.7182817

    println("$pi,$e,$eFloat")

}

fun printDouble(d: Double) {
    println(d)
}

//## 字面常量
//十进制123、十六进制0x0F、二进制0b00001011 。注意: 不支持八进制

//## 数字字面值中的下划线
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

//## 表示方式
//在 Java 平台数字是物理存储为 JVM 的原生类型，除非我们需要一个可空的引用（如 Int?）或泛型。 后者情况下会把数字装箱。
//注意数字装箱不一定保留同一性

fun digitalBox() {
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false


}

//另一方面，它保留了相等性
fun digitalBox1() {
    val a: Int = 10000
    println(a == a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA) // 输出“true”
}

//## 显式转换
fun explicitConversion() {
    // 假想的代码，实际上并不能编译：
//    val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
//    val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
//    print(b == a) // 惊！这将输出“false”鉴于 Long 的 equals() 会检测另一个是否也为 Long
    val b: Byte = 1
//    val i:Int=b
    val toInt = b.toInt()
    println(toInt)
}

//## 运算
//Kotlin支持数字运算的标准集（+ - * / %），运算被定义为相应的类成员（但编译器会将函数调用优化为相应的指令）
//## 整数除法
//请注意，整数间的除法总是返回整数。会丢弃任何小数部分。例如：
fun integerDivision() {
    val x = 5 / 2
    println(x)
    println(x == 2)
    //对于任何两个整数类型之间的除法来说都是如此
    val y = 5L / 2
    println(y)
    println(y == 2L)

    //如需返回浮点类型，请将其中的一个参数显式转换为浮点类型
    val n = 5 / 2.toDouble()
    println(n)
    println(n == 2.5)

}

//## 位运算
//对于位运算，没有特殊字符来表示，而只可用中缀方式调用具名函数，例如:
fun bitOperation() {
    val x = (1 shl 2) and 0x000FF000
    //这是完整的位运算列表（只用于 Int 与 Long）：
    //shl(bits) – 有符号左移
    //shr(bits) – 有符号右移
    //ushr(bits) – 无符号右移
    //and(bits) – 位与
    //or(bits) – 位或
    //xor(bits) – 位异或
    //inv() – 位非
}

//## 浮点数比较
fun floatingPointComparison() {
    //相等性检测：a == b 与 a != b
    //比较操作符：a < b、 a > b、 a <= b、 a >= b
    //区间实例以及区间检测：a..b、 x in a..b、 x !in a..b

}
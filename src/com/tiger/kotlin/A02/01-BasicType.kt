package com.tiger.kotlin.A02

fun main() {
//    number1()
//    printDouble(1) //不支持
//    printDouble(1.1)
//    printDouble(1.1f)//不支持

//    digitalBox()
//    digitalBox1()
//    integerDivision()
//    bitOperation()

//    arrs()
    primitiveArray()
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
//当其中的操作数 a 与 b 都是静态已知的 Float 或 Double 或者它们对应的可空类型（声明为该类型，或者推断为该类型，或者智能类型转换的结果是该类型），两数字所形成的操作或者区间遵循 IEEE 754 浮点运算标准。
//
//然而，为了支持泛型场景并提供全序支持，当这些操作数并非静态类型为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：
//
//认为 NaN 与其自身相等
//认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
//认为 -0.0 小于 0.0
}

//## 字符
//字符用 Char 类型表示。它们不能直接当作数字
fun check(c: Char) {
//    if (c == 1) { // 错误：类型不兼容
//
//    }
}
//字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。
// 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 与 \$。
// 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。

//我们可以显式把字符转换为 Int 数字：
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("out of range")
    }
    return c.toInt() - '0'.toInt()
}
//当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。

//## 布尔
//布尔用 Boolean 类型表示，它有两个值：true 与 false。
//
//若需要可空引用布尔会被装箱。
//
// 内置的布尔运算有：
//
// || – 短路逻辑或
// && – 短路逻辑与
// ! - 逻辑非

//## 数组
// 数组在 Kotlin 中使用 Array 类来表示，
// 它定义了 get 与 set 函数（按照运算符重载约定这会转变为 []）
// 以及 size 属性，以及一些其他有用的成员函数：
//class Array<T> private constructor() {
//    val size: Int
//    operator fun get(index: Int): T
//    operator fun set(index: Int, value: T): Unit
//
//    operator fun iterator(): Iterator<T>
//    // ……
//}

// 我们可以使用库函数 arrayOf()
// 来创建一个数组并传递元素值给它，
// 这样 arrayOf(1, 2, 3) 创建了 array [1, 2, 3]。
// 或者，库函数 arrayOfNulls() 可以用于创建一个指定大小的、所有元素都为空的数组。
//
// 另一个选项是用接受数组大小以及一个函数参数的 Array 构造函数，
// 用作参数的函数能够返回给定索引的每个元素初始值：

fun arrs() {
    // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }
    println("--------------")
    val s = Array(6) { i ->
        i + 1
    }

    s.forEach {
        println(it)
    }
}
//如上所述，[] 运算符代表调用成员函数 get() 与 set()。
//Kotlin 中数组是不型变的（invariant）。
// 这意味着 Kotlin 不让我们把 Array<String> 赋值给 Array<Any>，
// 以防止可能的运行时失败（但是你可以使用 Array<out Any>,

//# 原生类型数组
//Kotlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等。
// 这些类与 Array 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法:

fun primitiveArray(): Unit {
    val intArrayOf: IntArray = intArrayOf(1, 2, 3)
    intArrayOf[0] = intArrayOf[1] + intArrayOf[2]
    intArrayOf.forEach { print(it) }

    // 大小为 5、值为 [0, 0, 0, 0, 0] 的整型数组
    val array = IntArray(5)
    array.forEach { println(it) }
    //// 例如：用常量初始化数组中的值
    //// 大小为 5、值为 [42, 42, 42, 42, 42] 的整型数组
    val intArray = IntArray(5) { 42 }
    println(intArray.toString())

    // 例如：使用 lambda 表达式初始化数组中的值
    // 大小为 5、值为 [0, 1, 2, 3, 4] 的整型数组（值初始化为其索引值）
    var arr = IntArray(5) { it * 1 }

}



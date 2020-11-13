package com.tiger.kotlin.A01

import com.sun.xml.internal.bind.v2.TODO
import java.awt.Rectangle
import java.io.File
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths


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
//    ifNull()
//    ifNull1()
//    ifNotNull1()
//    mappingNullableValues()
//    test()
//    fooo(1)
//    val arrayOfMinusOnes = arrayOfMinusOnes(5)
//    println(arrayOfMinusOnes.map { println(it) })
//    configurationObjectProperties()
//    getResource()

    swapTwoVariables()
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

//## 在可能会空的集合中取第一元素
fun ifNull1() {
    val em = ""
    val any = em.firstOrNull() ?: ""
    println(any)
}

//## if not null 执行代码
fun ifNotNull1() {
    val em = null
    em?.let {
        println("假如em不为null,代码会执行到此处")
    }
}

//## 映射可空值（如果非空的话）
fun mappingNullableValues() {
    val e = null
    val defaultValue = "defaultValue"
    // 如果该值或其转换结果为空，那么返回 defaultValue。
    val mapped = e?.let { printlns(it) } ?: defaultValue
    println(mapped)
}

fun printlns(value: Any) {
    println(value ?: "null value")
}

//## 返回 when 表达式
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

//## “try/catch”表达式
fun test() {
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }

    // 使用 result
    println(result)
}

fun count() {
    println("---计算----")
}

//## “if”表达式
fun fooo(pa: Int) {
    val result = if (pa == 1) {
        "1"
    } else if (pa == 2) {
        "2"
    } else {
        "3"
    }
    println(result)
}

//## 返回类型为 Unit 的方法的 Builder 风格用法
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(3) }
}

//## 单表达式函数
fun theAnswer() = 422

//和上面一样
fun theAnswer1(): Int {
    return 42
}

//单表达式函数与其它惯用法一起使用能简化代码，例如和 when 表达式一起使用：
fun tansform(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    else -> throw IllegalArgumentException("Invalid color param value")
}

//## 对一个对象实例调用多个方法 （with）
fun objectInstance() {
    val turtle = Turtle()
    with(turtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

//## 配置对象的属性（apply）
fun configurationObjectProperties() {
    val apply = Rectangle().apply {
        width = 1
        height = 11
    }
    val apply1 = Rectangle1().apply {
        name = "Tiger"
        street = "长安街001号"
        city = "北京"
        state = "良好"
        zip = "10000"
    }

    println(apply1.toString())
}

//## Java 7 的 try with resources
fun getResource() {
    val newInputStream = Files.newInputStream(Paths.get("text.txt"))
    newInputStream.bufferedReader().readText().reader().use { reader ->
        println(reader.readText())
    }
}

//## 对于需要泛型信息的泛型函数的适宜形式
//inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

//## 使用可空布尔
fun nullBoolean() {
    val boolean: Boolean? = null
    if (boolean == true) {
        println("true")
    } else {
        println("boolean 是 false 或者 null")
    }
}

//## 交换两个变量
fun swapTwoVariables() {
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("$a,$b")
}

//## TODO()：将代码标记为不完整
//Kotlin 的标准库有一个 TODO() 函数，该函数总是抛出一个 NotImplementedError。
// 其返回类型为 Nothing，因此无论预期类型是什么都可以使用它。 还有一个接受原因参数的重载：
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
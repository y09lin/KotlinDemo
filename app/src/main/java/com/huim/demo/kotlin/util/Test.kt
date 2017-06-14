package com.huim.demo.kotlin.util

/**
 * test
 * Created by huim_lin on 2017/5/26.
 */
object Test {
    fun testMain() {
        val a: Int = 10000
        DeLog.d(a === a) // 输出“true”
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        DeLog.d("$boxedA")
        DeLog.d("$anotherBoxedA")
        DeLog.d(boxedA === anotherBoxedA) // ！！！输出“false”！！！
    }

    fun testStep() {
        for (x in 1..10 step 2) {
            DeLog.d(x)
        }
        DeLog.d("####")
        for (x in 9 downTo 0 step 3) {
            DeLog.d(x)
        }
    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    fun getStringLength(obj: Any): Int? {
        if (obj !is String) return null
        return obj.length
    }

    fun printLength(obj: Any) {
        DeLog.d("'$obj' string length is ${getStringLength(obj) ?: "... err, not a str ing"} ")
    }

    fun getStr():String{
        val sb=StringBuffer()
        sb.append(getInt("3")).append("\n")
        sb.append(getInt("a")).append("\n")
        sb.append(getInt("")).append("\n")
        sb.append(getInt(" ")).append("\n")
        sb.append(getInt("99999999999")).append("\n")
        sb.append(getInt("999999$")).append("\n")
        return sb.toString()
    }

    fun getInt(str:String)=if (parserInt(str)!=null) str else "\"$str\" is not Integer"

    fun parserInt(str:String):Int?{
        return str.toIntOrNull()
    }

//    fun replaceStr(): String {
//        val s = message.text.toString()
//        return s.replace("World", "Kotlin")
//    }
//
//    fun addStr(str: String): String {
//        return message.text.toString() + "\n" + str
//    }

    fun filter() {
        var list = (1..10).toList()
        print("origin:")
        for (i in list) print("$i ")

        println("Filter")
        list = list.filter { v -> v % 2 == 0 }
        for (i in list) DeLog.d("$i")
    }
}
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
}
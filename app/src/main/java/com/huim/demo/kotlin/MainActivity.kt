package com.huim.demo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.util.DeLog
import com.huim.demo.kotlin.util.Test
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = addStr(replaceStr())
        message.text=addStr(getStr())
        message.setOnClickListener {
//            ToastUtils.showMessage(this,message.text.toString())
//            filter()
            Test.testMain()
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

    fun replaceStr(): String {
        val s = message.text.toString()
        return s.replace("World", "Kotlin")
    }

    fun addStr(str: String): String {
        return message.text.toString() + "\n" + str
    }

    fun filter() {
        var list = (1..10).toList()
        print("origin:")
        for (i in list) print("$i ")

        println("Filter")
        list = list.filter { v -> v % 2 == 0 }
        for (i in list) DeLog.d("$i")
    }
}

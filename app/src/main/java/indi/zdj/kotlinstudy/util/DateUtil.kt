package indi.zdj.kotlinstudy.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    //返回
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }

    fun test(dateFormat:String):String{
        return "test$dateFormat"
    }

}
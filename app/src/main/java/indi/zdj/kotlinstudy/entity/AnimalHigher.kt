package indi.zdj.kotlinstudy.entity

import android.util.Log

class AnimalHigher constructor(type:String, sex:String = "", name: String = "") {

    init {
        Log.e("tag-z","type : $type , sex : $sex , name : $name")
    }

}
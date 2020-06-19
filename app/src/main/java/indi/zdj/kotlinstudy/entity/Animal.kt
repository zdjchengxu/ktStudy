package indi.zdj.kotlinstudy.entity

import android.util.Log

class Animal(type:String) {

    init {
        Log.e("tag-z","init type : $type ")
    }

    constructor(type: String,sex: String):this(type){
        Log.e("tag-z","constructor type : $type , sex : $sex ")
    }

    constructor(type: String,sex:String,name:String) : this(type,sex) {
        Log.e("tag-z","constructor type : $type , sex : $sex , name : $name")

    }


}
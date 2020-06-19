package indi.zdj.kotlinstudy.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import indi.zdj.kotlinstudy.R

import kotlinx.android.synthetic.main.activity_basic_data_type.*
import kotlinx.android.synthetic.main.content_basic_data_type.*
import kotlin.random.Random


class BasicDataTypeActivity : AppCompatActivity() {

    //第二章节——基本数据类型

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_data_type)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        initView()

    }

    private fun initView() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.setTitle("基本数据类型")
        //基本数据类型
        var i: Int = 100;tv_int.setText(i.toString())
        var l: Long = 1000000000000000;tv_long.setText(l.toString())
        var d: Double = 10.001;tv_double.setText(d.toString())
        var c: Char = '^';tv_char.setText(c.toString())
        var str: String = "Int | Long | Double | Char | String";tv_string.setText(str)
        tv_byte.setText("Long.toByte : " + l.toByte())
        //val定义的变量只可以在声明时赋值一次
        val finalField = "finalField"
//        tv_byte.text = str

        //数组
        var int_Array: IntArray = intArrayOf(1, 2, 3, 4)
        var str_int_array = ""
        for (i in int_Array.asList()) {
            str_int_array = str_int_array + i + ","
        }
        tv_int_array.text = "intArray : " + str_int_array

        var long_Array: LongArray = longArrayOf(
            1000000000000000001,
            1000000000000000002,
            1000000000000000003,
            1000000000000000004
        )
        var str_long_array = ""
        var j = 0
        while (j < long_Array.size) {
            str_long_array = str_long_array + long_Array.get(j) + ","
            j++
        }
        tv_long_array.text = "longArray : " + str_long_array

        var char_Array: CharArray = charArrayOf('a', 'b', 'c')
        tv_char_array.text = "charArray : " + char_Array.toString()

        //array
        var test_array : Array<Int> = arrayOf(1,2,3,4,5)

        //随机数
        var rand = Random.nextInt(20)
        tv_random.text = "20以内的随机数：$rand"

        //list
        var strTestListTv = ""
        var strTestList : List<String> = listOf("tes111222333","tes222111333","tes333111222")
        for (item in strTestList) {
            strTestListTv = strTestListTv + item + "\n";
        }
        tv_list.setText(strTestListTv)

        var strList : MutableList<String> = mutableListOf("tes111222333","tes222111333","tes333111222")
        var strMutableList = ""
        var index : Int = 0
        while (index < strList.size){
            strList.set(index,strList.get(index).replace("1","9"))
            strMutableList = strMutableList + strList.get(index) +"\t"
            index ++
        }
        strList.forEach({
            var replace = it.replace("1", "9")
            strList.set(strList.indexOf(it),it.replace("1","9"))
            strMutableList = strMutableList + strList.get(strList.indexOf(replace)) +"\t"
        })
        tv_mutable_list.setText(strMutableList)

        var testMap:Map<Int,String> = mapOf(1 to "test1",2 to "test2",3 to "test3")

        var testMutableMap : MutableMap<Int,String> = mutableMapOf()

        testMutableMap.put(1,"test1")
        testMutableMap.put(2,"test2")
        testMutableMap.put(3,"test3")
        testMutableMap.put(2,"test22")

        var strMutableMap : String
        strMutableMap = "mutable.size : ${testMutableMap.size}"

        for (entry in testMutableMap) {
            entry.setValue(entry.value+entry.key)
            strMutableMap = strMutableMap + "\n ${entry.key} : ${entry.value}"
        }
        tv_mutable_map.setText(strMutableMap)

    }

    private fun testReturn(): Int {
        var testboolean:Boolean = true
        return if(testboolean) 0 else 1;
    }


}

package indi.zdj.kotlinstudy.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import indi.zdj.kotlinstudy.R
import indi.zdj.kotlinstudy.util.DateUtil

import kotlinx.android.synthetic.main.activity_control_and_function.*
import kotlinx.android.synthetic.main.content_control_and_function.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * 第三、四章接
 * 控制语句和函数
 */
class ControlAndFunctionActivity : AppCompatActivity() {

    private var controlOnlyInput: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_and_function)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.setTitle("条件控制语句和函数")

        initView()
    }

    private fun initView() {
        btn_only_input.setOnClickListener {
            onlyInput("书", 22.889, 1)
        }
        btn_higher_fun.setOnClickListener {
            higherFunClick()
        }

        DateUtil.test("aewf")
        DateUtil.nowDateTime

    }

    private fun higherFunClick() {
        //比较一组整数的最大
//        var arrayHigher : Array<Int> = arrayOf(346,34,12,125,32,1,45)

//        var max = maxValueInArray(arrayHigher,{a,b -> a > b})

//        tv_higher_fun.setText("最大值： $max")

        //比较一组字符串中最长
        var arrayStringHigher: Array<String> = arrayOf("anwe", "akwheghoqiwe", "THiewioon")

        var longString = maxValueInArray(arrayStringHigher, { a, b -> a.length > b.length })

        tv_higher_fun.setText("最长的一串 ： $longString")

    }

    fun Date.getNowTime(): String {
        var sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sdf.format(this)
    }

    /**
     * 只有输入参数
     */
    private fun onlyInput(shop: String, price: Double?, quantity: Int) {
        tv_only_input.setText(
            if (controlOnlyInput) "$shop ${price?.toString() ?: -1} 钱 $quantity 本" else
                "controlOnlyInput : $controlOnlyInput"
        )
        !controlOnlyInput
    }

    /*private fun<T> testT(index: Int, vararg  otherInfo: T):String{

        return ""
    }*/

    /**
     * 输入输出
     */
    private fun inputAndOutput(index: Int, shop: String): String = "第$index 件，商品名称：$shop"

    /**
     * 高阶函数
     */
    private fun <T> maxValueInArray(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in array) {
            if (max == null || greater(item, max))
                max = item
        }
        return max
    }


}

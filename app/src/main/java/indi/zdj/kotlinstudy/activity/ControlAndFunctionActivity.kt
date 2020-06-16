package indi.zdj.kotlinstudy.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import indi.zdj.kotlinstudy.R

import kotlinx.android.synthetic.main.activity_control_and_function.*
import kotlinx.android.synthetic.main.content_control_and_function.*

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
        toolbar.setTitle("基本数据类型")

        initView()
    }

    private fun initView() {
        btn_only_input.setOnClickListener {
            onlyInput("书", 22.889, 1)
        }
//        onlyInput("书",null,2)

    }

    /**
     * 只有输入参数
     */
    private fun onlyInput(shop: String, price: Double?, quantity: Int) {
        tv_only_input.setText(if (controlOnlyInput) "$shop ${price?.toString() ?: -1} 钱 $quantity 本" else
            "controlOnlyInput : $controlOnlyInput"
        )
        !controlOnlyInput
    }



}

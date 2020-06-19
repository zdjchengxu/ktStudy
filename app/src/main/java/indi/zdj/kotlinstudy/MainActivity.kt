package indi.zdj.kotlinstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import indi.zdj.kotlinstudy.activity.BasicDataTypeActivity
import indi.zdj.kotlinstudy.activity.ClassAndObjectActivity
import indi.zdj.kotlinstudy.activity.ControlAndFunctionActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {
        btn_intent_basic_data_type.setOnClickListener {
            var intent = Intent()
            intent.setClass(this, BasicDataTypeActivity::class.java)
            startActivity(intent)
        }

        btn_intent_control_and_function.setOnClickListener {
            var intent = Intent()
            intent.setClass(this,ControlAndFunctionActivity::class.java)
            startActivity(intent)
        }

        btn_intent_class_and_object.setOnClickListener {
            var intent = Intent()
            intent.setClass(this,ClassAndObjectActivity::class.java)
            startActivity(intent)
        }
    }
}

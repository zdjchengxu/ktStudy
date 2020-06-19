package indi.zdj.kotlinstudy.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import indi.zdj.kotlinstudy.R
import indi.zdj.kotlinstudy.entity.TestInitEntity
import kotlinx.android.synthetic.main.activity_basic_data_type.*

import kotlinx.android.synthetic.main.activity_class.*
import kotlinx.android.synthetic.main.activity_class.fab
import kotlinx.android.synthetic.main.activity_class.toolbar

/**
 * 第5章 类和对象
 */
class ClassAndObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.setTitle("类和对象")

        TestInitEntity()
    }

}

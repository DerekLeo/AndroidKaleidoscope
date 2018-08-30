package com.saturn.subassembly

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.saturn.subassembly.simple_lifecycle.SimpleLifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tag: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        setView()
    }

    private fun setView() {
        bt_simple_lifecycle.setOnClickListener {
            startActivity(Intent(this, SimpleLifecycleActivity::class.java))
        }
    }

}

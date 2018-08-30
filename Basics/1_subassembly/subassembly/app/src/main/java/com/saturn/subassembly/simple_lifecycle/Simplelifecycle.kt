package com.saturn.subassembly.simple_lifecycle

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View
import com.saturn.subassembly.R
import com.saturn.subassembly.base.BaseActivity
import kotlinx.android.synthetic.main.activity_simple_lifecycle.*

/**
 * 描述
 * @Author: Derek.Li
 * @Maintainer: Derek.Li
 * @Date: 2018/8/31
 * @Copyright: 2018 www.saturn.com All rights reserved.
 */

abstract class BaseSimpleLifecycleActivity<T : Activity> : BaseActivity() {

    override val baseTag = "SimpleLifecycle"

    abstract val nextActivity: Class<T>?

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContextLayout())
    }

    @LayoutRes
    private fun getContextLayout(): Int = R.layout.activity_simple_lifecycle

    @SuppressLint("SetTextI18n")
    final override fun setNextActivity() {
        bt_next.visibility = View.INVISIBLE
        if (null != nextActivity) {
            bt_next.visibility = View.VISIBLE
            bt_next.setOnClickListener {
                startNextActivity()
            }
            bt_next.text = "${getString(R.string.next_activity)} is ${nextActivity!!::class.java.simpleName}"
        }
    }

    open fun startNextActivity() {
        startActivity(Intent(this, nextActivity))
    }

    final override fun setLastActivity() {
        bt_last.visibility = View.VISIBLE
        bt_last.setOnClickListener {
            finish()
        }
    }

}

class SimpleLifecycleActivity : BaseSimpleLifecycleActivity<FirstActivity>() {

    override val tag: String = SimpleLifecycleActivity::class.java.simpleName

    override val nextActivity = FirstActivity::class.java

    override val openLog: Boolean = false

}


class FirstActivity : BaseSimpleLifecycleActivity<SecondActivity>() {

    override val tag: String = FirstActivity::class.java.simpleName

    override val nextActivity = SecondActivity::class.java

}

class SecondActivity : BaseSimpleLifecycleActivity<ThirdActivity>() {

    override val tag: String = SecondActivity::class.java.simpleName

    override val nextActivity = ThirdActivity::class.java

}

class ThirdActivity : BaseSimpleLifecycleActivity<Activity>() {

    override val tag: String = ThirdActivity::class.java.simpleName

    override val nextActivity: Class<Activity>? = null

}
package com.saturn.subassembly.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.saturn.subassembly.R
import com.saturn.subassembly.util.*

/**
 * 描述
 * @Author: Derek.Li
 * @Maintainer: Derek.Li
 * @Date: 2018/8/31
 * @Copyright: 2018 www.saturn.com All rights reserved.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract val baseTag: String

    abstract val tag: String

    open val openLog: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        if (openLog)
            logOnCreate("$baseTag-$tag")
        super.onCreate(savedInstanceState)
    }

    override fun onRestart() {
        if (openLog)
            logOnRestart(tag)
        super.onRestart()
    }

    override fun onStart() {
        if (openLog)
            logOnStart(tag)
        super.onStart()
        setText()
        setNextActivity()
        setLastActivity()
    }

    abstract fun setLastActivity()

    abstract fun setNextActivity()

    open fun setText() {
        findViewById<TextView>(R.id.tv_display).text = tag
    }

    override fun onResume() {
        if (openLog)
            logOnResume(tag)
        super.onResume()
    }

    override fun onPause() {
        if (openLog)
            logOnPause(tag)
        super.onPause()
    }

    override fun onStop() {
        if (openLog)
            logOnStop(tag)
        super.onStop()
    }

    override fun onDestroy() {
        if (openLog)
            logOnDestroy(tag)
        super.onDestroy()
    }
}


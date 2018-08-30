package com.saturn.subassembly.util

import com.orhanobut.logger.Logger

/**
 * 描述
 * @Author: Derek.Li
 * @Maintainer: Derek.Li
 * @Date: 2018/8/30
 * @Copyright: 2018 www.saturn.com All rights reserved.
 */


fun logOnCreate(tag: String) = log(tag, "onCreate")

fun logOnStart(tag: String) = log(tag, "onStart")

fun logOnRestart(tag: String) = log(tag, "onRestart")

fun logOnResume(tag: String) = log(tag, "onResume")

fun logOnPause(tag: String) = log(tag, "onPause")

fun logOnStop(tag: String) = log(tag, "onStop")

fun logOnDestroy(tag: String) = log(tag, "onDestroy")

fun log(tag: String, msg: String) = Logger.t(tag).d(msg)
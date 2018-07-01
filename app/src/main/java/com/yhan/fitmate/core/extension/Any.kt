package com.yhan.fitmate.core.extension

import android.util.Log


fun Any.debug(message: String) = Log.d( this::class.java.simpleName, message)
fun Any.error(message: String) = Log.e( this::class.java.simpleName, message)
fun Any.warn(message: String) = Log.w( this::class.java.simpleName, message)
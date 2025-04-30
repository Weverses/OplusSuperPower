package com.tlsu.opluspro.hook

abstract class BaseHook {
    var isInit: Boolean = false
    abstract fun init()
}

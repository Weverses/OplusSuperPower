package com.tlsu.opluspro.hook.systemui

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.tlsu.opluspro.hook.BaseHook
import de.robv.android.xposed.XposedBridge

object OplusSuperSaveController : BaseHook() {
    override fun init() {
        try {
            loadClass("com.oplus.systemui.statusbar.notification.power.supersave.OplusSuperSaveControllerImpl")
                .methodFinder()
                .filterByName("autoEnterOrExitSuperSave")
                .single()
                .createHook {
                    before { param ->
                        param.args[0] = 3
                        param.args[1] = true
                    }
                    XposedBridge.log("OplusTest: hook autoEnterOrExitSuperSave successfully")
                }
        } catch (e: Throwable) {
            XposedBridge.log("OplusTest: hook autoEnterOrExitSuperSave failed!")
            XposedBridge.log(e)
        }
    }
}
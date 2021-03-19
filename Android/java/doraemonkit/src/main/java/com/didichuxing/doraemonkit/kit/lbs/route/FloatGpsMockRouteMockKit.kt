package com.didichuxing.doraemonkit.kit.lbs.route

import android.content.Context
import com.blankj.utilcode.util.ToastUtils
import com.didichuxing.doraemonkit.R
import com.didichuxing.doraemonkit.aop.DokitPluginConfig
import com.didichuxing.doraemonkit.kit.AbstractKit
import com.didichuxing.doraemonkit.kit.core.SimpleDokitStarter.startFloating
import com.didichuxing.doraemonkit.util.DokitUtil

/**
 * Created by changzuozhen on 2021年1月22日
 */
class FloatGpsMockRouteMockKit : AbstractKit() {
    override val name: Int
        get() = R.string.dk_kit_gps_mock_route
    override val icon: Int
        get() = R.mipmap.dk_mock_location_route

    override fun onClick(context: Context?) {
        if (!DokitPluginConfig.SWITCH_DOKIT_PLUGIN) {
            ToastUtils.showShort(DokitUtil.getString(R.string.dk_plugin_close_tip))
            return
        }
        if (!DokitPluginConfig.SWITCH_GPS) {
            ToastUtils.showShort(DokitUtil.getString(R.string.dk_plugin_gps_close_tip))
            return
        }
        startFloating(RouteKitView::class.java)
    }

    override fun onAppInit(context: Context?) {}
    override val isInnerKit: Boolean
        get() = true

    override fun innerKitId(): String {
        return "dokit_sdk_lbs_ck_route"
    }
}
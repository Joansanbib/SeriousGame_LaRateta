package com.la_rateta.game.android

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.la_rateta.game.main_class
import kotlin.properties.Delegates

/** Launches the Android application.  */
var height_screen by Delegates.notNull<Int>()
var width_screen by Delegates.notNull<Int>()


class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        height_screen = displayMetrics.heightPixels
        width_screen = displayMetrics.widthPixels

        val configuration = AndroidApplicationConfiguration()
        configuration.useCompass = false
        configuration.useAccelerometer = false


        configuration.useImmersiveMode = true // Recommended, but not required.
        initialize(main_class(), configuration)
    }

}

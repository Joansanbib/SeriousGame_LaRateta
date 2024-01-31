package com.la_rateta.game.ios

import com.badlogic.gdx.backends.iosrobovm.IOSApplication
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration
import com.la_rateta.game.main_class
import org.robovm.apple.foundation.NSAutoreleasePool
import org.robovm.apple.uikit.UIApplication

/** Launches the iOS (RoboVM) application.  */
class IOSLauncher : IOSApplication.Delegate() {
    override fun createApplication(): IOSApplication {
        val configuration = IOSApplicationConfiguration()
        return IOSApplication(main_class(), configuration)
    }

    companion object {
        @JvmStatic
        fun main(argv: Array<String>) {
            val pool = NSAutoreleasePool()
            UIApplication.main<UIApplication, IOSLauncher>(argv, null, IOSLauncher::class.java)
            pool.close()
        }
    }
}

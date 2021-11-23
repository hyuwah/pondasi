package dev.hyuwah.pondasi.base

import android.app.Application
import dev.marcelpinto.permissionktx.Permission

abstract class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
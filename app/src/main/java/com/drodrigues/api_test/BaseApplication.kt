package com.drodrigues.tvdome

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.drodrigues.tvdome.framework.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

internal class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            androidLogger(Level.DEBUG)

            modules(
                listOf(applicationModule)
            )
        }
    }

    fun getLifecycleOwner(): LifecycleOwner {
        return ProcessLifecycleOwner.get()
    }
}
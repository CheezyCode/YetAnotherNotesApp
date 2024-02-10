package com.cheezycode.notesample

import android.app.Application
import com.cheezycode.notesample.di.APP_MODULE
import com.cheezycode.notesample.di.NETWORK_MODULE
import com.cheezycode.notesample.di.REPO_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NoteApplication)
            modules(NETWORK_MODULE, REPO_MODULE, APP_MODULE)
        }
    }
}
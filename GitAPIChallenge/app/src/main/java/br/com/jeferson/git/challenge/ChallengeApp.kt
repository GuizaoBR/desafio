package br.com.jeferson.git.challenge

import android.app.Application
import br.com.jeferson.git.challenge.dependecyinjection.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChallengeApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChallengeApp)
            modules(koinModules)

        }
    }
}
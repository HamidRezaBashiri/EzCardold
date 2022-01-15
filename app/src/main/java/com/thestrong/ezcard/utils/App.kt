package com.thestrong.ezcard.utils

import android.app.Application
import com.thestrong.ezcard.data.db.RoomBuilder
import com.thestrong.ezcard.data.repository.login.LoginUser
import com.thestrong.ezcard.data.repository.login.LoginUserImpl
import com.thestrong.ezcard.ui.screens.authentication.AuthenticationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        val moduleEzCard = module {
           single {RoomBuilder.getInstance(this@App)}
           factory <LoginUser>{LoginUserImpl(get())}
           viewModel{ AuthenticationViewModel(get()) }
        }
        startKoin{
            androidContext(this@App)
            modules(moduleEzCard)
        }
    }
}
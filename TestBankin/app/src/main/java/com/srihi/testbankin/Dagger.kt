package com.srihi.testbankin

import android.app.Application

lateinit var dagger: DaggerComponent

fun initAppDagger(application: Application) {
    dagger = DaggerDaggerComponent.builder()
        .appModule(AppModule(application))
        .build()
}
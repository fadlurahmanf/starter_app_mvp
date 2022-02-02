//package com.fadlurahmanf.starter_app_mvp.di.module
//
//import com.fadlurahmanf.starter_app_mvp.example.ExampleActivity1
//import com.fadlurahmanf.starter_app_mvp.example.ExampleActivity1Contract
//import com.fadlurahmanf.starter_app_mvp.example.ExampleActivity1Presenter
//import com.fadlurahmanf.starter_app_mvp.data.entity.example.PostEntity
//import dagger.Module
//import dagger.Provides
//
//@Module
//class ExamplePresenterModule {
//    @Provides
//    fun providesExamplePresenter(view:ExampleActivity1, postEntity: PostEntity):ExampleActivity1Contract.Presenter = ExampleActivity1Presenter(view, postEntity)
//}
//package com.fadlurahmanf.starter_app_mvp.example
//
//
//import com.fadlurahmanf.starter_app_mvp.data.entity.example.TestimonialEntity
//import com.fadlurahmanf.starter_app_mvp.ui.example.ExampleActivity1Contract
//import com.fadlurahmanf.starter_app_mvp.ui.example.ExampleActivity1Presenter
//import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
//import io.reactivex.rxjava3.core.Observable
//import io.reactivex.rxjava3.plugins.RxJavaPlugins
//import io.reactivex.rxjava3.schedulers.Schedulers
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.junit.jupiter.api.extension.Extensions
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import org.mockito.junit.jupiter.MockitoExtension
//import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness


//@Extensions(value = [
//    ExtendWith(MockitoExtension::class)
//])
//@MockitoSettings(strictness = Strictness.LENIENT)
//class ExampleActivity1PresenterTest {
//
//    @Mock
//    lateinit var postEntity: TestimonialEntity
//
//    @Mock
//    lateinit var view: ExampleActivity1Contract.View
//
//    private lateinit var presenter: ExampleActivity1Presenter
//
//    @BeforeEach
//    fun beforeEach(){
//        MockitoAnnotations.initMocks(this)
//        presenter = ExampleActivity1Presenter(postEntity)
//
//        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
//    }
//
//    @Test
//    fun getAllPostSuccess(){
//        var list = arrayListOf(PostResponse(title = "", userId = 0, body = ""))
//        Mockito.`when`(postEntity.getAllPost()).thenReturn(Observable.just(list))
//
//        presenter.getAllPost()
//        Mockito.verify(postEntity, Mockito.times(1)).getAllPost()
//
//    }
//
//    @Test
//    fun getAllPostFailed(){
//        presenter.view = view
//        presenter.setExampleViewError()
//        Mockito.verify(view, Mockito.times(1)).exampleViewError(message = "ERROR")
//    }
//}
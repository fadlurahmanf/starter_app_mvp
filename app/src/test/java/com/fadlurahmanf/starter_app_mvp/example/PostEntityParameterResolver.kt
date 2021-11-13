package com.fadlurahmanf.starter_app_mvp.example

//import com.fadlurahmanf.starter_app_mvp.example.dummyEntity.PostEntity
//import org.junit.jupiter.api.extension.ExtensionContext
//import org.junit.jupiter.api.extension.ParameterContext
//import org.junit.jupiter.api.extension.ParameterResolver
//
//class PostEntityParameterResolver: ParameterResolver {
//
//    private val postEntity:PostEntity = PostEntity()
//
//    override fun supportsParameter(
//        parameterContext: ParameterContext?,
//        extensionContext: ExtensionContext?
//    ): Boolean {
//        return parameterContext?.parameter?.type == PostEntity::class.java
//    }
//
//    override fun resolveParameter(
//        parameterContext: ParameterContext?,
//        extensionContext: ExtensionContext?
//    ): Any {
//        return postEntity
//    }
//}
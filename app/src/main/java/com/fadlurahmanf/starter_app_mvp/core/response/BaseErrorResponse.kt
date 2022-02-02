package com.fadlurahmanf.starter_app_mvp.core.response

import java.io.IOException
import java.lang.Exception

class BaseErrorResponse(var messageText:String, var codeText:Int?=null) : IOException(){
    override val message: String
        get() = messageText
    var code:Int?=null
        get() = codeText
}

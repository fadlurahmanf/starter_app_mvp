package com.fadlurahmanf.starter_app_mvp.data.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.fadlurahmanf.starter_app_mvp.core.response.BaseErrorResponse
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ConnectivityInterceptor @Inject constructor(
    private var context: Context
):Interceptor {

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isConnectedInternet():Boolean{
        val cm:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var capabilities = cm.getNetworkCapabilities(cm.activeNetwork)
        return (capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true
                || capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
                || capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) == true)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnectedInternet()){
            throw BaseErrorResponse(messageText = "No Network Available", codeText = 404)
        }else{
            return chain.proceed(chain.request())
        }
    }
}
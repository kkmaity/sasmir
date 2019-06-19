package com.netflairs.sasmirapp.restService

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestService {
    var restInterface: RestInterface

    internal var defaultHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val authorisedRequest = chain.request().newBuilder()
                /*.header("Authorization", "Basic "+ Constant.BASIC_AUTH_CREDIENTIAL)*/.build()
            chain.proceed(authorisedRequest)
        }.build()

    init {
        /*     OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(httpLoggingInterceptor);
        }*/
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
        /* OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();*/


        restInterface = Retrofit.Builder()
            .baseUrl(RestInterface.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestInterface::class.java)
    }

    companion object {

        private var restService: RestService? = null

        val instance: RestService
            get() {
                if (restService == null) {
                    restService = RestService()
                }

                return restService!!
            }
    }
}

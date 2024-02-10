package com.cheezycode.notesample.di

import com.cheezycode.notesample.api.AuthInterceptor
import com.cheezycode.notesample.api.NoteAPI
import com.cheezycode.notesample.api.UserAPI
import com.cheezycode.notesample.utils.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NETWORK_MODULE = module {

    single { providesRetrofit() }
    single { provideOkHttpClient(get()) }
    single { providesUserAPI(get()) }
    single { providesNoteAPI(get(), get()) }
}


fun providesRetrofit(): Retrofit.Builder {
    return Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
}

fun provideOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

fun providesUserAPI(retrofitBuilder: Retrofit.Builder): UserAPI {
    return retrofitBuilder.build().create(UserAPI::class.java)
}


fun providesNoteAPI(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): NoteAPI {
    return retrofitBuilder.client(okHttpClient).build().create(NoteAPI::class.java)
}



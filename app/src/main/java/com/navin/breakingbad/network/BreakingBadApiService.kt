package com.example.breakingbad.network

import com.example.breakingbad.model.BreakingBadCharacter
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class RetrofitService private constructor(){

    companion object{
        private var instance : RetrofitService?= null
        fun getInstance(): RetrofitService
        {
            if(instance == null)
                instance= RetrofitService()
            return instance!!
        }
    }
    fun getBreakingBadService () : BreakingBadService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(BreakingBadService::class.java)
    }


}



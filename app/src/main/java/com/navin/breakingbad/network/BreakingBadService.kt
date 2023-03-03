package com.example.breakingbad.network

import com.example.breakingbad.model.BreakingBadCharacter
import com.example.breakingbad.model.CharacterQuote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadService {
    @GET("characters")
     suspend fun getCharactersList(): List<BreakingBadCharacter>

     @GET("quote")
    suspend fun getCharacterQuotes(@Query("author") author: String): List<CharacterQuote>
}
package com.example.breakingbad.repository

import com.example.breakingbad.model.BreakingBadCharacter
import com.example.breakingbad.model.CharacterQuote
import com.example.breakingbad.network.BreakingBadService
import com.example.breakingbad.network.RetrofitService


class CharactersRepository private constructor(
    private val charactersService: BreakingBadService = RetrofitService.getInstance()
        .getBreakingBadService()
) {

    companion object {
        val instance = CharactersRepository()
    }

    suspend fun getCharacters(): List<BreakingBadCharacter> {
//        val localCharacters = characterDb.getCharacterList()
//        if (localCharacters != null) {
//            return localCharacters
//        }

        val remoteCharacters = charactersService.getCharactersList()
//        charactersDb.save(remoteCharacters)
        return remoteCharacters
    }



    suspend fun getCharacterQuotes(name: String): List<CharacterQuote> {
        return charactersService.getCharacterQuotes(name)
    }

}




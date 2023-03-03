package com.example.breakingbad.ui.charcter.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.CharacterQuote
import com.example.breakingbad.repository.CharactersRepository
import com.example.breakingbadarchive.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class CharacterDetailViewModel : ViewModel() {

    private val repository: CharactersRepository = CharactersRepository.instance


    private val _selectedCharacter = MutableLiveData<List<CharacterQuote>>()
    val selectedCharacter: LiveData<List<CharacterQuote>> = _selectedCharacter

    val status = SingleLiveEvent<String>()

    fun loadCharactersDetail(name: String) {
        viewModelScope.launch {
            try {
                _selectedCharacter.value = repository.getCharacterQuotes(name)
                status.value = SUCCESS_RESPONSE
            } catch (exception: Exception) {
                status.value = FAILED_RESPONSE

            }
        }
    }

//    fun onItemClicked(characterName: String) {
//        val character = _selectedCharacter.value?.firstOrNull { it.name == characterName } ?: return
//        _selectedCharacter.value = character
//    }

    companion object {
        const val SUCCESS_RESPONSE = "SUCCESS_RESPONSE"
        const val FAILED_RESPONSE = "FAIL"
    }

}
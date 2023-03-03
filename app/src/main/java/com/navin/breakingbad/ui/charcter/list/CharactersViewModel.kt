package com.example.breakingbad.ui.charcter.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.BreakingBadCharacter
import com.example.breakingbad.repository.CharactersRepository
import com.example.breakingbadarchive.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val repository: CharactersRepository = CharactersRepository.instance

    private val _characters = MutableLiveData<List<BreakingBadCharacter>>()
    val characters: LiveData<List<BreakingBadCharacter>> = _characters

    private val _selectedCharacter = SingleLiveEvent<BreakingBadCharacter>()
    val selectedCharacter: LiveData<BreakingBadCharacter> = _selectedCharacter

    val status = SingleLiveEvent<String>()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                _characters.value = repository.getCharacters()
                status.value = SUCCESS_RESPONSE
            } catch (exception: Exception) {
                status.value = FAILED_RESPONSE

            }
        }
    }

    fun onItemClicked(characterName: String) {
        val character = _characters.value?.firstOrNull { it.name == characterName } ?: return
        _selectedCharacter.value = character
    }

    companion object {
        const val SUCCESS_RESPONSE = "SUCCESS_RESPONSE"
        const val FAILED_RESPONSE = "FAIL"
    }
}

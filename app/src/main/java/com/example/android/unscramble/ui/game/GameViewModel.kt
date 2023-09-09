package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = MutableLiveData(0)
    private  var _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount
    private val _currentScrambleWord : MutableLiveData<String>()
        val currentScrambledWord: LiveData<String>
        get() = _currentScrambleWord
    private var wordsList: MutableList<String> = mutableListOf()
    private  lateinit var currentWord: String
    val score: LiveData<Int>
        get() = _score

    init {
        Log.d("GameFragment", "Fragment Terbuat")
        getNextWord()
    }

    private fun increaseScore() {
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentScrambledWord.value, true)) {
            increaseScore()
            return true
        }
        return false
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }


    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambleWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }

    }
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }


    fun nextWord(): Boolean {
        return if (_currentWordCount.value !! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }




}
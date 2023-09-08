package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    private  var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount
    private lateinit var _currentScrambleWord : String
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    val score: Int
        get() = _score

    init {
        Log.d("GameFragment", "Fragment Terbuat")
        getNextWord()
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    val currentScrambleWord: String
     get() = _currentScrambleWord

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambleWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }

    }

    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }




}
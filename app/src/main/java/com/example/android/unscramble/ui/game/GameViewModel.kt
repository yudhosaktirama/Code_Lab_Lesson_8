package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    private  var _currentWordCount = 0
    private var _currentScrambleWord = "test"

    init {
        Log.d("GameFragment", "Fragment Terbuat")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    val currentScrambleWord: String
     get() = _currentScrambleWord

}
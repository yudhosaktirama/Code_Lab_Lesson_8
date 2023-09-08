package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    private  var _currentWordCount = 0
    private var _currentScrambleWord = "test"

    val currentScrambleWord: String
     get() = _currentScrambleWord

}
package com.example.guessword.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.guessword.R
import com.example.guessword.databinding.GameFragmentBinding

class GameFragment: Fragment() {
    // 현재 단어
    private var word = ""

    // 현재 스코어
    private var score = 0

    // 단어 배열
    private lateinit var wordList: MutableList<String>
    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater, R.layout.game_fragment, container, false
        )

        resetList()
        nextWord()

        binding.correctButton.setOnClickListener { onCorrect()}
        binding.skipButton.setOnClickListener { onSkip()}
        updateScoreText()
        updateWordText()
        return binding.root
    }
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        var i : Int= score
        val action = GameFragmentDirections.actionGameToScore(i)
     //   findNavController().navigate(GameFragmentDirections.actionGameToScore(score))
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            gameFinished()
        } else {
            word = wordList.removeAt(0)
        }
        updateWordText()
        updateScoreText()
    }

    /** Methods for buttons presses **/

    private fun onSkip() {
        score--
        nextWord()
    }

    private fun onCorrect() {
        score++
        nextWord()
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = word

    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }
}
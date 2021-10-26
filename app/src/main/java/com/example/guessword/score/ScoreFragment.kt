package com.example.guessword.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.guessword.R
import com.example.guessword.databinding.ScoreFragmentBinding

class ScoreFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(
            inflater, R.layout.score_fragment, container, false
        )

        // Get args using by navArgs property delegate
       // val args : scoreFragmentArgs by navArgs<scoreFragmentArgs>()
        val scoreFragmentArgs2 = ScoreFragmentArgs.fromBundle(arguments)
        binding.scoreText.text = scoreFragmentArgs2.score.toString()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
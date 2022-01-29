package com.heyoh.lyricsovhapp.main.lyrics

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.heyoh.lyricsovhapp.base.BaseFragment
import com.heyoh.lyricsovhapp.databinding.FragmentLyricsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LyricsFragment: BaseFragment<FragmentLyricsBinding>() {

    override fun getViewBinding() =  FragmentLyricsBinding.inflate(layoutInflater)
    private val viewModel: LyricsViewModel by viewModels()
    private val args: LyricsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lyricsTextView.movementMethod = ScrollingMovementMethod()

        initObservable()

        binding.nameSongTextView.text = args.suggestedSong.songName

        binding.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getLyricsSong(args.suggestedSong)
    }

    private fun initObservable() {
        viewModel.model.observe(viewLifecycleOwner, Observer(::lyricsResult))
    }

    private fun lyricsResult(model: LyricsModel){
        if (model is LyricsModel.Success) {
            binding.lyricsTextView.text = model.lyricsContent.content
            binding.errorMessageTextView.isVisible = false
        }else{
            binding.errorMessageTextView.isVisible = true
        }
    }

}
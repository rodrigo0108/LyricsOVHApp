package com.heyoh.lyricsovhapp.main.suggestedSong

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.heyoh.lyricsovhapp.R
import com.heyoh.lyricsovhapp.base.BaseFragment
import com.heyoh.lyricsovhapp.databinding.FragmentSearchBinding
import com.heyoh.lyricsovhapp.main.adapter.SuggestedSongAdapter
import com.heyoh.models.SuggestedSong
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
    private val viewModel: SearchViewModel by viewModels()
    private val suggestedSongAdapter by lazy { SuggestedSongAdapter(::onSuggestedSongClicked) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.suggestedSongRecyclerView.adapter = suggestedSongAdapter

        val searchTextView: TextView? =
            binding.searchView.findViewById(androidx.appcompat.R.id.search_src_text)

        searchTextView?.let {
            it.typeface = ResourcesCompat.getFont(requireContext(), R.font.mark_pro)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.getSuggestedSongs(it)
                }
                return true
            }
        })

        initObservable()

    }

    private fun onSuggestedSongClicked(suggestedSong: SuggestedSong) {
        findNavController().navigate(SearchFragmentDirections.goToLyricsFragment(suggestedSong))
    }

    private fun initObservable() {
        viewModel.model.observe(viewLifecycleOwner, Observer(::searchResult))
    }


    private fun searchResult(model: SearchModel) {
        if (model is SearchModel.Success) {
            suggestedSongAdapter.list = model.listSongs
        }
    }
}
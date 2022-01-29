package com.heyoh.lyricsovhapp.main

import com.heyoh.lyricsovhapp.base.BaseActivity
import com.heyoh.lyricsovhapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

}
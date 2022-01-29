package com.heyoh.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SuggestedSong(
    val id: String,
    val songName: String,
    val imageURL: String,
    val artistName: String
): Parcelable
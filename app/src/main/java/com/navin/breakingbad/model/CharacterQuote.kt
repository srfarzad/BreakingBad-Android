package com.example.breakingbad.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterQuote (
    @SerializedName("quote_id")
    val quote_id : Int,
    @SerializedName("quote")
    val quote : String,
    @SerializedName("author")
    val author : String,
    @SerializedName("series")
    val series :String,
) : Parcelable

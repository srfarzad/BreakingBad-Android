package com.example.breakingbad.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreakingBadCharacter(
    @SerializedName("name")
    val name : String,
    @SerializedName("img")
    val pictureUrl : String,
    @SerializedName("status")
    val status : String,
    @SerializedName("occupation")
    var occupation: List<String>,
    @SerializedName("nickname")
    var nickname : String ,
    @SerializedName("appearance")
    var appearance : List<Int> ,
    @SerializedName("portrayed")
    var portrayed : String ,


) : Parcelable
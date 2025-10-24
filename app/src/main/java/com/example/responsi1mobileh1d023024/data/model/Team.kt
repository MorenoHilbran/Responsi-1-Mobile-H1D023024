package com.example.responsi1mobileh1d023024.data.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("crest")
    val crest: String,

    @SerializedName("coach")
    val coach: Coach,

    @SerializedName("squad")
    val squad: List<Player>
)

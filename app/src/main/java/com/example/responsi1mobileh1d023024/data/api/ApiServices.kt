package com.example.responsi1mobileh1d023024.data.api
import com.example.responsi1mobileh1d023024.data.model.Team
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
    interface ApiService {
        @Headers("X-Auth-Token: 85288e18b2b041f394f00132d9afedeb")
        @GET("teams/{id}")
        suspend fun getTeam(@Path("id") id: Int): Team
    }
package com.example.poke_app

import retrofit2.Call
import retrofit2.http.GET

interface IRetrofitCliente {

    @GET("v2/pokemon")
    fun getPoke(): Call<Response>
}
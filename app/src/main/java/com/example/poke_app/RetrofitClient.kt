package com.example.poke_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var retrofit: Retrofit
        private val baseUrl = "https://pokeapi.co/api/"

        fun getRetrofitInstance(): Retrofit {
            if (!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        val POKE_SERVICE: IRetrofitCliente by lazy {
            getRetrofitInstance().create(IRetrofitCliente::class.java)
        }

    }
}
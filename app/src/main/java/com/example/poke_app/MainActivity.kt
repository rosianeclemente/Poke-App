package com.example.poke_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_app.RetrofitClient.Companion.POKE_SERVICE
import com.example.poke_app.databinding.ActivityItemBinding
import com.example.poke_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val pokemonAdapter by lazy {
        Adapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPookemin()
        binding.RecyclerView.adapter = pokemonAdapter

    }
    fun getPookemin(){
        val call: Call<Response> = POKE_SERVICE.getPoke()
        call.enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val poke = response.body()
                    getPokemonList(poke)

            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                val poke = t.message

            }

        })
    }
    private fun getPokemonList(pokemon: Response?){
        POKE_SERVICE.getPoke()
        pokemon?.results?.let {
            setPokemonList(it)
        }

    }
    private fun setPokemonList(list: List<Pokemon>){
        pokemonAdapter.submitList(list)
    }

}
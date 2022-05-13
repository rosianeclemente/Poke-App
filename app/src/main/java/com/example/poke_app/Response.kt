package com.example.poke_app

data class Response(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>
)
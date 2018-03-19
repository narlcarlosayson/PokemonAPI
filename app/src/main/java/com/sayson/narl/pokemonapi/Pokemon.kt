package com.sayson.narl.pokemonapi

/**
 * Created by Lran on 3/8/2018.
 */
data class Pokemon (
        val id: Int,
        val name: String,
        val sprites: Sprites
)
data class Sprites(
        val front_default: String
)
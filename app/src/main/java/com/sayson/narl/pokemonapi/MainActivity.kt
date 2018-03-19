package com.sayson.narl.pokemonapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var pokemonList = ArrayList<Pokemon>()
    private val url = "https://pokeapi.co/api/v2/pokemon/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView_pokemon.layoutManager = LinearLayoutManager(this)
        for (i in 1..10) {
            doAsync {
                val resultJson = URL(url + i).readText()
                uiThread {
                    val jsonObj = JSONObject(resultJson)

                    val id = jsonObj.getInt("id")
                    val pname = jsonObj.getString("name")
                    val sprites = jsonObj.getString("sprites")
                    val jsonObj2 = JSONObject(sprites)
                    val front_default = jsonObj2.getString("front_default")

                    pokemonList.add(Pokemon(id, pname, Sprites(front_default)))

                    recyclerView_pokemon.adapter = PokemonAdapter(pokemonList)
                    if (pokemonList.size != 0) {
                        textPokemon.text = "You have " + pokemonList.size.toString() + " Pokemons"

                    }
                    if (pokemonList.size == 20) {
                        progressBar.visibility = GONE
                    }
                }
            }
        }
    }
}

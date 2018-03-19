package com.sayson.narl.pokemonapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon.view.*

import javax.xml.transform.Templates

/**
 * Created by Lran on 3/8/2018.
 */
class PokemonAdapter(val lPokemonList: ArrayList<Pokemon>): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return lPokemonList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.pokemon, parent, false)
        return CustomViewHolder(cellForRow)  }



    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val pokemon: Pokemon = lPokemonList[position]
        holder?.view?.pkmn_name?.text = pokemon.name
        val pokemonImage = holder?.view?.pkmn_image
        Picasso.with(holder?.view?.context).load(pokemon.sprites.front_default).into(pokemonImage)
    }

}

class CustomViewHolder (val view:View): RecyclerView.ViewHolder(view){

}

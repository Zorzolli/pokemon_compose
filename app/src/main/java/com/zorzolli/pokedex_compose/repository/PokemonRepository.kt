package com.zorzolli.pokedex_compose.repository

import com.zorzolli.pokedex_compose.data.remote.PokeApi
import com.zorzolli.pokedex_compose.data.remote.responses.Pokemon
import com.zorzolli.pokedex_compose.data.remote.responses.PokemonList
import com.zorzolli.pokedex_compose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offSet: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offSet)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}
package com.zorzolli.pokedex_compose.pokemondetail

import androidx.lifecycle.ViewModel
import com.zorzolli.pokedex_compose.data.remote.responses.Pokemon
import com.zorzolli.pokedex_compose.repository.PokemonRepository
import com.zorzolli.pokedex_compose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}
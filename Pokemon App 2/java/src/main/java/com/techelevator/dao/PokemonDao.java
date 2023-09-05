package com.techelevator.dao;

import com.techelevator.model.PokemonDto;

public interface PokemonDao {

    void savePokemon(PokemonDto dto);
}

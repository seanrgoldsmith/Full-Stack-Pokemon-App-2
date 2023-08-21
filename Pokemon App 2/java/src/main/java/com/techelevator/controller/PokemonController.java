package com.techelevator.controller;

import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import com.techelevator.service.PokeAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    PokeAPIService service;

    @RequestMapping(path="/pokemon", method= RequestMethod.GET)
    public List<Pokemon> getAllPokemon() {
        return service.getPokemon();
    }

    @GetMapping("pokemon/{id}")
    public PokemonDetail getPokemonDetailById(@PathVariable int id) {
        return service.getPokemonDetailById(id);
    }
}

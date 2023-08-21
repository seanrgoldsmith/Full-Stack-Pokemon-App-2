package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestPokeAPIService implements PokeAPIService{

    RestTemplate rt = new RestTemplate();

    private final String API_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    public List<Pokemon> getPokemon() {
        String response = rt.getForObject(API_URL, String.class);
        System.out.println(response); //remove later
        ObjectMapper mapper = new ObjectMapper();
        List<Pokemon> pokemonList = new ArrayList<>();

        try {
            JsonNode jsonNode = mapper.readTree(response);
            JsonNode root = jsonNode.path("results");
            for (int i = 0; i < root.size(); i++) {
                String name = root.path(i).path("name").asText();
                String url = root.path(i).path("url").asText();
                int pokemonIndex = url.indexOf("pokemon");
                String pokemonString = url.substring(pokemonIndex);
                int slashIndex = pokemonString.indexOf("/");
                String number = pokemonString.substring(slashIndex + 1, pokemonString.length() - 1);
                int id = Integer.parseInt(number);

                Pokemon temp = new Pokemon();
                temp.setId(id);
                temp.setName(name);
                temp.setUrl(url);
                pokemonList.add(temp);

            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }

    @Override
    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = rt.getForObject(API_URL + id, PokemonDetail.class);
        return pokemonDetail;
    }
}

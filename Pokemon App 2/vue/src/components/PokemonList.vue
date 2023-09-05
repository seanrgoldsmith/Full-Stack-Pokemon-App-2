<template>
  <div>
    <ul>
        <li v-for="pokemon in pokemonArray" v-bind:key="pokemon.id">
            <router-link v-bind:to= " {
                name: 'detail',
                params: {
                    id: pokemon.id,
                    name: pokemon.name
                    }
                }">
                {{pokemon.name}}
            </router-link>
        </li>
    </ul>
    <button @click="getPreviousPokemon" v-if="$store.state.startingVal != 0">Previous</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button @click="getNextPokemon">Next</button>
  </div>
</template>

<script>
import pokemonService from '../services/PokemonService.js'
export default {
    data() {
        return {
            pokemonArray: [],
        }
    },
        methods: {
        getNextPokemon() {
            let start = this.$store.state.startingVal;
            let end = this.$store.state.endingVal;
            start += 20;
            end += 20;
            pokemonService.getNextPreviousPokemon(start, end)
            .then (response => {
                this.pokemonArray = response.data;
                let values = {
                    startingVal: start,
                    endingVal: end
                };
                this.$store.commit("GET_NEXT_PREVIOUS", values)
            })
        },
          getPreviousPokemon() {
            let start = this.$store.state.startingVal;
            let end = this.$store.state.endingVal;
            start -= 20;
            end -= 20;
            pokemonService.getNextPreviousPokemon(start, end)
            .then (response => {
                this.pokemonArray = response.data;
                let values = {
                    startingVal: start,
                    endingVal: end
                };
                this.$store.commit("GET_NEXT_PREVIOUS", values)
            })
        }    
    },
    created() {
        pokemonService.getAllPokemon()
        .then(response => {
                this.pokemonArray = response.data;
            })
    },

}
</script>

<style>
ul > li {
    list-style-type: none;
}
</style>
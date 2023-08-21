<template>
  <div>
    <h2>{{pokemon.name}}</h2>
    <p>Height: {{pokemon.height}}</p>
    <p>Weight: {{pokemon.weight}}</p>
    <img v-bind:src="spriteImageFront" />
    <img v-bind:src="spriteImageBack" />

  </div>
</template>

<script>
import pokemonService from '../services/PokemonService';
export default {
    name: 'pokemon-detail',
    props: {
        id: Number, 
        String,
    },
    data() {
        return {
            pokemon: {},
            spriteImageFront: "",
            spriteImageBack: "",
        }
    },
    created() {
        pokemonService.getPokemonById(this.id)
        .then(response => {
            this.pokemon = response.data;
            this.spriteImageFront = response.data.sprites.front_default;
            this.spriteImageBack = response.data.sprites.back_default;
        })
    }
}
</script>

<style>

</style>
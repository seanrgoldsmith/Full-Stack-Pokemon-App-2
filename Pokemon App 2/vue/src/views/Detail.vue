<template>
  <div>
    <pokemon-detail v-bind:id="$route.params.id" 
    :name="$route.params.name"/>
  </div>
</template>

<script>
import PokemonDetail from '../components/PokemonDetail.vue'
export default {
    name: 'detail',
    components: { PokemonDetail },
}
</script>

<style>

</style>
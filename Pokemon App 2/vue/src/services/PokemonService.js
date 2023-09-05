import axios from "axios";

const http = axios.create( {
    baseURL: 'http://localhost:9000'
})

export default {
    getAllPokemon() {
        return http.get('/pokemon');
    },
    getPokemonById(id) {
        return http.get(`/pokemon/${id}`);
    },
    saveFavorite(pokemon) {
        return http.post('/pokemon', pokemon)
    },
    getNextPreviousPokemon(start, end) {
        return http.get(`/pokemon/${start}/${end}`)
    }
}
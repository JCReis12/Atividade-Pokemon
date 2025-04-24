package gerenciaPokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gerenciaPokemon.entities.Pokemon;
import gerenciaPokemon.repository.PokemonRepository;

@Service
public class PokemonService {
	
	private final PokemonRepository pokemonRepository;
	
	public PokemonService (PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
	
	public List<Pokemon> getAllPokemon(){
		return pokemonRepository.findAll();
	}
	
	public Pokemon getPokemonById(Long id) {
		Optional <Pokemon> Pokemon = pokemonRepository.findById(id);
		return Pokemon.orElse(null);
	}
	
	public Pokemon savePokemon (Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}
	
	public Pokemon alteraPokemon (Long id, Pokemon mudaPokemon) {
		Optional<Pokemon> existePokemon = pokemonRepository.findById(id);
		if(existePokemon.isPresent()) {
			mudaPokemon.setId(id);
			return pokemonRepository.save(mudaPokemon);
		}
		return null;
	}
	
	public boolean deletePokemon(Long id) {
		Optional <Pokemon> existePokemon = pokemonRepository.findById(id);
		if(existePokemon.isPresent()) {
			pokemonRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

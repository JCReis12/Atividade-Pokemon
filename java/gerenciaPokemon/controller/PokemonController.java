package gerenciaPokemon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerenciaPokemon.entities.Pokemon;
import gerenciaPokemon.service.PokemonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class PokemonController {
	
	private final PokemonService pokemonService;
	
	public PokemonController (PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id){
		Pokemon pokemon = pokemonService.getPokemonById(id);
		if(pokemon != null) {
			return ResponseEntity.ok(pokemon);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		List<Pokemon> pokemon = pokemonService.getAllPokemon();
		return ResponseEntity.ok(pokemon);
	}

	@PostMapping("/")
	public ResponseEntity<Pokemon> savePokemon(@RequestBody @Valid Pokemon pokemon){
		Pokemon salvaPokemon = pokemonService.savePokemon(pokemon);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPokemon);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pokemon> alteraPokemon(@PathVariable Long id, @RequestBody @Valid Pokemon pokemon){
		Pokemon alteraPokemon = pokemonService.alteraPokemon(id, pokemon);
		if(alteraPokemon != null) {
			return ResponseEntity.ok(pokemon);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> deletePokemon(@PathVariable Long id){
		boolean apagar = pokemonService.deletePokemon(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
}

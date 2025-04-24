package gerenciaPokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciaPokemon.entities.Pokemon;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {

}

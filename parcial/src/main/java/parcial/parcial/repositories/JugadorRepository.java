package parcial.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByNombresContaining(String nombres);

    List<Jugador> findByApellidosContaining(String apellidos);

    List<Jugador> findByNumeroGreaterThan(int numero);


}


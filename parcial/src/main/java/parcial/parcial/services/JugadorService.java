package parcial.parcial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador createJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = new Jugador();
        jugador.setNombres(jugadorDTO.getNombres());
        jugador.setApellidos(jugadorDTO.getApellidos());
        jugador.setNumero(jugadorDTO.getNumero());

        // Asignar equipo al jugador
        if (jugadorDTO.getEquipoId() != null) {
            Equipo equipo = equipoRepository.findById(jugadorDTO.getEquipoId()).orElse(null);
            jugador.setEquipo(equipo);
        }

        return jugadorRepository.save(jugador);
    }

    public Jugador updateJugador(Long id, JugadorDTO jugadorDTO) {
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);

        if (optionalJugador.isPresent()) {
            Jugador jugador = optionalJugador.get();
            jugador.setNombres(jugadorDTO.getNombres());
            jugador.setApellidos(jugadorDTO.getApellidos());
            jugador.setNumero(jugadorDTO.getNumero());

            // Actualizar equipo del jugador si se proporciona un nuevo equipoId
            if (jugadorDTO.getEquipoId() != null) {
                Equipo equipo = equipoRepository.findById(jugadorDTO.getEquipoId()).orElse(null);
                jugador.setEquipo(equipo);
            }

            return jugadorRepository.save(jugador);
        } else {
            // Manejar la no existencia del jugador (lanzar excepción o retornar null, según tu necesidad)
            return null;
        }
    }

    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}

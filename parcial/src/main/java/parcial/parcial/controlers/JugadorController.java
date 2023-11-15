package parcial.parcial.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public Jugador createJugador(@RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.createJugador(jugadorDTO);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.updateJugador(id, jugadorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
    }
}

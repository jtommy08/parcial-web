package parcial.parcial.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    @PostMapping
    public Equipo createEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.createEquipo(equipoDTO);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody EquipoDTO equipoDTO) {
        return equipoService.updateEquipo(id, equipoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
    }
}

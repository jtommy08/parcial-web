package parcial.parcial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo getEquipoById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo createEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setCiudad(equipoDTO.getCiudad());
        equipo.setCopasInternacionales(equipoDTO.getCopasInternacionales());

        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Long id, EquipoDTO equipoDTO) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);

        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.setNombre(equipoDTO.getNombre());
            equipo.setCiudad(equipoDTO.getCiudad());
            equipo.setCopasInternacionales(equipoDTO.getCopasInternacionales());

            return equipoRepository.save(equipo);
        } else {
            // Manejar la no existencia del equipo (lanzar excepción o retornar null, según tu necesidad)
            return null;
        }
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}

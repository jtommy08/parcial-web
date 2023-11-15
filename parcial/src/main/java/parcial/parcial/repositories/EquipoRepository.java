package parcial.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByCiudad(String ciudad);

    List<Equipo> findByCopasInternacionalesGreaterThan(int copas);

}
